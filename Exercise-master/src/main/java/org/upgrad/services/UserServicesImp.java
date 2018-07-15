package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.User;
import org.upgrad.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServicesImp implements UserService {

    private final UserRepository userRepository;

    public UserServicesImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUserDetails(String userName, String email, String password, String role) {
        userRepository.addUserDetails ( userName, email, password, role );
    }

    @Override
    public int findUserId() {
        int id = userRepository.findLastAddedUserId ();
        return id;
    }

    @Override
    public String findUserByUsername(String userName) {
        String user = userRepository.findUserByName ( userName );
        return user;
    }

    @Override
    public String findUserByEmail(String email) {
        String mailId = userRepository.findUserByEmailId ( email );
        return mailId;
    }

    @Override
    public String findUserPassword(String userName) {
        return userRepository.findUserPasswordByName ( userName );
    }

    @Override
    public String findUserRole(String userName) {
        return userRepository.findUserRoleByName ( userName );
    }

    @Override
    public User getUserDetail(Integer user_id) {
        Optional <User> optionalUser = userRepository.findById ( user_id );
        User user = null;
        if (optionalUser.isPresent ()) {
            user = optionalUser.get ();
        }
        return user;
    }

}
