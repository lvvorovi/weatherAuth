package com.meawallet.authserver.security;

import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

import static org.springframework.security.oauth2.core.AuthorizationGrantType.AUTHORIZATION_CODE;

@Component
public class RegisteredClientRepo implements RegisteredClientRepository {

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return registeredClient(id);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return registeredClient(clientId);
    }

    private RegisteredClient registeredClient(String clientId) {
        return RegisteredClient
                .withId("90ef5341-7e5a-482a-a6fb-049db7992301")
                .clientId("90ef5341-7e5a-482a-a6fb-049db7992301")
                .clientSecret("secret")
                .clientName("name")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AUTHORIZATION_CODE)
                .scope("openid")
                .redirectUri("http://127.0.0.1:3000/authorized")
                .build();
    }
}
