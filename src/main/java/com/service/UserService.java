package com.service;

import com.model.User;
import org.springframework.stereotype.Service;

/*
    This service contains the logic on User Data entity
*/
@Service
public class UserService {

    public boolean isUserBlacklisted(User user) {
        if (user == null) {
            return false;
        }
        return user.isBlackListed();
    }

}
