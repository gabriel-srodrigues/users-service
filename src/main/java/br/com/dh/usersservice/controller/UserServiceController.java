package br.com.dh.usersservice.controller;

import br.com.dh.usersservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/users")
public class UserServiceController {
    private final UserService userService;

    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<String>> search() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("{username}/{cor}")
    public ResponseEntity<String> addCor(@PathVariable String username, @PathVariable String cor) {
        return ResponseEntity.ok(userService.addCor(username, cor));
    }
}
