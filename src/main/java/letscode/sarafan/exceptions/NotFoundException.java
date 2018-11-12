package letscode.sarafan.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 13.10.2018.
 * @version $Id$.
 * @since 0.1.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

}
