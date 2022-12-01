package br.com.dh.usersservice.infrastructure.configuration.keycloak;

import br.com.dh.usersservice.infrastructure.configuration.keycloak.properties.KeycloakProperties;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

    private final KeycloakProperties properties;

    public KeycloakConfiguration(KeycloakProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Keycloak instance() {
        return KeycloakBuilder.builder()
                .clientId(properties.getClientId())
                .realm(properties.getRealm())
                .serverUrl(properties.getServerUrl())
                .clientSecret(properties.getClientSecret())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }


}
