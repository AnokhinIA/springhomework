package lesson30.JPA.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Insurers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String federalDistrict;
    private String address;
    private String name;
    private int personalTaxReferenceNumber;
    private String lineOfBusiness;
    private boolean cargo;
    private boolean motor;
    private boolean hull;
    private boolean property;

    @Override
    public String toString() {
        return "Наименоваение: " + name + " | Адрес: " + address + " | " + "\n";
    }
}

