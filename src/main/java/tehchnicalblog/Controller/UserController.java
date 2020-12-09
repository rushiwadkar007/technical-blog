package tehchnicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tehchnicalblog.model.Post;
import tehchnicalblog.model.User;
import tehchnicalblog.service.PostService;
import tehchnicalblog.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(value="users/login", method= RequestMethod.POST)
    public String loginUser(User user){
        if(userService.login(user)) {
            return "redirect:/posts";
        }
        else{
            return "users/login";
        }
    }

    @RequestMapping(value ="/users/registration", method= RequestMethod.POST)
    public String registerUser(User user){

        return "redirect:/users/login";
    }

    @RequestMapping(value="users/logout", method= RequestMethod.POST)
    public String logout(Model model){
        List<Post> posts = postService.getAllPosts();
    model.addAttribute("posts", posts);
    return "index";
    }

}
