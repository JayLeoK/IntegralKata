import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTests {
    private Profile Alice = new Profile("alice123","Alice");

    @Test
    void testBasicProfile() throws Exception {
        assertEquals(Alice.getHandle(),"alice123");
        assertEquals(Alice.getName(),"Alice");
        assertEquals(Alice.numFollowing(), 0);
    }

    @Test
    void testFollowing() throws Exception{
        assertEquals(Alice.numFollowing(), 0);
        Alice.addFollowing("bob_the_builder");
        assertEquals(Alice.numFollowing(),1);
        ArrayList<String> followers = Alice.getFollowing();
        assertEquals(followers.get(0),"bob_the_builder");
    }


}