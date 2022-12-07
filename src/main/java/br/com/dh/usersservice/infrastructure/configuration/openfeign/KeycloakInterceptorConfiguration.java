package br.com.dh.usersservice.infrastructure.configuration.openfeign;

import feign.RequestInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
@AllArgsConstructor
public class KeycloakInterceptorConfiguration {
    private static final String CLIENT_REGISTRATION_ID = "api-gateway-registration";

    private final Oauth2AuthorizationClientService clientService;
    private final ClientRegistrationRepository repository;

    @Bean
    public RequestInterceptor requestInterceptor() {
        final ClientRegistration client = repository.findByRegistrationId(CLIENT_REGISTRATION_ID);
        return null;

    }

}

