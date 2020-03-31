import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedTests {
    String currTime = "2019-03-31 16:30:00.000";
    private Feed feed = new Feed(currTime);

    @Test
    void testBasicFeed() {
        assertEquals(feed.numProfiles(),0);
        assertEquals(feed.numPosts(),0);
        assertEquals(feed.timeFrom(currTime), "0 seconds ago");
    }

    @Test
    void testPublishingFeature(){
        feed.newProfile("alice123","Alice");
        assertEquals(feed.numProfiles(),1);
        String postTime = "2019-03-31 16:29:00.000";
        feed.makePost("alice123","I love the weather today.", postTime);
        assertEquals(feed.numPosts(),1);
//        assertEquals(feed.viewTimeline("alice123","alice123"),
//                "I love the weather today.");
    }

    @Test
    void testTimelineFeature(){
        feed.newProfile("alice123","Alice");
        feed.newProfile("bob_the_builder","Bob");
//        feed.makePost("bob_the_builder", "Darn! We lost!");
//        feed.makePost("bob_the_builder", "Good game though.");

    }
}