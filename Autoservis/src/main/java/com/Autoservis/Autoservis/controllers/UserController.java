package com.Autoservis.Autoservis.controllers;

import com.Autoservis.Autoservis.entities.User;
import com.Autoservis.Autoservis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public List<User> getAllUsers() {

        return userService.getALlUsers();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public UserDetails login(@RequestBody User user) throws Exception{
        UserDetails provjeraUser= userService.loadUserByUsername(user.getEmail());
        if (provjeraUser.getPassword().equals(user.getLozinka())){
            return provjeraUser;
        }
        else throw new Exception("Email i lozinka se ne poklapaju");
    }
    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    public void registerUser(@RequestBody User user) {

        userService.registerUser(user);
    }

    @RequestMapping("/posaljiLozinku/{email}")
    public void posaljiLozinku(@PathVariable String email) throws Exception{
        userService.posaljiLozinku(email);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/delete/{id}")
    public void userDelete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/update/{id}")
    public void updateUser(@RequestBody User id) {
        userService.updateUser(id);
    }
}




