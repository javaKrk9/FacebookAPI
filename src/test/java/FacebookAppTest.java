import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FacebookAppTest {

    List<Facebook> facebookList;

    @Test
    public void init()
    {
        facebookList = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        String path = new File("src/main/resources/").getAbsolutePath()+"\\";
        try {
            facebookList.add(mapper.readValue(new File(path+"f1.json"), Facebook.class));
            facebookList.add(mapper.readValue(new File(path+"f2.json"), Facebook.class));
            facebookList.add(mapper.readValue(new File(path+"f3.json"), Facebook.class));
            facebookList.add(mapper.readValue(new File(path+"f4.json"), Facebook.class));
            facebookList.add(mapper.readValue(new File(path+"f5.json"), Facebook.class));
        } catch (IOException e) {
            assertTrue("Problem z ładowaniem", true);
            //e.printStackTrace();
        }
    }

    @Test
    public void findById() {

    }

    @Test
    public void findMostCommonWords() {

    }

    @Test
    public void findPostIdsByKeyword() {

    }

    @Test
    public void findAll() {

    }

}