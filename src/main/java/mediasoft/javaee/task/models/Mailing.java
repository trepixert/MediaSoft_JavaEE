package mediasoft.javaee.task.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private TypeOfPackage type;

    private Long recipientIndex;

    private String recipientAddress;

    private String recipientName;

    @OneToMany(mappedBy = "mailing",fetch = FetchType.EAGER)
    private List<HistoryOfMailing> historyOfMailings;

    public Mailing() {
    }

    public TypeOfPackage getType() {
        return type;
    }

    public void setType(TypeOfPackage type) {
        this.type = type;
    }

    public Long getRecipientIndex() {
        return recipientIndex;
    }

    public void setRecipientIndex(Long recipientIndex) {
        this.recipientIndex = recipientIndex;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HistoryOfMailing> getHistoryOfMailings() {
        return historyOfMailings;
    }

    public void setHistoryOfMailings(List<HistoryOfMailing> historyOfMailings) {
        this.historyOfMailings = historyOfMailings;
    }

    public void addWay(HistoryOfMailing historyOfMailing){
        this.historyOfMailings.add((historyOfMailing));
    }
}
