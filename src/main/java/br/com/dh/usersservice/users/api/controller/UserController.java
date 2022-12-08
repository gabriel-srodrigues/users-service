package br.com.dh.usersservice.users.api.controller;

import br.com.dh.usersservice.users.api.assembler.UserMapper;
import br.com.dh.usersservice.users.api.dto.UserResponse;
import br.com.dh.usersservice.users.api.openapi.UserApi;
import br.com.dh.usersservice.users.domain.model.User;
import br.com.dh.usersservice.users.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<?> search() {
        List<User> allUsers = userService.search();
        final var response = allUsers.stream().map(mapper::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserResponse> findByID(String id) {
        User user = userService.findByID(id);
        UserResponse response = mapper.toResponse(user);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> update(String cor, String id) {
        userService.update(id, cor);
        return ResponseEntity.ok().build();
    }
}
