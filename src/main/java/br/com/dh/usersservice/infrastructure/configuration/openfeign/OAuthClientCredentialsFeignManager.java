package br.com.dh.usersservice.infrastructure.configuration.openfeign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import java.util.Objects;

@Slf4j

public class OAuthClientCredentialsFeignManager {

    private final OAuth2AuthorizedClientManager manager;
    private final Authentication principal;
    private final ClientRegistration clientRegistration;


    public OAuthClientCredentialsFeignManager(OAuth2AuthorizedClientManager manager,
                                              ClientRegistration clientRegistration) {
        this.manager = manager;
        this.clientRegistration = clientRegistration;
        this.principal = createPrincipal();
    }

    public String getAccessToken() {
        try {
            OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                    .withClientRegistrationId(this.clientRegistration.getRegistrationId())
                    .principal(this.principal)
                    .build();
            OAuth2AuthorizedClient client = manager.authorize(request);
            if (Objects.isNull(client)) {
                throw new IllegalAccessException("Um erro ocorreu autenticando nosso cliente");
            }
            log.info(client.getAccessToken().getTokenValue());
            return client.getAccessToken().getTokenValue();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Authentication createPrincipal() {
        return new LocalAuthentication(this.clientRegistration);
    }
}
