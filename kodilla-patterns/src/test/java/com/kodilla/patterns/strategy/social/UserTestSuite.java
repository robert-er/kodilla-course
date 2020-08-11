package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User m = new Millenials("Millo");
        User y = new YGeneration("Y-Gen");
        User z = new ZGeneration("Z-Gen");

        //When
        String mPublish = m.sharePost();
        System.out.println("User " + m.getName() + " " + mPublish);
        String yPublish = y.sharePost();
        System.out.println("User " + y.getName() + " " + yPublish);
        String zPublish = z.sharePost();
        System.out.println("User " + z.getName() + " " + zPublish);

        //Then
        Assert.assertEquals("share post on SnapChat", mPublish);
        Assert.assertEquals("share post on Twitter", yPublish);
        Assert.assertEquals("share post on Facebook", zPublish);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User m = new Millenials("Millo");

        //When
        String mPublish = m.sharePost();
        System.out.println("User " + m.getName() + " " + mPublish);
        m.setSocialPublisher(new FacebookPublisher());
        mPublish = m.sharePost();
        System.out.println("User " + m.getName() + " now " + mPublish);

        //Then
        Assert.assertEquals("share post on Facebook", mPublish);
    }
}
