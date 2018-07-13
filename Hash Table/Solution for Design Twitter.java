package leetcode;

import java.util.List;
import java.awt.font.GraphicAttribute;
import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.text.DateFormatSymbols;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

import javax.naming.SizeLimitExceededException;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.spi.DirStateFactory.Result;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
import javax.tools.ToolProvider;
import javax.xml.ws.Endpoint;

import org.omg.CORBA.Current;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.w3c.dom.css.ElementCSSInlineStyle;

class Twitter {
    
    Map<Integer, Set<Integer>> user_followee;
    Map<Integer, Set<Integer>> user_follower;
    List<List<Integer>> posts_list;

    /** Initialize your data structure here. */
    public Twitter() {
        user_followee = new HashMap<>();
        user_follower = new HashMap<>();
        posts_list = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        posts_list.add(new ArrayList<>(Arrays.asList(userId, tweetId)));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int count = 0;
        Set<Integer> followee_set = new HashSet<>();
        followee_set.add(userId);
        if (user_followee.containsKey(userId))
            followee_set.addAll(user_followee.get(userId));
        List<Integer> res = new ArrayList<>();
        for (int i = posts_list.size()-1; i >= 0; i--) {
            List<Integer> user_tweet = posts_list.get(i);
            if (followee_set.contains(user_tweet.get(0))) {
                count++;
                res.add(user_tweet.get(1));
            }
            if (count == 10) break;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!user_followee.containsKey(followerId)) {
            user_followee.put(followerId, new HashSet<>());
        }
        user_followee.get(followerId).add(followeeId);
        if (!user_follower.containsKey(followeeId)) {
            user_follower.put(followeeId, new HashSet<>());
        }
        user_follower.get(followeeId).add(followerId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (user_followee.containsKey(followerId))
            user_followee.get(followerId).remove(followeeId);
        if (user_follower.containsKey(followeeId))
            user_follower.get(followeeId).remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */