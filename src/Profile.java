import java.util.ArrayList;

public class Profile {
    private String handle;
    private ArrayList<Post> posts;

    public Profile(String handle){
        this.handle = handle;
        this.posts = new ArrayList<Post>();
    }

    public String getHandle(){
        return "@"+handle;
    }

    public void makePost(String input){
        Post newPost = new Post(input);
        posts.add(newPost);
    }

    public String getLastPost() {
        Post lastPost = posts.get(0);
        return lastPost.getBody();
    }

    public int numPosts(){
        return posts.size();
    }
}
