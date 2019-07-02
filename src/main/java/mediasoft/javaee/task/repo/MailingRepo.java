package mediasoft.javaee.task.repo;

import mediasoft.javaee.task.models.Mailing;
import mediasoft.javaee.task.models.PostalOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailingRepo extends JpaRepository<Mailing, Long> {
    List<Mailing> findAllByPostalOffices(List<PostalOffice> postalOffices);
}
