package com.sergioarboleda.cacharrero.app.controller;

import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
  * @author Carotobarj
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 
     * @return 
     */
    
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    
    @GetMapping("/emailexist/{email}")
    public boolean getEmail(@PathVariable String email){
        return userService.getEmail(email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    
    @GetMapping("/{email}/{password}")
    public User validateEmailPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.validateEmailPassword(email, password);
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delUser(@PathVariable Integer id){
        return userService.delUser(id);
    }

    /**
     * @param id
     * @return 
     */
    
    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    /**
     * 
     * @param month
     * @return 
     */
    
    @GetMapping("/birthday/{month}")
    public Optional<User> getBirthDay(@PathVariable String month){
        return userService.getBirthday(month);
    }
}
