package com.freightsol.freightsol.controller.auth;

import com.freightsol.freightsol.config.AppConfiguration;
import com.freightsol.freightsol.model.UserToken;
import com.freightsol.freightsol.model.auth.UserAccount;
import com.freightsol.freightsol.service.MailSenderService;
import com.freightsol.freightsol.service.auth.AuthService;
import com.freightsol.freightsol.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by probal on 11/16/17.
 */
@RestController
@RequestMapping("api/v1/public/auth")
@Api(value="auth", description="This is auth controller")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    MailSenderService mailSenderService;

    @Autowired
    @Qualifier("authService")
    AuthService authService;


    @ApiOperation(value = "Login user", response = UserToken.class)
    @RequestMapping(value = "/doLogin", method= RequestMethod.POST)
    public ResponseEntity<UserToken> doLogin(HttpServletResponse response, UserAccount postBody) {

        UserAccount userAccount = authService.doLogin(postBody);

        try {
            mailSenderService.sendLoginAlert(userAccount.getEmail(), userAccount.getFullName());
            UserToken userToken = new UserToken(userAccount);
            CommonUtils.setUserToken(response, userToken, appConfiguration);
            logger.info("{} logged in...", userAccount.getEmail());
            return new ResponseEntity<UserToken>(userToken, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Exceptoion occured");
        }
        return new ResponseEntity<UserToken>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Register user", response = UserToken.class)
    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public ResponseEntity<UserToken> register(HttpServletResponse response, UserAccount postBody ) {

        UserAccount userAccount = authService.createUser(postBody);

        try {
            mailSenderService.sendLoginAlert(userAccount.getEmail(), userAccount.getFullName());
            UserToken userToken = new UserToken(userAccount);
            CommonUtils.setUserToken(response, userToken, appConfiguration);
            logger.info("{} logged in...", userAccount.getEmail());
            return new ResponseEntity<UserToken>(userToken, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println("Exceptoion occured");
        }
        return new ResponseEntity<UserToken>(HttpStatus.NOT_FOUND);
    }
}