import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Feed {
    private HashMap<String, HashSet<Integer>> handleIndexMap;
    private ArrayList<Post> posts;
    private Set<Profile> profiles;

    public Feed(){
        handleIndexMap = new HashMap<String, HashSet<Integer>>();
        posts = new ArrayList<Post>();
    }

    public int numPosts(){ return posts.size(); }

    public void addPost(Post post){
        posts.add(post);
    }

}
