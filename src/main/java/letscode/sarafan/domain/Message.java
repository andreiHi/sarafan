package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 29.10.2018.
 * @version $Id$.
 * @since 0.1.
 */
@Entity
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
//@ToString(of = {"id", "text"})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    @JsonView(Views.Id.class)
    private Long id;

    @JsonView(Views.IdName.class)
    private String text;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(Views.FullMessage.class)
    private LocalDateTime creationDate;

    @Override
    public String toString() {
        return String.format("Message{ id= '%d', text='%s'}", id, text);
    }


    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
