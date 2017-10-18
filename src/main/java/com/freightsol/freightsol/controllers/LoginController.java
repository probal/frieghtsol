package com.freightsol.freightsol.controllers;

import com.freightsol.freightsol.Utils.CommonUtils;
import com.freightsol.freightsol.config.AppConfiguration;
import com.freightsol.freightsol.models.PersonModel;
import com.freightsol.freightsol.models.UserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by probal on 10/10/17.
 */
@RestController
@RequestMapping("api/v1/login")
@Api(value="login", description="Login controller")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    AppConfiguration appConfiguration;


    @ApiOperation(value = "Login with this api",response = PersonModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully done"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(value = "/doLogin", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserToken> doLogin(HttpServletRequest request,
                                             HttpServletResponse response,
                                             @RequestParam("userName") String userName,
                                             @RequestParam("password") String password) {
        try {

                PersonModel pm = new PersonModel();
                pm.setName(userName);
                pm.setEmail("abc@dmd.com");
                UserToken userToken = new UserToken(pm);
                CommonUtils.setUserToken(response, userToken, appConfiguration);
                logger.info(userName + " logged in...");
                return new ResponseEntity<UserToken>(userToken, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Exceptoion occured");
        }
        return new ResponseEntity<UserToken>(HttpStatus.NOT_FOUND);
    }
}
