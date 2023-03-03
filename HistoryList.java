import java.io.*;
import java.util.*;

/**
 * A list to store the history of tasks.
 * Each history item is represented as a map that contains the time, heading, and task content.
 * The history can be saved to a .txt file.
 * The implementation assumes that the .txt file has the following format:
 * Each line in the file represents a single history item, and contains the following fields separated by commas:
 * time,heading,task_content
 * 
 * @author Ngou In Chu
 * @version Red.1
 */
public class HistoryList {
    private List<Map<String, String>> historyList;

    public HistoryList() {
        historyList = new ArrayList<>();
    }

    /**
     * Adds a new history item to the list.
     * 
     * @param heading the heading for the history item.
     * @param content the task content for the history item.
     */
    public void addHistory(String heading, String content) {
        Map<String, String> item = new HashMap<>();
        item.put("time", new Date().toString());
        item.put("heading", heading);
        item.put("content", content);
        historyList.add(item);
    }

    /**
     * Saves the history to a .txt file.
     * The file is saved in the current directory with the given file name.
     * Each line in the file represents a single history item, and contains the following fields separated by commas:
     * time,heading,task_content
     * 
     * @param fileName the name of the file to save the history to.
     */
    public void saveHistory(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Map<String, String> item : historyList) {
                String line = item.get("time") + "," + item.get("heading") + "," + item.get("content") + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the history to file.");
            e.printStackTrace();
        }
    }
}