package com.freightsol.freightsol.controllers;

import com.freightsol.freightsol.config.AppConfiguration;
import com.freightsol.freightsol.models.PersonModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by probal on 10/9/17.
 */
@RestController
@RequestMapping("api/v1/hello")
@Api(value="hello", description="This is test controller")
public class HelloController {

    @Autowired
    AppConfiguration appConfiguration;


    @ApiOperation(value = "Test this api",response = PersonModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully done"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(value = "/greet", method= RequestMethod.GET, produces = "application/json")
    public @ResponseBody PersonModel greeting() {
        PersonModel pm = new PersonModel();
        pm.setFirstName("Probal");
        pm.setLastName("Sikder");
        System.out.println(appConfiguration.getAppUrl());
        return pm;
    }

}
