package letscode.sarafan.repository;

import letscode.sarafan.domain.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 29.10.2018.
 * @version $Id$.
 * @since 0.1.
 */
@Component
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Override
    Optional<Message> findById(Long id);
}
