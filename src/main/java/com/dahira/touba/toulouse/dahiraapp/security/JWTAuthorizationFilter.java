package com.dahira.touba.toulouse.dahiraapp.security;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dahira.touba.toulouse.dahiraapp.Utils.SecurityParam;
import org.hibernate.persister.collection.OneToManyPersister;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    //Pour chaque requête envoyée par l'utilisateur, cette méthode s'execute d'abord
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

       httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
       httpServletResponse.addHeader("Access-Control-Allow-Headers","Origin, Accept, X-Requested-with, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization");
      httpServletResponse.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET,PSOT,PUT,DELETE,PATCH");


        if(httpServletRequest.getMethod().equals("OPTIONS")){
           // J' ai déjà gérer les headers dons s'il envoit une requetes avec options pour demander les url autorisé je retourne OK
           httpServletResponse.setStatus(HttpServletResponse.SC_OK);
       } else if (httpServletRequest.getRequestURI().equals("/login")){
           // Si l'utilisateur se log, il n' y a pas besoin de gérer un Token
           filterChain.doFilter(httpServletRequest, httpServletResponse);
           return;
       } else {

        // vérifier la signature du token

        String jwt = httpServletRequest.getHeader(SecurityParam.HEADER_NAME);
        if(jwt == null || !jwt.startsWith(SecurityParam.HEADER_PREFIX)){
            // dans ce cas passer au filtre suivant
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SecurityParam.SECRET)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(jwt.substring(SecurityParam.HEADER_PREFIX.length()));
        String userName = decodedJWT.getSubject();
        System.out.print("username=>>>>>"+ userName);
        List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r));
        });
        UsernamePasswordAuthenticationToken user = new
                UsernamePasswordAuthenticationToken(userName,null, authorities);
        SecurityContextHolder.getContext().setAuthentication(user);
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
    }
}
