import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

public class StartTest {
    static BasicTest basicTest;
    @BeforeAll
    public static void setupData(){
        ClassLoader classLoader = new StartTest().getClass().getClassLoader();
        try {
            basicTest = new ObjectMapper().readValue(new File(classLoader.getResource("data.json").getFile()), BasicTest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void exampleVariable1(){
        assertEquals((long) 32, basicTest.getExemple().getVariable1());
    }
    @Test
    public void exampleVariable2(){
        assertEquals("bonjour", basicTest.getExemple().getVariable2());

    }
    @Test
    public void exampleVariable3(){
        assertArrayEquals(new String[]{"Hello", "world"}, basicTest.getExemple().getVariable3());
    }

    //TODO Check if compareNumber variable contain [57, 63, 48]
    @Test
    public void checkNumbers(){
        assertArrayEquals(new long[]{57, 63, 48}, basicTest.getCompareNumber());
    }

    //TODO Check if there is two user in users list
    @Test
    public void checkNumberOfUser(){
        assertEquals(2, basicTest.getUsers().length);
    }

    //TODO Check if thomas has admin role
    @Test
    public void isThomasAdmin(){
        for(User u : basicTest.getUsers()){
            if(u.getName() =="Thomas"){
                assertEquals("admin", u.getRole());
            }
        }
    }

    //TODO Check if thomas has 451 vue
    @Test
    public void thomasView(){
        for(User u : basicTest.getUsers()){
            if(u.getName() =="Thomas"){
                assertEquals(451, u.getVue());
            }
        }
    }
}
