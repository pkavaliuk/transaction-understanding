package pavel.kavaliuk.transactionunderstanding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "test_user")
public class TestUser {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "test_user_seq")
    @SequenceGenerator(name = "test_user_seq", sequenceName = "test_user_seq", allocationSize = 1)
    private Integer id;
    private String name;

}
