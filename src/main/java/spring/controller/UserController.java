package spring.controller;

import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.dto.AuthDTO;
import spring.model.User;
import spring.service.UserService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srinathmedala on 5/16/15.
 */

@Api(value = "users", description = "Api related to User operations")
@RestController("userController")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "Authenticate based on username and password ", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 500, message = "SERVER ERROR"),
            @ApiResponse(code = 400, message = "Invalid request params")})
    public
    @ResponseBody
    String login(@RequestBody AuthDTO authDTO) {
        String auth = "failure";
        if (authDTO != null) {
            User user = userService.findUserByUsernameAndPassword(authDTO.getUsername(), authDTO.getPassword());
            if (user != null) {
                auth = "success";
            }
        }
        return auth;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "Get List of all Users", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 500, message = "SERVER ERROR"),
            @ApiResponse(code = 400, message = "Invalid request params")})
    public
    @ResponseBody
    List<User> getAllUsers() {
        return userService.findAllUsers();
    }


    @RequestMapping(value = "/filter/city/{city}", method = RequestMethod.GET)
    @ApiOperation(value = "Filter User By city name", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 500, message = "SERVER ERROR"),
            @ApiResponse(code = 400, message = "Invalid request params")})
    public
    @ResponseBody
    List<User> filterByCityName(@PathVariable("city") @ApiParam String cityName) {
        return userService.findUsersByCityName(cityName);
    }

    @RequestMapping(value = "/filter/company/{company}", method = RequestMethod.GET)
    @ApiOperation(value = "Filter User By company name", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 500, message = "SERVER ERROR"),
            @ApiResponse(code = 400, message = "Invalid request params")})
    public
    @ResponseBody
    List<User> filterByCompanyName(@PathVariable("company") @ApiParam String company) {
        return userService.findUsersByCompanyName(company);
    }


    @RequestMapping(value = "/status", method = RequestMethod.GET)
    @ApiOperation(value = "Check whether DB is Up", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 500, message = "SERVER ERROR"),
            @ApiResponse(code = 400, message = "Invalid request params")})
    public
    @ResponseBody
    String checkAppDependentComponentsAlive() {
        String status = "DB is up";
        String dbDown = "DB is down";
        if (userService.isDbAlive() == 1) {
            return status;
        } else {
            return dbDown;
        }
    }

    @RequestMapping(value = "/listFiles/{directoryName}", method = RequestMethod.GET)
    @ApiOperation(value = "Lists all Files under given Directory", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 500, message = "SERVER ERROR"),
            @ApiResponse(code = 400, message = "Invalid request params")})
    public
    @ResponseBody
    List<String> listAllFiles(@PathVariable("directoryName") @ApiParam String directoryName) {
        List<String> files = new ArrayList<String>();
        File directory = new File(directoryName);
        if (directory != null) {
            File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file != null && file.isFile()) {
                    files.add(file.getName());
                }
            }
        }
        return files;
    }
}
