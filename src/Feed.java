import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Feed {
    private HashMap<String, ArrayList<Integer>> handleToIndexList;
    private ArrayList<Post> posts;
    private HashMap<String, Profile> handleToProfile;
    private Date date;

    public Feed(String currTime){
        handleToIndexList = new HashMap<String, ArrayList<Integer>>();
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
        if (handleToIndexList.get(handle)==null){
            ArrayList<Integer> indexList = new ArrayList<Integer>();
            handleToIndexList.put(handle,indexList);
        }
        handleToIndexList.get(handle).add(posts.size()-1);
    }

    public void followProfile(String handle1, String handle2){
        Profile profile1 = handleToProfile.get(handle1);
        profile1.addFollowing(handle2);
    }

    private String formatPost(Post post){
        Profile prof = handleToProfile.get(post.getHandle());
        String timestamp = timeFrom(post.getTime());
        return prof.getName() + ": " + post.getBody() + " ("+timestamp+")";
    }

    public String viewTimeline(String handle1, String handle2){
        ArrayList<Integer> indexList = handleToIndexList.get(handle2);
        String output = "";
        for (int i = indexList.size()-1;i>=0;i--){
            output += formatPost(posts.get(i));
            if(i>0){
                output += "\n";
            }
        }
        return output;
    }

    public String viewWall(String profHandle){
        Profile profile = handleToProfile.get(profHandle);
        ArrayList<String> followingList = profile.getFollowing();

        ArrayList indices = new ArrayList<Integer>();
        for(int i=0;i<followingList.size();i++){
            String handle = followingList.get(i);
            ArrayList<Integer> followingIndices = handleToIndexList.get(handle);
            indices.addAll(followingIndices);
        }
        Collections.sort(indices);
        String output = "";
        for (int i = indices.size()-1;i>=0;i--){
            output += formatPost(posts.get(i));
            if(i>0){
                output += "\n";
            }
        }
        return output;
    }


}
