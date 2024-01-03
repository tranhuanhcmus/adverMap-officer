package com.adsmanagement.users;

import com.adsmanagement.users.dto.CreateUserDTO;
import com.adsmanagement.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    public User save(CreateUserDTO createUserDTO) {
        User user = createUserDTO.ToUser();

        var bcryptEncoder  = new BCryptPasswordEncoder();
        var bcryptPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(bcryptPassword);

        return this.userRepository.save(user);
    }

}
