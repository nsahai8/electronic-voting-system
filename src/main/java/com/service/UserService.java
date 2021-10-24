package com.service;

import com.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean isUserBlacklisted(User user) {
        if (user == null) {
            return false;
        }
        return user.isBlackListed();
    }

}
