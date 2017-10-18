package com.freightsol.freightsol.controllers;

import com.freightsol.freightsol.Utils.HttpResponseUtils;
import com.freightsol.freightsol.models.UserAuth;
import com.freightsol.freightsol.models.UserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by probal on 10/17/17.
 */
@RestController
@RequestMapping("api/v1/logout")
@Api(value="logout", description="logout controller")
public class LogoutController {

    @Autowired
    private UserAuth userAuth;

    @Autowired
    private HttpServletResponse servletResponse;


    @ApiOperation(value = "Test this api",response = UserToken.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully done"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(value = "/doLogout", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity doLogout(@RequestParam(value = "callback", required = false) String callback) throws Exception {
            servletResponse.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
            servletResponse.setHeader("Pragma", "no-cache");
            Cookie myCookie = new Cookie("jwttoken", "");
            myCookie.setMaxAge(0);
            myCookie.setPath("/");
            myCookie.setHttpOnly(false);
            servletResponse.addCookie(myCookie);
            return HttpResponseUtils.getOkResponse(callback, "\"Logged out\"");
    }
}
