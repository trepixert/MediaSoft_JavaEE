package mediasoft.javaee.task.models;

import javax.persistence.*;

@Entity
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Enumerated(value = EnumType.STRING)
    private TypeOfPackage type;

    private Long recipientIndex;

    private Long recipientAddress;

    private String recipientName;

    @ManyToOne
    private PostalOffice postalOffices;

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

    public Long getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(Long recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
