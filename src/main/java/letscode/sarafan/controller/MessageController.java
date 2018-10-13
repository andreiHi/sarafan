package letscode.sarafan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 13.10.2018.
 * @version $Id$.
 * @since 0.1.
 */
@RestController
@RequestMapping("message")
public class MessageController {

    @GetMapping
    public String list() {
        return "index";
    }
}
