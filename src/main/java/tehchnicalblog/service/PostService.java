package tehchnicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tehchnicalblog.model.Post;
import tehchnicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
   @Autowired
   private PostRepository repository;

    public PostService(){
        System.out.println("***PostService***");
    }

    public List<Post> getAllPosts(){
        return repository.getAllPosts();

//        Connection connection=null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/TechnicalBlog", "postgres", "8793457645");
//            Statement statement=connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//            while(rs.next()){
//
//
//            Post post = new Post();
//            post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }

    }
    public Post getOnePost(){
        return repository.getLatestPost();

//        Post post1= new Post();
//        post1.setTitle("Hi...!this is your first post...!");
//        post1.setBody("It is some valid content...!");
//        post1.setDate(new Date());
//        Connection connection=null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/TechnicalBlog", "postgres", "8793457645");
//            Statement statement=connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts WHERE id=4");
//            while(rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }

        //posts.add(post1);

    }

    public void createPost(Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("new Post "+newPost);
    }

    public Post getPost(Integer postId){
        return repository.getPost(postId);
    }

    public void updatePost(Post updatedPost){
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }
}
