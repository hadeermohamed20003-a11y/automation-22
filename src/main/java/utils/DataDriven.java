package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataDriven {

    public static JSONObject jsonReader() {

        String filePath = "src/test/resources/testData.json";

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return new JSONObject(content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read testData.json");
        }
    }
}