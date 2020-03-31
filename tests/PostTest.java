import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    private Post testPost = new Post("TestHandle","Test");

    @Test
    void testBasicPost() {
        assertEquals(testPost.getBody(), "Test");
    }


}