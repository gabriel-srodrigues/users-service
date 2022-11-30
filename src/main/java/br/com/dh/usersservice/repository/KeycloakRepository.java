package br.com.dh.usersservice.repository;

import br.com.dh.usersservice.configuration.properties.KeycloakProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KeycloakRepository {

    private final Keycloak keycloak;
    private final KeycloakProperties properties;

    public KeycloakRepository(Keycloak keycloak, KeycloakProperties properties) {
        this.keycloak = keycloak;
        this.properties = properties;
    }

    public List<String> findAll() {
        return keycloak
                .realm(properties.getRealm())
                    .users()
                    .list()
                        .stream()
                            .map(UserRepresentation::getFirstName).toList();
    }

    public String addCor(String username, String cor) {
        final var usuariosResource = keycloak.realm(properties.getRealm()).users();
        final var usuarioResource = usuariosResource.get(username);

        UserRepresentation usuario = usuarioResource.toRepresentation();

        Map<String, List<String>> attributes = new HashMap<>();
            attributes.put("photoURL", List.of("https://www.pngwing.com/pt/free-png-xsukd"));
        attributes.put("COR", List.of(cor));
        usuario.setAttributes(attributes);

        usuarioResource.update(usuario);
        return "Usuario possui nova cor";
    }
}
