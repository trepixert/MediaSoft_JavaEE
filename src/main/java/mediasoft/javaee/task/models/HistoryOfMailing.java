package mediasoft.javaee.task.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryOfMailing {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfEvent;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String nameOfOffice;

    @Enumerated(EnumType.STRING)
    private TypeOfPackage type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(
            name = "office_id",
            referencedColumnName = "index",
            updatable = false)
    private PostalOffice postalOffice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(
            name = "mailing_id",
            referencedColumnName = "id",
            updatable = false)
    private Mailing mailing;

    public HistoryOfMailing() {
    }

    public HistoryOfMailing(Date dateOfEvent, Status status, String nameOfOffice, TypeOfPackage type) {
        this.dateOfEvent = dateOfEvent;
        this.status = status;
        this.nameOfOffice = nameOfOffice;
        this.type = type;
    }

    public HistoryOfMailing(Date dateOfEvent, Status status, PostalOffice postalOffice, Mailing mailing) {
        this.dateOfEvent = dateOfEvent;
        this.status = status;
        this.postalOffice = postalOffice;
        this.mailing = mailing;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PostalOffice getPostalOffice() {
        return postalOffice;
    }

    public void setPostalOffice(PostalOffice postalOffice) {
        this.postalOffice = postalOffice;
    }

    public Mailing getMailing() {
        return mailing;
    }

    public void setMailing(Mailing mailing) {
        this.mailing = mailing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfOffice() {
        return nameOfOffice;
    }

    public void setNameOfOffice(String nameOfOffice) {
        this.nameOfOffice = nameOfOffice;
    }

    public TypeOfPackage getType() {
        return type;
    }

    public void setType(TypeOfPackage type) {
        this.type = type;
    }
}
