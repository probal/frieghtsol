package com.freightsol.freightsol.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightsol.freightsol.config.ApplicationConfig;
import com.freightsol.freightsol.model.auth.UserAuth;
import com.freightsol.freightsol.model.auth.UserToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by probal on 10/10/17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
/*If its not a spring @Component Autowired beans would not get registered in standard bean factory*/
public class AuthenticationFilter implements Filter {

    @Autowired
    ApplicationConfig applicationConfig;

    @Autowired
    UserAuth userAuth;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest) {

            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

            if (httpRequest.getRequestURI().contains("/api/v1/")) {

                if (httpRequest.getRequestURI().contains("/public/")) {

                    filterChain.doFilter(servletRequest, servletResponse);

                } else {
                    String jwttoken = "";
                    Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if ("jwttoken".equalsIgnoreCase(cookie.getName())) {
                                jwttoken = cookie.getValue();
                            }
                        }
                    }

                    if (jwttoken.isEmpty()) {
                        sendErrorResponse((HttpServletResponse) servletResponse, HttpServletResponse.SC_UNAUTHORIZED, "No User !!!");
                        return;
                    }

                    try {
                        Claims claims = Jwts.parser().setSigningKey(applicationConfig.getJwtSecret().getBytes("UTF-8")).parseClaimsJws(jwttoken).getBody();
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(claims.get("user").toString());
                        UserToken userToken = new UserToken();
                        userToken.setUserId(jsonNode.get("userId").asLong());
                        userToken.setName(jsonNode.get("name").asText());
                        userToken.setEmail(jsonNode.get("email").asText());
                        userToken.setPhoneNumber(jsonNode.get("phoneNumber").asText());
                        userToken.setIssuedOn(jsonNode.get("issuedOn").asText());
                        userToken.setModules(jsonNode.get("modules").asText());
                        userAuth.setUserToken(userToken);
                    } catch (Exception e) {
                        e.printStackTrace();
                        sendErrorResponse((HttpServletResponse) servletResponse, HttpServletResponse.SC_UNAUTHORIZED, "Token failed to authenticate !!!");
                        return;
                    }

                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {

                filterChain.doFilter(servletRequest, servletResponse);
            }

        }

    }

    @Override
    public void destroy() {

    }

    public void sendErrorResponse(HttpServletResponse servletResponse, int status, String message){
        servletResponse.setStatus(status);
        try {
            servletResponse.getWriter().write(message);
        }catch (Exception e){

        }
        finally {
            try {
                servletResponse.getWriter().close();
            }catch (Exception e){

            }
        }

    }
}
