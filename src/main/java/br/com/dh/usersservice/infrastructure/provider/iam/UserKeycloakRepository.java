package br.com.dh.usersservice.infrastructure.provider.iam;

import br.com.dh.usersservice.infrastructure.configuration.keycloak.properties.KeycloakProperties;
import br.com.dh.usersservice.users.domain.model.User;
import br.com.dh.usersservice.users.domain.repository.UserRepository;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserKeycloakRepository implements UserRepository {
    private final Keycloak keycloak;
    private final String realm;

    public UserKeycloakRepository(Keycloak keycloak, KeycloakProperties properties) {
        this.realm = properties.getRealm();
        this.keycloak = keycloak;
    }

    @Override
    public List<User> findAll() {
        return keycloak
                .realm(realm)
                    .users()
                .list()
                .stream()
                    .map(usuario ->
                         User.newUser(
                                usuario.getFirstName(),
                                usuario.getLastName(),
                                usuario.getAttributes().get("COR").get(0),
                                usuario.getAttributes().get("NACIONALIDADE").get(0))
                    ).toList();
    }

    @Override
    public void update(String id, String cor) {
        final var usuariosResource = keycloak.realm(realm).users();
        final var usuarioResource = usuariosResource.get(id);

        UserRepresentation usuario = usuarioResource.toRepresentation();

        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("COR", List.of(cor));
        usuario.setAttributes(attributes);

        usuarioResource.update(usuario);
    }
}