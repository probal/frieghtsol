package com.freightsol.freightsol.controller.auth;

import com.freightsol.freightsol.model.auth.UserRole;
import com.freightsol.freightsol.service.auth.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by probal on 11/17/17.
 */
@RestController
@RequestMapping("api/v1/role")
@Api(value="role", description="This is role controller")
public class RoleController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @ApiOperation(value = "Create role", response = UserRole.class)
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public UserRole createRole(UserRole postBody ) {
        UserRole userRole = userService.createRole(postBody);
        return userRole;
    }

    @ApiOperation(value = "Fetch Role list", response = UserRole.class)
    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public List<UserRole> getAllRoles() {
        List<UserRole> roleList = userService.getAllRoles();
        return roleList;
    }
}
