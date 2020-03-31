public class Post {
    private String handle;
    private String body;
    private String time;

    public Post(String handle, String body, String time){
        this.handle = handle;
        this.body = body;
        this.time = time;
    }

    public String getBody() {
        return body;
    }

    public String getHandle() {
        return handle;
    }

    public String getTime() {
        return time;
    }
}
