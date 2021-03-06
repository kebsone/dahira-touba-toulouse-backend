package com.dahira.touba.toulouse.dahiraapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dahira.touba.toulouse.dahiraapp.Utils.SecurityParam;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super();
        this.authenticationManager = authenticationManager;

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        try {
            //déserealise json vers java
            AppUser  appUser = new ObjectMapper().readValue(request.getInputStream(),AppUser.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getMail(), appUser.getPassword()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Problème dans le corp de la requête");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
         User user =(User) authResult.getPrincipal();

         List<String> roles = new ArrayList<>();
         authResult.getAuthorities().forEach(r->{
             roles.add(r.getAuthority());
         });
            String jwt = JWT.create()
                    .withIssuer(request.getRequestURI())
                    .withSubject(user.getUsername())
                    .withClaim("username", user.getUsername())
                    .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                    .withExpiresAt(new Date(System.currentTimeMillis()+SecurityParam.EXPIRATION))
                    .sign(Algorithm.HMAC256(SecurityParam.SECRET));
            response.addHeader(SecurityParam.HEADER_NAME, jwt);
    }
}
