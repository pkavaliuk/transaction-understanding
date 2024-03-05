package pavel.kavaliuk.transactionunderstanding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pavel.kavaliuk.transactionunderstanding.entity.TestUser;
import pavel.kavaliuk.transactionunderstanding.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TestUser> printAllUsers() {
        return repository.findAll();
    }
}
