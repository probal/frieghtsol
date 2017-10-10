package com.freightsol.freightsol.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freightsol.freightsol.config.AppConfiguration;
import com.freightsol.freightsol.models.UserToken;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by probal on 10/10/17.
 */
public class CommonUtils {

    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setUserToken(HttpServletResponse servletResponse, UserToken userToken, AppConfiguration configuration) throws  Exception{

        String serializedJwe = CommonUtils.getSerializedUserToken(userToken, configuration);
        Cookie tokenCookie = new Cookie("jwttoken", serializedJwe);
        tokenCookie.setMaxAge(60 * 60 * 24 * 365);
        tokenCookie.setPath("/");
        tokenCookie.setHttpOnly(false);
        servletResponse.addCookie(tokenCookie);
    }

    public static String getSerializedUserToken(UserToken userToken, AppConfiguration configuration) throws  Exception{
        String claim = CommonUtils.toJson(userToken);
        Map<String, Object> map = new HashMap<>();
        map.put("user", claim);
        String compactJws = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, configuration.getJwtSecret().getBytes("UTF-8"))
                .setClaims(map)
                .compact();
        return compactJws;

    }
}
