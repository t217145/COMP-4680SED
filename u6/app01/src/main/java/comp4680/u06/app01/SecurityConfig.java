package comp4680.u06.app01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        UserDetails staff = User.builder()
                .username("staff")
                .password(passwordEncoder().encode("password"))
                .roles("STAFF")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN", "STAFF")
                .build();

        return new InMemoryUserDetailsManager(user, staff, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/index"))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/internal/admin").hasRole("ADMIN")
                        .requestMatchers("/internal/**").hasAnyRole("ADMIN", "STAFF")
                        .anyRequest().permitAll())
                .formLogin(withDefaults())
                .sessionManagement(withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}