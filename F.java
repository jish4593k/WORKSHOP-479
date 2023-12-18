import java.io.*;
import java.util.Map;

public class FileHandler {

    public static void writeObjectToFile(String filename, Object data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(data);
            System.out.println("Written to file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeJsonToFile(String filename, Map<String, Object> data) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
            System.out.println("Written to file " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> readJsonFromFile(String filename) {
        try (Reader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
