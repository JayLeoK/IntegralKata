import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Feed {
    private HashMap<String, HashSet<Integer>> handleIndexMap;
    private ArrayList<Post> posts;
    private HashSet<Profile> profiles;
    private Date date;

    public Feed(String currTime){
        handleIndexMap = new HashMap<String, HashSet<Integer>>();
        posts = new ArrayList<Post>();
        profiles = new HashSet<Profile>();
        date = stringToDate(currTime);
    }

    public int numProfiles() { return profiles.size(); }

    public int numPosts(){ return posts.size(); }

    public String timeFrom(String timeInput){
        Date dateInput = stringToDate(timeInput);
        long diff = dateInput.getTime()-date.getTime();
        if(diff>60000){
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
        profiles.add(newProf);
    }

    public void makePost(String handle, String body, String time){
        Post post = new Post(handle, body, time);
        posts.add(post);
    }


}
