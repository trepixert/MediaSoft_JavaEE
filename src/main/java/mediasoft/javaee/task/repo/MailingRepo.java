package mediasoft.javaee.task.repo;

import mediasoft.javaee.task.models.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailingRepo extends JpaRepository<Mailing, Long> {
}
