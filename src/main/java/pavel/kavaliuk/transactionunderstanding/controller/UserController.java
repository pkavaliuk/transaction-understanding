package pavel.kavaliuk.transactionunderstanding.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.QueryParam;
import pavel.kavaliuk.transactionunderstanding.entity.TestUser;
import pavel.kavaliuk.transactionunderstanding.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

    @PostMapping("add-user")
    public ResponseEntity<TestUser> postMethodName(@RequestBody TestUser entity) {
        TestUser user = service.addUser(entity);
        return ResponseEntity.ok(user);
    }
    
    @PutMapping("update-fast")
    public ResponseEntity<TestUser> updateNameFast(@QueryParam("id") Integer id, @QueryParam("name") String name) {
        return ResponseEntity.ok(service.updateFast(id, name));
    }

    @PutMapping("update-slowly")
    public ResponseEntity<TestUser> updateNameSlowly(@QueryParam("id") Integer id, @QueryParam("name") String name) {
        return ResponseEntity.ok(service.updateSlowly(id, name));
    }

}
