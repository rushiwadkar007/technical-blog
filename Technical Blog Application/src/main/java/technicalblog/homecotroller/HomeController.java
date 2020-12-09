package technicalblog.homecotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import java.util.ArrayList;
import java.util.Date;

@Controller
@ComponentScan
/* @ComponentScan registers controllers in the Spring IOC container by default, scans and registers components
annotated with @Service in the Spring IOC container */
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    /*The getAllPost() method in the HomeController class is mapped to “/”, which represents
     the home page of the web application.

     The @RequestMapping(“/”) instruction will inform Spring to execute the “public String getAllPosts(Model
     model)” method when user is requesting for the “/” path under the url and port that the Spring application
     is listening for incoming client requests, which is “localhost:8080” in this case.

     The method will then create three post objects with dummy data and add them to an array list.

     The ‘model.addAttributes(“posts”, posts)’ instruction would help in passing the array list of posts
     to the corresponding view template.

     The method then returns the corresponding HTML page to render the data stored in the model object.  In the
     next segment, you will learn how to use the thymeleaf to render the data in the model object and the final
     page.*/

    public String getAllPosts(Model model) {

        /*Spring provides a model class in which you can pass data from the controller method to the view (or
        Thymeleaf template in the context of this demonstration). The MVC model class (like the Post.java model)
        is used to represent data in the application, whereas "the model class provided by Spring is used to pass
        data from the controller to the view".

        If there is no request method mentioned with the @RequestMapping annotation, GET is considered the
        default method. Therefore, we did not mention any request method while writing the getAllPosts
        HomeController method.
        */

        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        return "index";
    }
}
/*The controller method, which is used to get all the posts, is supposed to do the following:
Fetch all the blog posts available in the technical blog web application.
Store the list of posts as a Spring Model object.
Return the Spring Model object.

Request scope: Information that is generated and used within the context of a request is said to be in the
request scope, i.e., the request scope lies within the server receiving an HTTP request from a client and
the server sending an HTTP response to the client. For example, the information passed to the controller as
part of a request is typically kept during the request scope. Some examples are the information in the HTTP
request header, query parameters, etc.

Session scope: Information that is always available to a specific user and not to any other user is said to be
in the session scope. For example, you may want to keep the information about the current logged in user until
they log out or close their browser window.

Application scope: Information available to all users at all times is said to be in the application scope,
i.e., the application scope starts from the point when you start the web application until the time you shut
it down, for example, the number of users that are currently viewing the technical blog.

The model is a Spring Model object and is a key-value-like class (similar to a hash table) provided
by the Spring framework, and it helps to pass data from the controller to the view template
(or thymeleaf in this demonstration) . In the instruction above, the string ‘posts’ act as a key, and
its corresponding value would be the post data stored in the variable posts. Specifically, Spring
would automatically pass the model to the view , which can then retrieve the data stored in the model
and then render the data as a part of the web page to be shown to the user.

 */