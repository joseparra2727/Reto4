package com.sergioarboleda.cacharrero.app.repository;


import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Carotobarj
 */

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    /**
     * 
     * @return 
     */
    
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    
    public Optional<User> getUser(Integer id){
        return userCrudRepository.findById(id);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    
    public Optional<User> getUserByName(String name){
        return userCrudRepository.findByName(name);
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    
    public Optional<User> getUserByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }
    
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    
    public List<User> getUsersByNameOrEmail(String name, String email){
        return userCrudRepository.findByNameOrEmail(name, email);
    }
    
    
    /**
     * 
     * @param user
     * @return 
     */
    
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    
    public boolean getEmail(String email){
        return userCrudRepository.existsByEmail(email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    
    public Optional<User> validateEmailPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * 
     * @param user 
     */
    
    
    public void delUser(User user){
        userCrudRepository.delete(user);
    }

    /**
     * 
     * @param month
     * @return 
     */
    
    
    public Optional<User> getBirthday(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}