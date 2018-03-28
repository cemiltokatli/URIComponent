package com.cemiltokatli.uricomponent.test;

import com.cemiltokatli.uricomponent.URIComponent;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.io.File;

/**
 * This class is designed for testing the URIComponent class.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class URIComponentTest {
    private List<String> testData = new ArrayList<>();

    @BeforeAll
    public void initAll(){
        readTestData("EncodeTestData", testData);
    }

    /**
     * Reads the test data from the given file and assign it to the given source array
     *
     * @param fileName
     * @param source
     */
    public void readTestData(String fileName, List<String> source){
        //Read the test data
        try{
            //Read file
            ClassLoader classLoader = getClass().getClassLoader();
            File testFile = new File(classLoader.getResource(fileName+".json").getFile());
            byte[] byteData = Files.readAllBytes(testFile.toPath());
            String data = new String(byteData, "utf-8");


            //Parse JSON
            JSONObject parsedData = new JSONObject(data);
            JSONArray items = parsedData.getJSONArray("data");
            JSONObject item;

            //Set data
            for(int i = 0; i < items.length(); i++){
                source.add(items.getJSONObject(i).getString("actual"));
                source.add(items.getJSONObject(i).getString("expected"));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Tests the encoding operation.
     */
    @Test
    @DisplayName("Test Encoding")
    @SuppressWarnings("unchecked")
    public void testEncoding(){
        if(testData.isEmpty())
            readTestData("EncodeTestData", testData);

        for(int i = 1; i <= testData.size(); i+=2){
            assertEquals(testData.get(i), URIComponent.encode(testData.get(i - 1)));
        }
    }
}
