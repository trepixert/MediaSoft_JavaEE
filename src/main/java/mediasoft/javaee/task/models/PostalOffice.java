package mediasoft.javaee.task.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PostalOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long index;

    private String name;

    private String address;

    public PostalOffice() {
    }

    public PostalOffice(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "postalOffice")
    private List<HistoryOfMailing> historyOfMailings;

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
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public List<HistoryOfMailing> getHistoryOfMailings() {
        return historyOfMailings;
    }

    public void setHistoryOfMailings(List<HistoryOfMailing> historyOfMailings) {
        this.historyOfMailings = historyOfMailings;
    }

    public void addMailingWay(HistoryOfMailing historyOfMailing){
        this.historyOfMailings.add(historyOfMailing);
    }
}
