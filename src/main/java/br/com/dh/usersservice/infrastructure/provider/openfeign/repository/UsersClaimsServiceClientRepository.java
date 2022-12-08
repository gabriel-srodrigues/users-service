package br.com.dh.usersservice.infrastructure.provider.openfeign.repository;

import br.com.dh.usersservice.infrastructure.configuration.openfeign.KeycloakInterceptorConfiguration;
import br.com.dh.usersservice.infrastructure.provider.openfeign.model.UsersClaimsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-claims-service", url = "http://localhost:8081/", configuration = KeycloakInterceptorConfiguration.class)
public interface UsersClaimsServiceClientRepository {

    @GetMapping("{userID}")
    ResponseEntity<UsersClaimsResponse> get(@PathVariable String userID);

}
