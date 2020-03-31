import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Feed {
    private HashMap<String, HashSet<Integer>> handleToIndex;
    private ArrayList<Post> posts;
    private HashMap<String, Profile> handleToProfile;
    private Date date;

    public Feed(String currTime){
        handleToIndex = new HashMap<String, HashSet<Integer>>();
        posts = new ArrayList<Post>();
        handleToProfile = new HashMap<String, Profile>();
        date = stringToDate(currTime);
    }

    public int numProfiles() { return handleToProfile.size(); }

    public int numPosts(){ return posts.size(); }

    public String timeFrom(String timeInput){
        Date dateInput = stringToDate(timeInput);
        long diff = date.getTime()-dateInput.getTime();
        if(diff>=60000){
            int minutes = (int)diff/60000;
            return minutes + " minutes ago";
        }else {
            int seconds = (int) diff/1000;
            return seconds + " seconds ago";
        }
    }

    private Date stringToDate(String timeInput){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            return dateFormat.parse(timeInput);
        }catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void newProfile(String handle, String name){
        Profile newProf = new Profile(handle, name);
        handleToProfile.put(handle, newProf);
    }

    public void makePost(String handle, String body, String time){
        Post post = new Post(handle, body, time);
        posts.add(post);
    }

    public String viewTimeline(String handle1, String handle2){
        return formatPost(posts.get(0));
    }

    private String formatPost(Post post){
        Profile prof = handleToProfile.get(post.getHandle());
        String timestamp = timeFrom(post.getTime());
        return prof.getName() + ": " + post.getBody() + " ("+timestamp+")";
    }


}
