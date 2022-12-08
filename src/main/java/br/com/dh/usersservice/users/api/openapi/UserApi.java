package br.com.dh.usersservice.users.api.openapi;

import br.com.dh.usersservice.users.api.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
public interface UserApi {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> search();

    @GetMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<UserResponse> findByID(@PathVariable String id);

    @PutMapping("{id}")
    ResponseEntity<?> update(@RequestParam String cor, @PathVariable String id);
}
