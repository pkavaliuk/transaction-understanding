package pavel.kavaliuk.transactionunderstanding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "test_user")
public class TestUser {

    @Id
    private Integer id;
    private String name;

}
