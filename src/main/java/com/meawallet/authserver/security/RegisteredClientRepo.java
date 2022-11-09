package com.meawallet.authserver.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

import static org.springframework.security.oauth2.core.AuthorizationGrantType.AUTHORIZATION_CODE;

@Component
@RequiredArgsConstructor
public class RegisteredClientRepo implements RegisteredClientRepository {

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(RegisteredClient registeredClient) {
        //Do nothing. Not used.
    }

    @Override
    public RegisteredClient findById(String id) {
        return registeredClient();
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return registeredClient();
    }

    private RegisteredClient registeredClient() {
        return RegisteredClient
                .withId("90ef5341-7e5a-482a-a6fb-049db7992301")
                .clientId("90ef5341-7e5a-482a-a6fb-049db7992301")
                .clientSecret(passwordEncoder.encode("secret"))
                .clientName("name")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AUTHORIZATION_CODE)
                .scope("openid")
                .redirectUri("http://127.0.0.1:3000/authorized")
                .build();
    }
}