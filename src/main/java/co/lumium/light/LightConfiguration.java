package co.lumium.light;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LightConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/health/**").permitAll()
                        .requestMatchers("/light/public").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2-> oauth2
                        .jwt(jwt -> jwt
                                .jwkSetUri("http://authorization:80/oauth2/jwks")
                        )
                );
        return httpSecurity.build();
    }
}
