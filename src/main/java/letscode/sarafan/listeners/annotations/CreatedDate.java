package letscode.sarafan.listeners.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 25.11.2018.
 * @version $Id$.
 * @since 0.1.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface CreatedDate {
}
