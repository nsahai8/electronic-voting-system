package com.service;

import com.model.User;

public class UserService {

    public boolean isUserBlacklisted(User user){
        if(user == null){
            return false;
        }
        return user.isBlackListed();
    }

}
