package com.sergioarboleda.cacharrero.app.service;


import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Carotobarj
 */


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    /**
     * 
     * @return 
     */
    
    public List<User> getAll(){
        return userRepository.getAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    
    public Optional<User> getUser(Integer id){
        return userRepository.getUser(id);
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    
    public User save(User user){
        if(user.getIdentification() == null || user.getName() == null
                || user.getAddress() == null || user.getCellPhone() == null
                || user.getEmail() == null || user.getPassword() == null
                || user.getZone() == null || user.getType() == null){
            return user;
        } else {
            List<User> userAux = userRepository.getUsersByNameOrEmail(user.getName(), user.getEmail());
            if(userAux.isEmpty()){
                if(user.getId() == null){
                    return userRepository.save(user);
                } else {
                    Optional<User> userAux2 = userRepository.getUser(user.getId());
                    if(userAux2.isEmpty()){
                        return userRepository.save(user);
                    } else {
                        return user;
                    }
                }
            } else {
                return user;
            }
        }
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    
    public boolean getEmail(String email){
       return userRepository.getEmail(email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    
    public User validateEmailPassword(String email, String password){
        Optional<User> userExist = userRepository.validateEmailPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        } else {
            return new User();
        }
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    
    public User update(User user){
        if(user.getId() != null){
            Optional<User> userAux = userRepository.getUser(user.getId());
            if(!userAux.isEmpty()){
                if(user.getIdentification() != null){
                    userAux.get().setIdentification(user.getIdentification());
                }
                
                if(user.getName() != null){
                    userAux.get().setName(user.getName());
                }
                
                if(user.getAddress() != null){
                    userAux.get().setAddress(user.getAddress());
                }
                
                if(user.getCellPhone() != null){
                    userAux.get().setCellPhone(user.getCellPhone());
                }
                
                if(user.getEmail() != null){
                    userAux.get().setEmail(user.getEmail());
                }
                
                if(user.getPassword() != null){
                    userAux.get().setPassword(user.getPassword());
                }
                
                if(user.getZone() != null){
                    userAux.get().setZone(user.getZone());
                }
                
                if(user.getType() != null){
                    userAux.get().setType(user.getType());
                }
                
                userRepository.save(userAux.get());
                return userAux.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    
    public Boolean delUser(Integer id){
        Boolean aBoolean = getUser(id).map(user -> {userRepository.delUser(user);
                return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /**
     * 
     * @param month
     * @return 
     */
    
    public Optional<User> getBirthday(String month){
        return userRepository.getBirthday(month);
    }
}
