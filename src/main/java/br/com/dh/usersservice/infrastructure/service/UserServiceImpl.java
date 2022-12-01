package br.com.dh.usersservice.infrastructure.service;

import br.com.dh.usersservice.users.domain.model.User;
import br.com.dh.usersservice.users.domain.repository.UserRepository;
import br.com.dh.usersservice.users.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> search() {
        return repository.findAll();
    }

    @Override
    public void update(String id, String cor) {
        repository.update(id, cor);
    }
}
