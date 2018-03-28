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
    private List<String> testDataEncode = new ArrayList<>();
    private List<String> testDataDecode = new ArrayList<>();


    @BeforeAll
    public void initAll(){
        readTestData("EncodeTestData", testDataEncode);
        readTestData("DecodeTestData", testDataDecode);
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
        if(testDataEncode.isEmpty())
            readTestData("EncodeTestData", testDataEncode);

        for(int i = 1; i <= testDataEncode.size(); i+=2){
            assertEquals(testDataEncode.get(i), URIComponent.encode(testDataEncode.get(i - 1)));
        }
    }

    /**
     * Tests the decoding operation.
     */
    @Test
    @DisplayName("Test Decoding")
    @SuppressWarnings("unchecked")
    public void testDecoding(){
        if(testDataDecode.isEmpty())
            readTestData("DecodeTestData", testDataDecode);

        for(int i = 1; i <= testDataDecode.size(); i+=2){
            assertEquals(testDataDecode.get(i), URIComponent.decode(testDataDecode.get(i - 1)));
        }
    }
}
