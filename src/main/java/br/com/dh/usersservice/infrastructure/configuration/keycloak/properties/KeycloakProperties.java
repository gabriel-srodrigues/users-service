package br.com.dh.usersservice.infrastructure.configuration.keycloak.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
@ConfigurationProperties(value = "app.authentication.keycloak")
public class KeycloakProperties {
    private String realm;
    private String serverUrl;
    private String clientId;
    private String clientSecret;


    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString() {
        return "KeycloakConfiguration{" +
                "realm='" + realm + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }

    @PostConstruct
    public void showVariables() {
        //modo debug - log.debug(toString());
        System.out.println(this.toString());
    }
}
