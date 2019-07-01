package mediasoft.javaee.task.services.Implementations;

import mediasoft.javaee.task.models.Mailing;
import mediasoft.javaee.task.repo.MailingRepo;
import mediasoft.javaee.task.services.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MailingServiceImpl implements MailingService {
    @Autowired
    private MailingRepo mailingRepo;

    @Override
    public List<Mailing> findAll() {
        return mailingRepo.findAll();
    }

    @Override
    public Optional<Mailing> findById(Long id) {
        return mailingRepo.findById(id);
    }

    @Override
    public void save(Mailing mailing) {
        mailingRepo.save(mailing);
    }
}
