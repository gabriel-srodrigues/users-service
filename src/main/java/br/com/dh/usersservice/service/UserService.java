package br.com.dh.usersservice.service;

import br.com.dh.usersservice.repository.KeycloakRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final KeycloakRepository repository;

    public UserService(KeycloakRepository repository) {
        this.repository = repository;
    }

    public List<String> getUsers() {
        return repository.findAll();
    }

    public String addCor(String username, String cor) {
        return repository.addCor(username, cor);
    }
}
