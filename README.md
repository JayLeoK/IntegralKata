# IntegralKata
Social media domain logic coding challenge

To test what user sees, profile and post entities exist in the feed object. FeedTests.java tests all features specified by the kata.

Profile
- String handle ("alice123")
- String name ("Alice")
- ArrayList of following profile handles

Post
- String handle ("alice123")
- String body ("I love the weather today.")
- String Timestamp

Feed
- Hashmap of handles to Profiles
- ArrayList of Posts (ordered by timestamp)
- HashMap of handles to ArrayList of indices, each index corresponding with posts

TEST: Publishing, Timeline, and Following

Note: Adapted code for timestamp from
https://stackoverflow.com/questions/18915075/java-convert-string-to-timestamp
