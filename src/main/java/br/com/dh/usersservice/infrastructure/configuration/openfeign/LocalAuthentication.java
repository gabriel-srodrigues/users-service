package br.com.dh.usersservice.infrastructure.configuration.openfeign;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import java.util.Collection;
import java.util.List;

public class LocalAuthentication implements Authentication {
    private final ClientRegistration clientRegistration;

    public LocalAuthentication(ClientRegistration clientRegistration) {
        this.clientRegistration = clientRegistration;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return clientRegistration.getClientId();
    }
}
