package tehchnicalblog.service;

import org.springframework.stereotype.Service;
import tehchnicalblog.model.User;

@Service
public class UserService {
    public boolean login(User user){
        if(user.getUsername().equals("validuser")){
            return true;
        }
        else{
            return false;
        }
    }
}
