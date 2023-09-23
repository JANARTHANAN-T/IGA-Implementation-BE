package com.baeldung.service.repositaryServices;

import com.baeldung.domain.Article;
import com.baeldung.domain.User;
import com.baeldung.entity.UserEntity;
import com.baeldung.models.UserModel;
import com.baeldung.repositary.UserEntityRepositary;

public class UserRepToModel {
    public static UserModel createUserFromRep(User user){
        UserModel userModel = new UserModel();
        userModel.setUser_id(user.getUserId());
        userModel.setEmail(user.getEmail());
        userModel.setRole(user.getRole());
        UserEntityRepositary rep = new UserEntityRepositary();
        rep.saveAndFlush(new UserEntity(userModel));

        return userModel;
    }
}
