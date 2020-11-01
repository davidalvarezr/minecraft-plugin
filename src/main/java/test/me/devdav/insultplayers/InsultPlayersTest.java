package test.me.devdav.insultplayers;

import me.devdav.insultplayers.helpers.InsultGenerator;
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
     * Method: removeArticle(String insultWithArticle)
     */
    @Test
    public void testRemoveArticle() throws Exception {
        InsultGenerator insultGenerator = InsultGenerator.getInstance();

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

        Method method = InsultGenerator.class.getDeclaredMethod("removeArticle", String.class);
        method.setAccessible(true);

        for (int i=0; i < insultsWithArticle.length; i++) {
            String insultWithoutArticle = (String) method.invoke(insultGenerator, insultsWithArticle[i]);
            System.out.println(insultsWithoutArticle[i] + " == " + insultWithoutArticle + " ?");
            Assert.assertEquals(insultWithoutArticle, insultsWithoutArticle[i]);
        }
    }

} 
