package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.User;

import javax.validation.constraints.NotNull;

@Service
public class UserService {
    public boolean login(User user){
        if(user.getUserName().equals("validuser")){
            return true;
        }
        else{
            return false;
        }
    }

}
