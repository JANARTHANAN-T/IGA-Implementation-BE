package com.baeldung.service.repositaryServices;

import com.baeldung.domain.Article;
import com.baeldung.entity.UserEntity;
import com.baeldung.models.UserModel;
import com.baeldung.repositary.UserEntityRepositary;

public class UserRepToModel {
    public static UserModel createUserFromRep(Article article){
        UserModel userModel = new UserModel();
        userModel.setUser_id(article.getUserId());
        userModel.setEmail(article.getEmail());
        userModel.setRole(article.getRole());
        UserEntityRepositary rep = new UserEntityRepositary();
        rep.saveAndFlush(new UserEntity(userModel));

        return userModel;
    }
}
