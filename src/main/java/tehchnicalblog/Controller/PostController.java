package tehchnicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tehchnicalblog.model.Post;
import tehchnicalblog.service.PostService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model){
        List<Post> posts=postService.getAllPosts();

        model.addAttribute("posts", posts);
        return "posts";
    }
    @RequestMapping("/posts/newpost")
    public String newPost(){
        return "posts/create";
    }
    @RequestMapping(value="/posts/create", method= RequestMethod.POST)
    public String createPost(Post newpost){
        postService.createPost(newpost);
        return "redirect:/posts";
      }
    @RequestMapping(value="/editPost", method=RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer postId, Model model){
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "users/posts";
    }

    @RequestMapping(value="/editPost", method=RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer postId, Post updatedPost){
        updatedPost.setId(postId);
        postService.updatePost((updatedPost));
        return "redirect:/posts/edit";
    }

    @RequestMapping(value="/deletePost", method=RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name="postId") Long postId){
        return "redirect:/posts";
    }

}
