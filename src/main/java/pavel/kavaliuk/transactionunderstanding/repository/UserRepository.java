package pavel.kavaliuk.transactionunderstanding.repository;

import org.springframework.stereotype.Repository;

import pavel.kavaliuk.transactionunderstanding.entity.TestUser;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<TestUser, Integer> {

}
