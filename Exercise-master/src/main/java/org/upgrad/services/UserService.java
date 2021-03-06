package org.upgrad.services;

import org.upgrad.model.User;

public interface UserService {

    void addUserDetails(String userName, String email, String password, String role);

    int findUserId();

    String findUserByUsername(String userName);

    String findUserByEmail(String email);

    String findUserPassword(String userName);

    String findUserRole(String userName);

    String findUserById(int id);

    int findUserIdByName(String userName);

    void deleteUserDetailsById(int userId);

    User getUserDetail(Integer user_id);

}
