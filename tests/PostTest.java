import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    private Post testPost = new Post("Test");
    private Profile Alice = new Profile("Alice");


    @Test
    void testBasicPost() {
        assertEquals(testPost.getBody(), "Test");
    }

    @Test
    void testAlicePost() throws Exception {
        Alice.makePost("I love the weather today");
        assertEquals(Alice.getLastPost(), "I love the weather today");
    }
}