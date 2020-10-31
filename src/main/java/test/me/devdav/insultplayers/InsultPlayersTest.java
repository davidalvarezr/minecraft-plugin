package test.me.devdav.insultplayers;

import me.devdav.insultplayers.InsultPlayers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.lang.reflect.Method;

/**
 * InsultPlayers Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>oct. 31, 2020</pre>
 */
public class InsultPlayersTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: onEnable()
     */
    @Test
    public void testOnEnable() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: onDisable()
     */
    @Test
    public void testOnDisable() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: onPlayerJoin(PlayerJoinEvent e)
     */
    @Test
    public void testOnPlayerJoin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: onPlayerQuit(PlayerQuitEvent e)
     */
    @Test
    public void testOnPlayerQuit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: onPlayerEnterBed(PlayerBedEnterEvent e)
     */
    @Test
    public void testOnPlayerEnterBed() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: onPlayerLeaveBed(PlayerBedLeaveEvent e)
     */
    @Test
    public void testOnPlayerLeaveBed() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: onCommand(CommandSender sender, Command command, String label, String[] args)
     */
    @Test
    public void testOnCommand() throws Exception {
//TODO: Test goes here... 
    }


    /**
     * Method: removeArticle(String insultWithArticle)
     */
    @Test
    public void testRemoveArticle() throws Exception {
        String[] insultsWithArticle = new String[]{
                "le bâtard",
                "la petite pute",
                "l'enculé"
        };
        String[] insultsWithoutArticle = new String[]{
                "bâtard",
                "petite pute",
                "enculé"
        };

        Method method = InsultPlayers.class.getDeclaredMethod("removeArticle", String.class);
        method.setAccessible(true);

        for (int i=0; i < insultsWithArticle.length; i++) {
            String insultWithoutArticle = (String) method.invoke(null, insultsWithArticle[i]);
            System.out.println(insultsWithoutArticle[i] + " == " + insultWithoutArticle + " ?");
            Assert.assertEquals(insultWithoutArticle, insultsWithoutArticle[i]);
        }




    }

    /**
     * Method: getRandomInsult()
     */
    @Test
    public void testGetRandomInsult() throws Exception {
//TODO: Test goes here...
/*try {
   Method method = InsultPlayers.getClass().getMethod("getRandomInsult");
   method.setAccessible(true);
   method.invoke(<Object>, <Parameters>);
} catch(NoSuchMethodException e) {
} catch(IllegalAccessException e) {
} catch(InvocationTargetException e) {
}*/
    }

} 
