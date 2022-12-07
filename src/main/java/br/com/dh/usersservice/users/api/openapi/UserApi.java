package br.com.dh.usersservice.users.api.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
public interface UserApi {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> search();

    @PutMapping("{id}")
    ResponseEntity<?> update(@RequestParam String cor, @PathVariable String id);
}
