package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
/*
The service class is annotated with @service to inform the Spring Boot framework that the PostService class
is a service in the technical blog application.It registers the class in the Spring container and tells Spring
that this class is a service class that provides business logic in the application.
 */
public class PostService {
    public ArrayList<Post> getAllPosts(){

        ArrayList<Post> posts = new ArrayList<>();

        Post post1= new Post();
        post1.setTitle("Post 1");
        post1.setBody("Post Body 1");
        post1.setDate(new Date());

        Post post2= new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());

        Post post3= new Post();
        post3.setTitle("Post 3");
        post3.setBody("Post Body 3");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }
    public ArrayList<Post> getOnePost(){
        ArrayList<Post> posts = new ArrayList<>();

        Post post1= new Post();
        post1.setTitle("First post");
        post1.setBody("This is your first post. It has some valid content");
        post1.setDate(new Date());
        posts.add(post1);

        return posts;
    }
    public void createPost(Post newPost){

    }
}
/*
PostService takes care of all the CRUD operations related to posts such as retrieving all posts through the
getAllPosts() method.

Now, if you want to use a method from the PostService class in HomeController, what will you do?

HomeController is clearly dependent on the PostService class to get the list of posts. As you learnt while
studying Unit Testing, the PostService class here can be called a dependency of the HomeController.

You will create an object of the PostService class like this:
PostService postService= new PostService();
Since you are hardcoding a dependency, this creates tight-coupling between classes.
The Spring framework provides you with a way to make the classes loosely coupled via a technique called dependency
injection.

You learnt that the dependency injection with the Spring framework helps with the following:

Reduces the coupling between the classes and makes your project code more loosely coupled. You can get an object
of a component class using the @Autowired annotation.

The dependency injection makes testing and adding mock objects easier.

The life cycle of object instances obtained from Spring via the @Autowired annotation is managed by the Spring
IOC container.
 */