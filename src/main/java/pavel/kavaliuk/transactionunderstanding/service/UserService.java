package pavel.kavaliuk.transactionunderstanding.service;

import java.util.List;

import pavel.kavaliuk.transactionunderstanding.entity.TestUser;

public interface UserService {

    List<TestUser> printAllUsers();

    TestUser addUser(TestUser testUser);

    TestUser updateFast(Integer id, String name);

    TestUser updateSlowly(Integer id, String name);

}