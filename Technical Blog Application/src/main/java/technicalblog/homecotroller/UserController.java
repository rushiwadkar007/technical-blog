package technicalblog.homecotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    /*The @RequestMapping instruction will map the URL of the web page with the corresponding controller
    (UserController.java in this case) method, and the location of the specific HTML file is referred to by the
    return instruction of that method.*/
    public String login(){
        return "users/login";
        /*login() method will return the view stored under the templates --> user --> login.html */
    }
    @RequestMapping("users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(value= "users/login", method=RequestMethod.POST)
    /* by adding  method=RequestMethod.POST, the controller method only responds to the method request  of type
    POST/ made to the "users/login" URL.

    A parameter other than the URL value to the @RequestMapping annotation is called RequestMethod. So far in
    the application, we are not sending any data from the client to the server. We have only created methods
    that respond to client requests for web pages. By default, the HTTP request method is set as GET, and
    hence, you did not need to add this information to your controller methods before.*/
    public String loginUser(User user){
        if(userService.login(user))
            return "redirect:/posts";
        else
            return "users/login";

        /*
         * this means posts.html page will be seen by the user after logging in.
         *Now, the loginUser controller method is supposed to listen to the POST requests at the users/login
        URL, i.e., this method is invoked when a user clicks on the Submit button on the login page. Hence,
        you will have to specify the HTTP request method that this controller method corresponds to as POST.
        * Question - You have created the login and loginUser methods till now.
        One method shows the login form and webpage to the user and the other is invoked when a user clicks on the submit
        button in the login form. Both of these methods are mapped to the same URL which is “users/login”, how does
        Spring now which method to execute when a request comes in for this URL?
         Answer - The loginUser method is listening for POST requests and the login method is listening for GET
         requests.  Therefore, when a user request comes in for the “users/login” URL, Spring routes the request
         to appropriate controller method based on whether it is a GET request or the POST request.
        */
    }

    @RequestMapping(value= "users/registration", method=RequestMethod.POST)
    public String registerUser(User user){
        return "users/login";
    }
    @RequestMapping(value= "users/logout", method=RequestMethod.POST)
    public String logout(Model model){
        ArrayList<Post> posts= postService.getAllPosts();

        model.addAttribute("posts", posts);
        return "index";
    }

}
