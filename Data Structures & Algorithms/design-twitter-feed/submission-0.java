class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> tweets;

    int time = 0;

    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(new Tweet(tweetId, time++));
    }



    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =  new PriorityQueue<>((a, b) -> b.time - a.time);

        // User's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }

        // Followed users' tweets
        if (followMap.containsKey(userId)) {

            for (int followeeId : followMap.get(userId)) {

                if (tweets.containsKey(followeeId)) {
                    pq.addAll(tweets.get(followeeId));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        int count = 0;

        while (!pq.isEmpty() && count < 10) {

            result.add(pq.poll().tweetId);

            count++;
        }

        return result;
    }




    public void follow(int followerId, int followeeId) {

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}