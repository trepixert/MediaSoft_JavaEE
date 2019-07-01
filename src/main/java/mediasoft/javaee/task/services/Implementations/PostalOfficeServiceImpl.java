package mediasoft.javaee.task.services.Implementations;

import mediasoft.javaee.task.models.PostalOffice;
import mediasoft.javaee.task.repo.PostalOfficeRepo;
import mediasoft.javaee.task.services.PostalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostalOfficeServiceImpl implements PostalOfficeService {
    @Autowired
    private PostalOfficeRepo postalOfficeRepo;

    @Override
    public List<PostalOffice> findAll() {
        return postalOfficeRepo.findAll();
    }

    @Override
    public Optional<PostalOffice> findById(Long id) {
        return postalOfficeRepo.findById(id);
    }

    @Override
    public void save(PostalOffice postalOffice) {
        postalOfficeRepo.save(postalOffice);
    }

    @Override
    public Optional<PostalOffice> findByName(String name) {
        return (postalOfficeRepo.findByName(name));
    }
}
