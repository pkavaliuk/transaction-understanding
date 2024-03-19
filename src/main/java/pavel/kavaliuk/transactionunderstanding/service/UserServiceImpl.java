package pavel.kavaliuk.transactionunderstanding.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import pavel.kavaliuk.transactionunderstanding.entity.TestUser;
import pavel.kavaliuk.transactionunderstanding.repository.UserRepository;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TestUser> printAllUsers() {
        return repository.findAll();
    }

    @Override
    public TestUser addUser(final TestUser testUser) {

        return repository.save(testUser);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public TestUser updateFast(Integer id, String name) {
        TestUser entity = repository.findById(id).get();
        log.info("Update fast id [{}] name [{}]", id, name);
        entity.setName(name);
        return repository.saveAndFlush(entity);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public TestUser updateSlowly(Integer id, String name) {
        log.info("Update slowly id [{}] name [{}]", id, name);
        TestUser entity = repository.findById(id).get();
        entity.setName(name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return repository.saveAndFlush(entity);
    }
}
