package com.daniel.authentication.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.daniel.authentication.model.LoginUser;
import com.daniel.authentication.model.User;
import com.daniel.authentication.repository.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()){
    		result.rejectValue("email", "Matches", "Chose a other Email");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
//    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
//    	newUser.setPassword(hashed);
    	newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
    	
    	System.out.println("password hashed");
        // TO-DO: Additional validations!
        return this.create(newUser);
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "Matches", "Email not in file");
    		return null;
    	}
    	User thisUser = potentialUser.get();
//    	if(userRepo.findByEmail(newLoginObject .getEmail()).e)
        // TO-DO: Additional validations!
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), thisUser.getPassword())) {
    	    result.rejectValue("password", "Matches", "Password or email was incorect");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
        return thisUser;
    }
    
    public User create(User newUser) {
        return userRepo.save(newUser);
    }
    
}
