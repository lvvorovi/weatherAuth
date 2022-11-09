package com.meawallet.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthserverApplication {

    /*
    в браузере localhost:9090/oauth2/authorize?response_type=code&client_id=90ef5341-7e5a-482a-a6fb-049db7992301&scope=openid&redirect_uri=http://127.0.0.1:3000/authorized&code_challenge=dPz8OFyP8g1yHdxiH6lyoQnALCUbUUclGilMBtf7ksg&code_challenge_method=S256

    user credentials
    username: user
    password: password


    POSTMAN POST http://localhost:9090/oauth2/token?code={code_from_first_request}&redirect_uri=http://127.0.0.1:3000/authorized&grant_type=authorization_code&code_verifier=2iQIug_f4iSFuun2ktC02Yh4TpMykSEUxdNpYk_er2k
    * */

    public static void main(String[] args) {
        SpringApplication.run(AuthserverApplication.class, args);
    }

}
