import java.util.ArrayList;

public class Profile {
    private String handle;
    private String name;
    private ArrayList<String> following;

    public Profile(String handle, String name){
        this.handle = handle;
        this.name = name;
        this.following = new ArrayList<String>();
    }

    public String getHandle(){
        return handle;
    }

    public String getName(){
        return name;
    }

    public int numFollowing(){
        return following.size();
    }

    public void addFollowing(String handle){
        following.add(handle);
    }

    public ArrayList<String> getFollowing(){
        return following;
    }


}
