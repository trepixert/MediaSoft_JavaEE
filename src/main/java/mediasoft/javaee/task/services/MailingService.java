package mediasoft.javaee.task.services;

import mediasoft.javaee.task.models.Mailing;

import java.util.List;
import java.util.Optional;

public interface MailingService {
    List<Mailing> findAll();

    List<Mailing> findAllByPostalOffices(Long id);

    Optional<Mailing> findById(Long id);

    void save(Mailing mailing);
}
