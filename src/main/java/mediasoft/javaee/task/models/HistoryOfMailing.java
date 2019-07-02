package mediasoft.javaee.task.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryOfMailing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateOfEvent;

    @Enumerated(EnumType.STRING)
    private Status status;
}
