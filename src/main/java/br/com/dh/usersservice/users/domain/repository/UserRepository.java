package br.com.dh.usersservice.users.domain.repository;

import br.com.dh.usersservice.users.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    void update(String id, String cor);

    User findByID(String id);
}
