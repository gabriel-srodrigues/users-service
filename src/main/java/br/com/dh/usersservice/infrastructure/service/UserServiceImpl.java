package br.com.dh.usersservice.infrastructure.service;

import br.com.dh.usersservice.infrastructure.provider.openfeign.model.UsersClaimsResponse;
import br.com.dh.usersservice.infrastructure.provider.openfeign.repository.UsersClaimsServiceClientRepository;
import br.com.dh.usersservice.users.domain.model.User;
import br.com.dh.usersservice.users.domain.repository.UserRepository;
import br.com.dh.usersservice.users.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UsersClaimsServiceClientRepository claimsRestClient;


    public UserServiceImpl(UserRepository repository, UsersClaimsServiceClientRepository claimsRestClient) {
        this.repository = repository;
        this.claimsRestClient = claimsRestClient;
    }

    @Override
    public List<User> search() {
        return repository.findAll();
    }

    @Override
    public void update(String id, String cor) {
        repository.update(id, cor);
    }

    @Override
    public User findByID(String id) {
        var user = repository.findByID(id);
        ResponseEntity<UsersClaimsResponse> usersClaims = claimsRestClient.get(id);
        if (usersClaims.getStatusCode().value() == 200) {
            UsersClaimsResponse body = usersClaims.getBody();
            assert body != null;
            return User.newUser(user.getNome(),
                    user.getSobrenome(),
                    body.getCor(),
                    body.getNacionalidade());
        } else
            throw new RuntimeException("Um erro ocorreu");
    }
}
