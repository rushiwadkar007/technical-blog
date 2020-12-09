package technicalblog.model;

import java.util.Date;

/*model class called Post, which represents the posts in your blog. All the blog posts will be stored as
objects of this model class, i.e., the blog posts will exist in the web application as objects of this class.*/

public class Post {
    public String title;
    public String body;
    public Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
/*      We have already learned that a controller processes a request and returns the required data in the form of
a model. The Post.java model represents the blog posts that we will display in our technical blog. This model class
will be used by the controller to display a post or a set of posts on our blogging website.
For example, when a user requests for a web page with a list of posts, the controller will return this list of
posts packaged in the form of a model.
        In simple terms, the controller will return a  list of objects of the form List<Post>.This list of objects
will be packaged as the Model object provided by Spring. In the upcoming video, you will see how this list
object is returned from the controller as a model object.
 */