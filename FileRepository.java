package smart_story;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileRepository implements IRepository {
    private static final String DEFAULT_EXTENSION = ".txt";
    private static final String SEPARATOR = "|";
    public FileRepository() {
    }
    @Override
    public boolean saveData(String filePath, List<String> data) {
     if (filePath == null || filePath.trim().isEmpty() || data == null) {
            System.out.println("Error: The file path or data is incorrect.");
            return false;
        }
         if (!filePath.endsWith(DEFAULT_EXTENSION)) {
            filePath += DEFAULT_EXTENSION;
        }
         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (String line : data) {
                if (line != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            System.out.println("Data has been successfully saved to: " + filePath);
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
            return false;
        }
    }
    @Override
    public List<String> loadData(String filePath) {

        List<String> data = new ArrayList<>();
      
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: The file path is incorrect.");
            return data;
        }
      
        if (!filePath.endsWith(DEFAULT_EXTENSION)) {
            filePath += DEFAULT_EXTENSION;
        }

      File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return data;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    data.add(line);
                }
            }

            System.out.println("Data loaded successfully " + data.size() + " Item from: " + filePath);
            return data;

        } catch (IOException e) {
            System.out.println("An error occurred while reading data: " + e.getMessage());
            return data;
        }
    }
    @Override
    public boolean exists(String filePath) {

        if (filePath == null || filePath.trim().isEmpty()) {
            return false;
        }

        if (!filePath.endsWith(DEFAULT_EXTENSION)) {
            filePath += DEFAULT_EXTENSION;
        }

        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
    @Override
    public boolean deleteData(String filePath) {

        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: Incorrect file path.");
            return false;
        }

        if (!filePath.endsWith(DEFAULT_EXTENSION)) {
            filePath += DEFAULT_EXTENSION;
        }

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist to delete: " + filePath);
            return false;
        }

        if (file.delete()) {
            System.out.println("File deleted successfully: " + filePath);
            return true;
        } else {
            System.out.println("Failed to delete the file: " + filePath);
            return false;
        }
    }
    public String buildLine(String... fields) {

        if (fields == null || fields.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i] == null ? "" : fields[i]);
            if (i < fields.length - 1) {
                sb.append(SEPARATOR);
            }
        }
        return sb.toString();
    }
    public String[] parseLine(String line) {

        if (line == null || line.trim().isEmpty()) {
            return new String[0];
        }

        return line.split("\\" + SEPARATOR);
    }
    public String ensureExtension(String filePath) {

        if (filePath == null || filePath.trim().isEmpty()) {
            return filePath;
        }

        return filePath.endsWith(DEFAULT_EXTENSION) ? filePath : filePath + DEFAULT_EXTENSION;
    }
    public String getSeparator() {
        return SEPARATOR;
    }

    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Override
    public String toString() {
        return "FileRepository{" +
                "extension='" + DEFAULT_EXTENSION + '\'' +
                ", separator='" + SEPARATOR + '\'' +
                '}';
    }
}
