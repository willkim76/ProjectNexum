package activity;

import dao.UserDao;

import javax.inject.Inject;

public class CreateNewUserActivity {
    private UserDao userDao;

    @Inject
    public CreateNewUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }
}
