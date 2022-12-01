package br.com.dh.usersservice.users.api.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("v1/users")
public interface UserApi {

    @GetMapping
    ResponseEntity<?> search();

    @RequestMapping("{id}")
    ResponseEntity<?> update(@RequestParam String cor, @PathVariable String id);
}
