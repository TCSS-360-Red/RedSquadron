import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HistoryList {
    private Map<Integer, String> historyMap;
    private Map<Integer, LocalDateTime> dateTimeMap;
    private DateTimeFormatter formatter;

    public HistoryList() {
        historyMap = new HashMap<>();
        dateTimeMap = new HashMap<>();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void addHistory(String description, float price, int identifier) {
        LocalDateTime dateTime = LocalDateTime.now();
        String formattedDateTime = dateTime.format(formatter);
        String historyEntry = formattedDateTime + " - Task #" + identifier + ": " + description + " - " + price + " USD";
        historyMap.put(identifier, historyEntry);
        dateTimeMap.put(identifier, dateTime);
    }

    public Map<Integer, String> getHistoryMap() {
        return new HashMap<>(historyMap);
    }

    public void saveHistoryToFile(String filename) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            for (int identifier : historyMap.keySet()) {
                LocalDateTime dateTime = dateTimeMap.get(identifier);
                String formattedDateTime = dateTime.format(formatter);
                String historyEntry = historyMap.get(identifier);
                writer.write(formattedDateTime + " - " + historyEntry + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadHistoryFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" - ", 2);
                LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
                String historyEntry = parts[1];
                int identifierStartIndex = historyEntry.indexOf("#") + 1;
                int identifierEndIndex = historyEntry.indexOf(":");
                int identifier = Integer.parseInt(historyEntry.substring(identifierStartIndex, identifierEndIndex));
                historyMap.put(identifier, historyEntry);
                dateTimeMap.put(identifier, dateTime);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTaskHistory(int identifier) {
        return historyMap.get(identifier);
    }
}