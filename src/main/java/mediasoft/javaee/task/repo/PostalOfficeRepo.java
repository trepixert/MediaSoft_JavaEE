package mediasoft.javaee.task.repo;

import mediasoft.javaee.task.models.PostalOffice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostalOfficeRepo extends JpaRepository<PostalOffice, Long> {
    Optional<PostalOffice> findByName(String name);
}
