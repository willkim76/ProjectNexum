package activity;

import dao.UserDao;

import javax.inject.Inject;

public class UserLoginActivity {
    private UserDao userDao;

    @Inject
    public UserLoginActivity(UserDao userDao) {
        this.userDao = userDao;
    }
}
