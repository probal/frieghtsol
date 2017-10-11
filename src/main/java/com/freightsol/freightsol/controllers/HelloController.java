package com.freightsol.freightsol.controllers;

import com.freightsol.freightsol.config.AppConfiguration;
import com.freightsol.freightsol.db.entities.Person;
import com.freightsol.freightsol.db.repositories.PersonRepository;
import com.freightsol.freightsol.models.PersonModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * Created by probal on 10/9/17.
 */
@RestController
@RequestMapping("api/v1/hello")
@Api(value="hello", description="This is test controller")
public class HelloController {

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    private PersonRepository personRepository;

    @ApiOperation(value = "Test this api",response = PersonModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully done"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(value = "/add", method= RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Person greeting( @RequestParam("name") String name,
                     @RequestParam("email") String email) {

        Person person = new Person();
        person.setEmail(email);
        person.setName(name);
        return personRepository.save(person);
    }

    @ApiOperation(value = "Test this api",response = PersonModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully done"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource")
    })
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Iterable<Person> getList() {
        return personRepository.findAll();
    }

}
