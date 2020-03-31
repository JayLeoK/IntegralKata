import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    private Post testPost = new Post("TestHandle","Test", "2019-03-31 16:29:00.000");

    @Test
    void testBasicPost() {
        assertEquals(testPost.getBody(), "Test");
        assertEquals(testPost.getHandle(), "TestHandle");
        assertEquals(testPost.getTime(), "2019-03-31 16:29:00.000");
    }



}