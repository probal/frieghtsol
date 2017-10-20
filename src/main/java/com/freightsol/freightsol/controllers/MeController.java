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
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully done"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResponseEntity<UserToken> getMe(@RequestParam(value = "callback", required = false) String callback) throws Exception {

        UserToken userToken = userAuth.getUserToken();
        return HttpResponseUtils.getOkResponse(callback, userToken);
    }
}
