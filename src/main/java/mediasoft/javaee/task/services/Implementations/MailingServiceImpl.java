package mediasoft.javaee.task.services.Implementations;

import mediasoft.javaee.task.models.HistoryOfMailing;
import mediasoft.javaee.task.models.Mailing;
import mediasoft.javaee.task.models.PostalOffice;
import mediasoft.javaee.task.models.Status;
import mediasoft.javaee.task.repo.HistoryOfMailingRepo;
import mediasoft.javaee.task.repo.MailingRepo;
import mediasoft.javaee.task.repo.PostalOfficeRepo;
import mediasoft.javaee.task.services.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MailingServiceImpl implements MailingService {
    @Autowired
    private MailingRepo mailingRepo;

    @Autowired
    private PostalOfficeRepo postalOfficeRepo;

    @Autowired
    private HistoryOfMailingRepo historyOfMailingRepo;

    @Override
    public List<Mailing> findAll() {
        return mailingRepo.findAll();
    }

    @Override
    public List<Mailing> findAllByPostalOffices(Long id) {
        return null;
    }

    @Override
    public Optional<Mailing> findById(Long id) {
        return mailingRepo.findById(id);
    }

    @Override
    public void save(Mailing mailing) {
        PostalOffice postalOffice = postalOfficeRepo.findById(mailing.getRecipientIndex())
                .orElseThrow(IllegalArgumentException::new);
        HistoryOfMailing historyOfMailing = new HistoryOfMailing(new Date(),Status.DEPARTED,postalOffice.getName(),mailing.getType());
        postalOffice.addMailingWay(historyOfMailing);
        mailing.addWay(historyOfMailing);
        historyOfMailing.setPostalOffice(postalOffice);
        historyOfMailing.setMailing(mailing);
        mailingRepo.save(mailing);
        postalOfficeRepo.save(postalOffice);
        historyOfMailingRepo.save(historyOfMailing);
    }
}
