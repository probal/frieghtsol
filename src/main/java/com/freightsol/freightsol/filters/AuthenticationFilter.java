package com.freightsol.freightsol.filters;

import com.freightsol.freightsol.config.AppConfiguration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.security.Key;
import java.security.SignatureException;

/**
 * Created by probal on 10/10/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthenticationFilter implements Filter {

    @Autowired
    AppConfiguration appConfiguration;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Thru auth filter....");



        String compactJws = Jwts.builder()
                .setSubject("Joe")
                .signWith(SignatureAlgorithm.HS512, appConfiguration.getJwtSecret().getBytes("UTF-8"))
                .compact();
        try {

            Jwts.parser().setSigningKey(appConfiguration.getJwtSecret().getBytes("UTF-8")).parseClaimsJws(compactJws);



        } catch (Exception e) {

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
