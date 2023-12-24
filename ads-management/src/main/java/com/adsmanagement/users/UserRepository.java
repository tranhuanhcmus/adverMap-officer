package com.adsmanagement.users;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Short> {
    Optional<User> findByName(String username);

    Optional<User> findByEmail(String email);

}