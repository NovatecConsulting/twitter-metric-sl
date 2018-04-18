package de.novatec.metriccollector;


import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.*;

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

    public static String searchtweets() throws TwitterException {
        Twitter twitter = getTwitterInstance();
        Calendar now = Calendar.getInstance();


        Paging paging = new Paging(1, 200);

        List<Status> statusList = new ArrayList<Status>();
        int page = 1;
        boolean notAllTweets = true;
        while (notAllTweets) {
            System.out.println(page);
            ResponseList<Status> statuses = twitter.getUserTimeline(281595713, paging);
            if (statuses.isEmpty()) {
                notAllTweets = false;
            } else {
                statusList.addAll(statuses);
            }
            paging.setPage(++page);

        }


        Calendar january = Calendar.getInstance();
        january.set(2017, Calendar.JANUARY, 1);

        Calendar february = Calendar.getInstance();
        february.set(2017, Calendar.FEBRUARY, 1);

        Calendar march = Calendar.getInstance();
        march.set(2017, Calendar.MARCH, 1);

        Calendar april = Calendar.getInstance();
        april.set(2017, Calendar.APRIL, 1);

        Calendar may = Calendar.getInstance();
        may.set(2017, Calendar.MAY, 1);

        Calendar june = Calendar.getInstance();
        june.set(2017, Calendar.JUNE, 1);

        Calendar july = Calendar.getInstance();
        july.set(2017, Calendar.JULY, 1);

        Calendar august = Calendar.getInstance();
        august.set(2017, Calendar.AUGUST, 1);

        Calendar september = Calendar.getInstance();
        september.set(2017, Calendar.SEPTEMBER, 1);

        Calendar october = Calendar.getInstance();
        october.set(2017, Calendar.OCTOBER, 1);

        Calendar november = Calendar.getInstance();
        november.set(2017, Calendar.NOVEMBER, 1);

        Calendar december = Calendar.getInstance();
        december.set(2017, Calendar.DECEMBER, 1);


        Calendar january18 = Calendar.getInstance();
        january18.set(2018, Calendar.JANUARY, 1);

        Calendar february18 = Calendar.getInstance();
        february18.set(2018, Calendar.FEBRUARY, 1);

        Calendar march18 = Calendar.getInstance();
        march18.set(2018, Calendar.MARCH, 1);

        Calendar april18 = Calendar.getInstance();
        april18.set(2018, Calendar.APRIL, 1);


        long countJanuary = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(january.getTime()) && date.before(reduceOneMS(february.getTimeInMillis()))).count();
        long countFebruary = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(february.getTime()) && date.before(reduceOneMS(march.getTimeInMillis()))).count();
        long countMarch = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(march.getTime()) && date.before(reduceOneMS(april.getTimeInMillis()))).count();
        long countApril = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(april.getTime()) && date.before(reduceOneMS(may.getTimeInMillis()))).count();
        long countMay = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(may.getTime()) && date.before(reduceOneMS(june.getTimeInMillis()))).count();
        long countJune = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(june.getTime()) && date.before(reduceOneMS(july.getTimeInMillis()))).count();
        long countJuly = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(july.getTime()) && date.before(reduceOneMS(august.getTimeInMillis()))).count();
        long countAugust = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(august.getTime()) && date.before(reduceOneMS(september.getTimeInMillis()))).count();
        long countSeptember = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(september.getTime()) && date.before(reduceOneMS(october.getTimeInMillis()))).count();
        long countOctober = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(october.getTime()) && date.before(reduceOneMS(november.getTimeInMillis()))).count();
        long countNovember = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(november.getTime()) && date.before(reduceOneMS(december.getTimeInMillis()))).count();
        long countDezember = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(december.getTime()) && date.before(reduceOneMS(january18.getTimeInMillis()))).count();


        long countJanuary18 = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(january18.getTime()) && date.before(reduceOneMS(february18.getTimeInMillis()))).count();
        long countFebruary18 = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(february18.getTime()) && date.before(reduceOneMS(march18.getTimeInMillis()))).count();
        long countMarch18 = statusList.stream().map(Status::getCreatedAt).filter(date -> date.after(march18.getTime()) && date.before(reduceOneMS(april18.getTimeInMillis()))).count();


        return "<html>" +
                "Tagesdatum: " + now.getTime() + "<br>"+
                "-----------------------------2017----------------------------------<br>" +

                "<b>Q1/17: " + "#Gesamt " + (countJanuary+countFebruary+countMarch) + " Tweets</b>" + "<br>"+
                " -----> " + "# Januar " + countJanuary + " Tweets" + "<br>"+
                " -----> " + "# Februar " + countFebruary + " Tweets" + "<br>"+
                " -----> " + "# Maerz " + countMarch + " Tweets" + "<br>"+
                "<br>"+

                "<b>Q2/17: " + "#Gesamt " + (countApril+countMay+countJune) + " Tweets</b>" + "<br>"+
                " -----> " + "# April " + countApril + " Tweets" + "<br>"+
                " -----> " + "# May " + countMay + " Tweets" + "<br>"+
                " -----> " + "# Juni " + countJune + " Tweets" + "<br>"+
                "<br>"+

                "<b>Q3/17: " + "#Gesamt " + (countJuly+countAugust+countSeptember) + " Tweets</b>" + "<br>"+
                " -----> " + "# Juli " + countJuly + " Tweets" + "<br>"+
                " -----> " + "# August " + countAugust + " Tweets" + "<br>"+
                " -----> " + "# September " + countSeptember + " Tweets" + "<br>"+
                "<br>"+

                "<b>Q4/17: " + "#Gesamt " + (countOctober+countNovember+countDezember) + " Tweets</b>" + "<br>"+
                " -----> " + "# Oktober " + countOctober + " Tweets" + "<br>"+
                " -----> " + "# November " + countNovember + " Tweets" + "<br>"+
                " -----> " + "# Dezember " + countDezember + " Tweets" + "<br>"+
                "<br>"+

                "-----------------------------2018----------------------------------<br>" +

                "<b>Q1/18: " + "#Gesamt " + (countJanuary18+countFebruary18+countMarch18) + " Tweets</b>" + "<br>"+
                " -----> " + "# Januar " + countJanuary18 + " Tweets" + "<br>"+
                " -----> " + "# Februar " + countFebruary18 + " Tweets" + "<br>"+
                " -----> " + "# Maerz " + countMarch18 + " Tweets" + "<br>"+
                "<br>"+
                "</html>";
    }


    public static void main(String[] args) throws TwitterException, JSONException {
        String result = searchtweets();
        System.out.println(result);
    }


    public static Date reduceOneMS(long millis) {

        return new Date(millis - 1);
    }

}
