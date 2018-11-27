package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Message;
import letscode.sarafan.domain.Views;
import letscode.sarafan.exceptions.NotFoundException;
import letscode.sarafan.repository.MessageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.completedFuture;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 13.10.2018.
 * @version $Id$.
 * @since 0.1.
 */
@RestController
@RequestMapping("message")
public class MessageController {

    private final MessageRepository messageRepo;

    public MessageController(MessageRepository repository) {
        messageRepo = repository;
    }

    @Async
    @GetMapping
    @JsonView(Views.IdName.class)
    public CompletableFuture<ResponseEntity> list() {
        List<Message> all = messageRepo.findAll();
        System.out.println(all);
        return completedFuture(all)
                .thenApply(ResponseEntity::ok);
    }

    @Async
    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public CompletableFuture<ResponseEntity> getOne(@PathVariable Long id) {
        return completedFuture(messageRepo.findById(id)
                .orElseThrow(NotFoundException::new))
                .thenApply(ResponseEntity::ok);
    }


    @Async
    @PostMapping
    public CompletableFuture<ResponseEntity> create(@RequestBody Message message) {
        System.out.println(message);
        return completedFuture(messageRepo.save(message))
                .thenApply(ResponseEntity::ok);
    }

    @Async
    @PutMapping("{id}")
    public CompletableFuture<ResponseEntity> updateMessage(@RequestBody Message message,
                                             @PathVariable("id") Message messageDb) {
        BeanUtils.copyProperties(message, messageDb, "id");
       return completedFuture(messageRepo.save(messageDb)).thenApply(ResponseEntity::ok);
    }

    @Async
    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }

    @MessageMapping("/changeMessage")
    @SendTo("/topic/activity")
    public Message message(Message message) {
        return messageRepo.save(message);
    }
}