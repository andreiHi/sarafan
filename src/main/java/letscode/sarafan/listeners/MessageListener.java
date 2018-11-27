package letscode.sarafan.listeners;

import letscode.sarafan.domain.Message;
import letscode.sarafan.listeners.annotations.CreatedDate;
import letscode.sarafan.listeners.annotations.UpdateDate;
import org.springframework.util.ReflectionUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 25.11.2018.
 * @version $Id$.
 * @since 0.1.
 */
public class MessageListener {

    @PrePersist
    public void prePersist(Message message) {
        Class mClass = message.getClass();
        Field[] fields = mClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CreatedDate.class)) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, message, OffsetDateTime.now());
            }
        }
    }

    @PreUpdate
    public void preUpdate(Message message) {
        Class aClass = message.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(UpdateDate.class)) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, message, OffsetDateTime.now());
            }
        }
    }
}
