package mediasoft.javaee.task.services;

import mediasoft.javaee.task.models.PostalOffice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostalOfficeService {
    List<PostalOffice> findAll();

    Optional<PostalOffice> findById(Long id);

    void save(PostalOffice postalOffice);

    Optional<PostalOffice> findByName(String name);
}
