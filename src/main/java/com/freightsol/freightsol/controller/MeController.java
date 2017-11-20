package com.freightsol.freightsol.controller;

import com.freightsol.freightsol.util.HttpResponseUtils;
import com.freightsol.freightsol.model.UserAuth;
import com.freightsol.freightsol.model.UserToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by probal on 10/17/17.
 */
@RestController
@RequestMapping("api/v1/private/me")
@Api(value="me", description="This is me controller to translate the JWT")
public class MeController {

    @Autowired
    private UserAuth userAuth;

    @ApiOperation(value = "Test this api",response = UserToken.class)
    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    public
    ResponseEntity<UserToken> getMe(@RequestParam(value = "callback", required = false) String callback) {
        UserToken userToken = userAuth.getUserToken();
        //return HttpResponseUtils.getOkResponse(callback, userToken);
        return new ResponseEntity<UserToken>(userAuth.getUserToken(), HttpStatus.OK);
    }
}
