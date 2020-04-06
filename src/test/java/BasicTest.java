import com.cedarsoftware.util.io.JsonWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BasicTest {
    static  JSONObject data;
    @BeforeAll
    public static void setupData(){
        ClassLoader classLoader = new BasicTest().getClass().getClassLoader();

        try (FileReader reader = new FileReader(classLoader.getResource("data.json").getFile()))
        {
            JSONParser jsonParser = new JSONParser();

            //Read JSON file
            Object obj = jsonParser.parse(reader);

            data = (JSONObject) obj;
            System.out.println(JsonWriter.formatJson(data.toJSONString()));

            //Iterate over employee array

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void exampleVariable1(){
        JSONObject exemple = (JSONObject) ((JSONObject) data.get("basicTest")).get("exemple");
        assertEquals((long) 32, exemple.get("variable1"));
    }
    @Test
    public void exampleVariable2(){
        JSONObject exemple = (JSONObject) ((JSONObject) data.get("basicTest")).get("exemple");
        assertEquals("bonjour", exemple.get("variable2"));

    }
    @Test
    public void exampleVariable3(){
        JSONObject exemple = (JSONObject) ((JSONObject) data.get("basicTest")).get("exemple");
        assertArrayEquals(new String[]{"Hello", "world"}, (String[]) exemple.get("variable3"));
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
    public void isThomasAdmin(){

    }

    //TODO Check if thomas has 451 vue
    public void thomasView(){

    }
}
