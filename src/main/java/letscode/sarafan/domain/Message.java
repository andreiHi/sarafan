package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.listeners.MessageListener;
import letscode.sarafan.listeners.annotations.CreatedDate;
import letscode.sarafan.listeners.annotations.UpdateDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 29.10.2018.
 * @version $Id$.
 * @since 0.1.
 */
@Entity
@EntityListeners(MessageListener.class)
@Table
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
//@ToString(of = {"id", "text"})
public class Message {

    @Id
    @GeneratedValue(generator = Constans.ID_GENERATOR)
    @Column(nullable = false, unique = true)
    @JsonView(Views.Id.class)
    private Long id;

    @JsonView(Views.IdName.class)
    private String text;

    @CreatedDate
    @Column(updatable = false, length = 2000) //не будет фигурировать в запросах на обнавление
    @JsonView(Views.FullMessage.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.OffsetDateTimeType")
    private OffsetDateTime creationDate;


    @CreatedDate
    @UpdateDate
    @JsonView(Views.FullMessage.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.OffsetDateTimeType")
    private OffsetDateTime updateDate;

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

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
//                ", creationDate=" + creationDate +
//                ", updateDate=" + updateDate +
                '}';
    }
}
