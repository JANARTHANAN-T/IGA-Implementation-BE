package com.baeldung.service.repositaryServices;

import com.baeldung.domain.Article;
import com.baeldung.domain.User;
import com.baeldung.entity.UserEntity;
import com.baeldung.models.UserModel;
import com.baeldung.repositary.UserEntityRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserRepToModel {


    public static  UserModel createUserFromRep(User user){
        UserModel userModel = new UserModel();
        userModel.setUser_id(user.getUserId());
        userModel.setEmail(user.getEmail());
        userModel.setRole(user.getRole());

        return userModel;
    }
}
