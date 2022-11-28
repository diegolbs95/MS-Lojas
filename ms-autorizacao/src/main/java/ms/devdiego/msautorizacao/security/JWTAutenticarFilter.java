package ms.devdiego.msautorizacao.security;

//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import lombok.Data;
//import lombok.SneakyThrows;
//import ms.devdiego.msautorizacao.ententies.Usuario;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;

//@Data
public class JWTAutenticarFilter{

//    public static final int TOKEN_EXPIRACAO = 600_000;
//    public static final String TOKEN_SENHA = "cfbe595a-2d72-448a-b6b8-572b89d1ef85";
//
//    private final AuthenticationManager authenticationManager;

//    public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }

//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//       try {
//           Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
//           return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                 usuario.getEmail(),
//                   usuario.getPassword(),
//                   new ArrayList<>()
//           ));
//       }catch (IOException e){
//           throw new RuntimeException("Falha ao autenticar usuario", e);
//       }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        Usuario usuario = (Usuario) authResult.getPrincipal();
//        String token = JWT.create()
//                .withSubject(usuario.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
//                .sign(Algorithm.HMAC512(TOKEN_SENHA));
//
//        response.getWriter().write(token);
//        response.getWriter().flush();
//    }
}
