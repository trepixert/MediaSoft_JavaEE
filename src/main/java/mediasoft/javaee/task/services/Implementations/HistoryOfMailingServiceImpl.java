package mediasoft.javaee.task.services.Implementations;

import mediasoft.javaee.task.models.HistoryOfMailing;
import mediasoft.javaee.task.models.Mailing;
import mediasoft.javaee.task.models.PostalOffice;
import mediasoft.javaee.task.models.Status;
import mediasoft.javaee.task.repo.HistoryOfMailingRepo;
import mediasoft.javaee.task.repo.MailingRepo;
import mediasoft.javaee.task.repo.PostalOfficeRepo;
import mediasoft.javaee.task.services.HistoryOfMailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryOfMailingServiceImpl implements HistoryOfMailingService {
    @Autowired
    private HistoryOfMailingRepo repo;

    @Autowired
    private PostalOfficeRepo postalOfficeRepo;

    @Autowired
    private MailingRepo mailingRepo;

    @Override
    public void prepareToDepart(Long mailingId, Long indexOfAnotherPostalOffice) {
        PostalOffice postalOffice = postalOfficeRepo.findById(indexOfAnotherPostalOffice)
                .orElseThrow(() -> new IllegalArgumentException("Не найден"));
        HistoryOfMailing lastHistory = checkAndFindLastHistory(mailingId);
        Mailing mailing = lastHistory.getMailing();
        HistoryOfMailing historyOfMailing = new HistoryOfMailing(new Date(),Status.DEPARTED,postalOffice,mailing);
        historyOfMailing.setNameOfOffice(postalOffice.getName());
        historyOfMailing.setType(mailing.getType());
        postalOffice.addMailingWay(historyOfMailing);
        mailing.addWay(historyOfMailing);
        historyOfMailing.setPostalOffice(postalOffice);
        historyOfMailing.setMailing(mailing);
        mailingRepo.save(mailing);
        postalOfficeRepo.save(postalOffice);
        repo.save(historyOfMailing);
    }

    @Override
    public void prepareToArrive(Long mailingId) {
        initMailing(mailingId, Status.ARRIVED);
    }

    @Override
    public void prepareToReceive(Long mailingId) {
        initMailing(mailingId, Status.RECEIVED);
    }

    private void initMailing(Long mailingId, Status received) {
        HistoryOfMailing lastHistory = checkAndFindLastHistory(mailingId);
        HistoryOfMailing newHistory = new HistoryOfMailing();
        newHistory.setDateOfEvent(new Date());
        newHistory.setStatus(received);
        newHistory.setMailing(lastHistory.getMailing());
        newHistory.setPostalOffice(lastHistory.getPostalOffice());
        newHistory.setType(lastHistory.getType());
        newHistory.setNameOfOffice(lastHistory.getNameOfOffice());
        repo.save(newHistory);
    }

    private HistoryOfMailing checkAndFindLastHistory(Long mailingId) {
        List<HistoryOfMailing> history = repo.findAllByMailing_Id(mailingId);
        HistoryOfMailing lastHistory = history.get(history.size() - 1);
        if (lastHistory.getStatus().equals(Status.RECEIVED)) {
            throw new IllegalArgumentException("Это почтовое отправление уже доставлено конечному получателю");
        }
        return lastHistory;
    }

    @Override
    public List<HistoryOfMailing> findAll() {
        return repo.findAll();
    }

    @Override
    public List<HistoryOfMailing> findAllByMailing_Id(Long mailingId) {
        return repo.findAllByMailing_Id(mailingId);
    }
}
