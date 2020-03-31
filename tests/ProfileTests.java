import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTests {
    private Profile Alice = new Profile("Alice");

    @Test
    void testBasicProfile() throws Exception {
        assertEquals(Alice.getHandle(),"@Alice");
    }
}