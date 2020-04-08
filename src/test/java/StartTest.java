import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

public class StartTest {
    static BasicTest basicTest;
    //BeforeAll va ici s'executer une fois(Unique) avant le lancement de tout les test
    @BeforeAll
    public static void setupData(){
        ClassLoader classLoader = new StartTest().getClass().getClassLoader();
        try {
            //Convert string content of data.json to BasicTest object
            basicTest = new ObjectMapper().readValue(new File(classLoader.getResource("data.json").getFile()), BasicTest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void exampleVariable1(){
        assertEquals( 32L, basicTest.getExemple().getVariable1());
    }

    @Test
    public void exampleVariable2(){
        //bonjour etant le résultat attendu en premier parametre
        //en second parametre la valeur a tester
        assertEquals("bonjour", basicTest.getExemple().getVariable2());
    }
    @Test
    public void exampleVariable3(){
        assertArrayEquals(new String[]{"Hello", "world"}, basicTest.getExemple().getVariable3());
    }

    //TODO Check if compareNumber variable contain [57, 63, 48]
    @Test
    public void checkNumbers(){

    }

    //TODO Check if there is two user in users list
    @Test
    public void checkNumberOfUser(){

    }

    //TODO Check if thomas has admin role
    @Test
    public void isThomasAdmin(){

    }

    //TODO Check if thomas has 451 vue
    @Test
    public void thomasView(){

    }
}
