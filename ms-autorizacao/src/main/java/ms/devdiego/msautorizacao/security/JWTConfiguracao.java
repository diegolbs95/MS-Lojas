package ms.devdiego.msautorizacao.security;

//import lombok.Data;
//import ms.devdiego.msautorizacao.Services.DetalheUsuarioServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import javax.ws.rs.HttpMethod;

//@Data
//@EnableWebSecurity
public class JWTConfiguracao {

//    private final DetalheUsuarioServiceImpl usuarioService;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAutenticarFilter(authenticationManager()))
//                .addFilter(new JWTValidarFilter(authenticationManager()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){
//       final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//       CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//       source.registerCorsConfiguration("/**", corsConfiguration);
//
//       return source;
//
//    }
}
