package de.novatec.metriccollector;


import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.amazonaws.services.lambda.runtime.Context;

public class Application {

    final static String CONSUMER_KEY = System.getenv("TWITTER_CONSUMER_KEY");

    final static String CONSUMER_SECRET = System.getenv("TWITTER_CONSUMER_SECRET");

    final static String ACCESS_TOKEN = System.getenv("TWITTER_ACCESS_TOKEN");

    final static String ACCESS_TOKEN_SECRET = System.getenv("TWITTER_ACCESS_TOKEN_SECRET");


    public static Twitter getTwitterInstance() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CONSUMER_KEY)
                .setOAuthConsumerSecret(CONSUMER_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());

        return tf.getInstance();
    }

    public static String searchtweets(InputStream inputStream, OutputStream outputStream, Context context) throws TwitterException, InterruptedException {

        TimeUnit.SECONDS.sleep(3);

        return "tweets_per_whatever " + context.getRemainingTimeInMillis();
    }


}
