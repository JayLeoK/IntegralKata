import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedTests {
    private Feed feed = new Feed();

    @Test
    void testBasicFeed() {
        feed.assertEquals(feed.numProfiles(),0);
    }

    @Test
    void testPublishingFeature(){
        feed.newProfile("alice123","Alice");
        assertEquals(feed.numProfiles(),1);
        feed.makePost()
    }
}