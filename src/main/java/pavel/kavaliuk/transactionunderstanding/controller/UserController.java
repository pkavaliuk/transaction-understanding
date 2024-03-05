package pavel.kavaliuk.transactionunderstanding.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pavel.kavaliuk.transactionunderstanding.entity.TestUser;
import pavel.kavaliuk.transactionunderstanding.service.UserService;


@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("get-users")
    public List<TestUser> getMethodName() {
        return service.printAllUsers();
    }
    
}
