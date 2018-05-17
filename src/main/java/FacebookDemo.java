import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FacebookDemo {

    public static void main(String [] args) throws IOException, NotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper();

        List<Facebook> listOfObjects = new ArrayList<>();

        String path = new File("src/main/resources/").getAbsolutePath()+"\\";
        System.out.println(path);

        //FileReader fr = new FileReader()
        listOfObjects.add(mapper.readValue(new File(path+"f1.json"), Facebook.class));
        listOfObjects.add(mapper.readValue(new File(path+"f2.json"), Facebook.class));
        listOfObjects.add(mapper.readValue(new File(path+"f3.json"), Facebook.class));
        listOfObjects.add(mapper.readValue(new File(path+"f4.json"), Facebook.class));
        listOfObjects.add(mapper.readValue(new File(path+"f5.json"), Facebook.class));
        //listOfObjects.add(mapper.readValue(classLoader.getResource("f5.json"), Facebook.class));
        listOfObjects.stream().forEach(System.out::println);
        System.out.println();

        FacebookApp facebookApp = new FacebookApp(listOfObjects);

        //System.out.println(facebookApp.findById("1"));
        //facebookApp.findMostCommonWords().entrySet().forEach(System.out::println);
        //facebookApp.findPostIdsByKeyword("them").stream().forEach(System.out::println);
        //facebookApp.findAll().stream().forEach(System.out::println);


    }

}
