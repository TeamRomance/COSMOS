package teamromance.cosmos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import teamromance.cosmos.repository.user.UserRepository;
import teamromance.cosmos.security.auth.CustomUserDetailService;
import teamromance.cosmos.security.handler.CustomLoginFailureHandler;
import teamromance.cosmos.security.handler.CustomLoginSuccessHandler;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    private final CustomLoginFailureHandler customLoginFailureHandler;

//    @Value("${security.user.username}")
//    private String userUsername;
//    @Value("${security.user.password}")
//    private String userPassword;
//    @Value("${security.admin.username}")
//    private String adminUsername;
//    @Value("${security.admin.password}")
//    private String adminPassword;

/*
    public SecurityConfig(CustomLoginFailureHandler customLoginFailureHandler) {
        this.customLoginFailureHandler = customLoginFailureHandler;
    }
*/


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests((authorize) -> authorize
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/docs/**").hasRole("ADMIN")
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/login/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage("/login")
                                .successHandler(new CustomLoginSuccessHandler())
//                        .failureHandler(customLoginFailureHandler)
                                .failureHandler(new CustomLoginFailureHandler())
                                .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied")
                )
                .requiresChannel(
                        channel -> channel
                                .anyRequest().requiresSecure() // HTTPS 강제
                );
        return http.build();
    }


    /**
     * 초기 개발 단계 - 인 메모리 인증
     */
/*
    @Bean
    public UserDetailsService users() {

        // 사용자
        UserDetails user = User.withUsername(userUsername)
                .password("{noop}" + userPassword)
                .roles("USER")
                .build();

        // 어드민
        UserDetails admin = User.withUsername(adminUsername)
                .username("{noop}" + adminPassword)
                .password("1234")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
*/

    // 패스워드 인코더 설정
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // UserDetailsService를 CustomUserDetailService로 등록
    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailService(userRepository);
    }

    // AuthenticationManager 설정
    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
        daoProvider.setUserDetailsService(userDetailsService);
        daoProvider.setPasswordEncoder(passwordEncoder);


        ProviderManager providerManager = new ProviderManager(List.of(daoProvider));
        providerManager.setEraseCredentialsAfterAuthentication(false); // 인증 후 자격 증명 유지 여부 설정

        return providerManager;
    }


}
