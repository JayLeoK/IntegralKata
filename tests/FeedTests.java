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
        String postTime = "2019-03-31 16:29:30.000";
        feed.makePost("alice123","I love the weather today.", postTime);
        assertEquals(feed.numPosts(),1);
        assertEquals(feed.viewTimeline("alice123","alice123"),
                "Alice: I love the weather today. (30 seconds ago)");
    }

    @Test
    void testTimelineFeature(){
        feed.newProfile("alice123","Alice");
        feed.newProfile("bob_the_builder","Bob");
        String postTime1 = "2019-03-31 16:28:00.000";
        feed.makePost("bob_the_builder", "Darn! We lost!", postTime1);
        String postTime2 = "2019-03-31 16:28:30.000";
        feed.makePost("bob_the_builder", "Good game though.", postTime2);
        assertEquals(feed.viewTimeline("alice123","bob_the_builder"),
                "Bob: Good game though. (1 minutes ago)\nBob: Darn! We lost! (2 minutes ago)");
    }

    @Test
    void testFollowing(){
        feed.newProfile("alice123","Alice");
        feed.newProfile("bob_the_builder","Bob");
        feed.newProfile("xXcharlieXx","Charlie");
        feed.followProfile("xXcharlieXx","alice123");
        feed.followProfile("xXcharlieXx","bob_the_builder");

        String postTime = "2019-03-31 16:25:00.000";
        feed.makePost("alice123","I love the weather today.", postTime);
        String postTime2 = "2019-03-31 16:28:00.000";
        feed.makePost("bob_the_builder", "Darn! We lost!", postTime2);
        String postTime3 = "2019-03-31 16:28:30.000";
        feed.makePost("bob_the_builder", "Good game though.", postTime3);
        String postTime4 = "2019-03-31 16:29:45.000";
        feed.makePost("xXcharlieXx","I'm in New York today! Anyone wants to have a coffee?",postTime4);
        assertEquals(feed.numPosts(),4);
        assertEquals(feed.viewWall("xXcharlieXx"),
                "Charlie: I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)\n" +
                        "Bob: Good game though. (1 minutes ago)\nBob: Darn! We lost! (2 minutes ago)\n" +
                        "Alice: I love the weather today. (5 minutes ago)");
}
}