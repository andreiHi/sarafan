package letscode.sarafan.repository;

import letscode.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 08.11.2018.
 * @version $Id$.
 * @since 0.1.
 */
public interface UserDetailsRepo extends JpaRepository<User, String> {
}
