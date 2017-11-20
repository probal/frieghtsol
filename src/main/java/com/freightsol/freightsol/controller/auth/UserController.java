package com.freightsol.freightsol.controller.auth;

import com.freightsol.freightsol.config.AppConfiguration;
import com.freightsol.freightsol.exception.ResourceNotFoundException;
import com.freightsol.freightsol.model.UserToken;
import com.freightsol.freightsol.model.auth.UserAccount;
import com.freightsol.freightsol.service.MailSenderService;
import com.freightsol.freightsol.service.auth.AuthService;
import com.freightsol.freightsol.service.auth.UserService;
import com.freightsol.freightsol.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by probal on 11/17/17.
 */
@RestController
@RequestMapping("api/v1/user")
@Api(value="user", description="This is auth controller")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    @Qualifier("userService")
    UserService userService;


    @ApiOperation(value = "Fetch user", response = UserAccount.class)
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<UserAccount> getuser(@RequestParam("userId") Long userId) {
        UserAccount userAccount = userService.getUser(userId);
        return new ResponseEntity<UserAccount>(userAccount, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch paginated user list", response = UserAccount.class)
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public ResponseEntity<Page<UserAccount>> getAllUser(Pageable pageable) {
        Page<UserAccount> userAccountPage = userService.getAllUser(pageable);
        return new ResponseEntity<Page<UserAccount>>(userAccountPage, HttpStatus.OK);
    }

    @ApiOperation(value = "Add user role", response = UserAccount.class)
    @RequestMapping(value = "/addRole", method= RequestMethod.POST)
    public ResponseEntity<UserAccount> addRole(@RequestParam("userId") Long userId, @RequestParam("roles") String roles) {
        return new ResponseEntity<UserAccount>(userService.assignRoles(userId, roles), HttpStatus.CREATED);
    }

}
