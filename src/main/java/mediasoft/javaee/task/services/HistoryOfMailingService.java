package mediasoft.javaee.task.services;

import mediasoft.javaee.task.models.HistoryOfMailing;

import java.util.List;

public interface HistoryOfMailingService {
    void prepareToDepart(Long mailingId, Long indexOfAnotherPostalOffice);
    void prepareToArrive(Long mailingId);
    void prepareToReceive(Long mailingId);
    List<HistoryOfMailing> findAll();
    List<HistoryOfMailing> findAllByMailing_Id(Long mailingId);
}
