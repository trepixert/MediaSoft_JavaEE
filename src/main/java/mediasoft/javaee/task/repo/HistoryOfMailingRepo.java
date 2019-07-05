package mediasoft.javaee.task.repo;

import mediasoft.javaee.task.models.HistoryOfMailing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryOfMailingRepo extends JpaRepository<HistoryOfMailing,Long> {
    List<HistoryOfMailing> findAllByMailing_Id(Long id);
}
