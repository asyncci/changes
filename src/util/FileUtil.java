package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Driver;
import model.Truck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtil {
    private FileUtil() {
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("data/trucks.json");
    private static final Path PATH2 = Paths.get("data/drivers.json");

    public static Truck[] readFile() {
        try {
            String str = Files.readString(PATH);
            return GSON.fromJson(str, Truck[].class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Truck[0];
        }
    }
    public static Driver[] takeFile() {
        try {
            String str = Files.readString(PATH2);
            return GSON.fromJson(str, Driver[].class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Driver[0];
        }
    }


    public static void writeFile(Truck[] trucks) {
        String json = GSON.toJson(trucks);

        byte[] bytes = json.getBytes();
        try {
            Files.write(PATH, bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
