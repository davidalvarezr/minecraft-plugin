package test.me.devdav.insultplayers.location;

import me.devdav.insultplayers.location.Corner;
import me.devdav.insultplayers.location.PinnedLocation;
import org.bukkit.Location;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


/**
 * PinnedLocation Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>oct. 31, 2020</pre>
 */
public class PinnedLocationTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: hasInside(Location minecraftLocation)
     */
    @Test
    public void testHasInside() throws Exception {
        PinnedLocation pinnedLocation = new PinnedLocation(
                "Bienvenue dans la maison principale",
                "On espère vous revoir bientôt dans la maison principale",
                new Corner(-386, -66),
                new Corner(-371, -66),
                new Corner(-371, -45),
                new Corner(-386, -45)
        );

        Location from5 = new Location(null, -370, 64, -66);
        Location from6 = new Location(null, -371, 64, -67);
        Location to3 = new Location(null, -371, 64, -66);

        Location from3 = new Location(null, -387, 64, -66);
        Location from4 = new Location(null, -386, 64, -67);
        Location to2 = new Location(null, -386, 64, -66);

        Location from7 = new Location(null, -370, 64, -45);
        Location from8 = new Location(null, -371, 64, -44);
        Location to4 = new Location(null, -371, 64, -45);

        Location from1 = new Location(null, -387, 64, -45);
        Location from2 = new Location(null, -386, 64, -44);
        Location to1 = new Location(null, -386, 64, -45);


        Assert.assertFalse(pinnedLocation.hasInside(from5));
        Assert.assertFalse(pinnedLocation.hasInside(from6));
        Assert.assertTrue(pinnedLocation.hasInside(to3));

        Assert.assertFalse(pinnedLocation.hasInside(from3));
        Assert.assertFalse(pinnedLocation.hasInside(from4));
        Assert.assertTrue(pinnedLocation.hasInside(to2));

        Assert.assertFalse(pinnedLocation.hasInside(from7));
        Assert.assertFalse(pinnedLocation.hasInside(from8));
        Assert.assertTrue(pinnedLocation.hasInside(to4));

        Assert.assertFalse(pinnedLocation.hasInside(from1));
        Assert.assertFalse(pinnedLocation.hasInside(from2));
        Assert.assertTrue(pinnedLocation.hasInside(to1));



    }


} 
