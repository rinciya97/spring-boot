package com.stackroute.springboot.Controller;
import com.stackroute.springboot.domain.User;
import com.stackroute.springboot.exceptions.UserAlreadyExistException;
import com.stackroute.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
      ResponseEntity responseEntity;
      try
      {
          userService.saveUser(user);
          responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
      }
      catch (UserAlreadyExistException ex)
      {
          responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
      }
      return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

}
