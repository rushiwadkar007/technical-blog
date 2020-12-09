package tehchnicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tehchnicalblog.model.Post;
import tehchnicalblog.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller


public class HomeController {
    @Autowired
    private PostService postService;
    @RequestMapping("/")
    public String getAllPosts(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
