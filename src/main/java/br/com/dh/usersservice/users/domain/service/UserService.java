package br.com.dh.usersservice.users.domain.service;

import br.com.dh.usersservice.users.domain.model.User;

import java.util.List;

public interface UserService {

    List<User> search();

    void update(String id, String cor);

    User findByID(String id);
}
