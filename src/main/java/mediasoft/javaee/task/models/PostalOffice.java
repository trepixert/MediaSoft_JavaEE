package mediasoft.javaee.task.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PostalOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Index;

    private String name;

    private String address;

    public PostalOffice() {
    }

    public PostalOffice(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @OneToMany(mappedBy = "postalOffices")
    private List<Mailing> mailings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getIndex() {
        return Index;
    }

    public void setIndex(Long index) {
        Index = index;
    }
}
