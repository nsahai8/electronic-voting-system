package service;

import model.User;

public class UserService {

    public boolean isUserBlacklisted(User user) {
        if (user == null) {
            return false;
        }
        return user.isBlackListed();
    }

}
