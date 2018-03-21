import java.io.*;
import java.util.*;

public class MainTest {
    public static void main(String[] args) throws Exception {
        SearchEngine searchEngine = SearchEngine.getInstance();
        searchEngine.addDocPath("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/1.txt");
        searchEngine.addDocPath("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/2.txt");
        searchEngine.addDocPath("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/3.txt");
        searchEngine.addDocPath("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/4.txt");
        searchEngine.addDocPath("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/5.txt");
        searchEngine.createIndex();
        System.out.println("index created successfully!");
        Scanner scanner = new Scanner(System.in);
        String line = "";
        Word word = null;
        while (true) {
            line = scanner.nextLine();
            if (line.contains("exit")) {
                break;
            } else {
                word = searchEngine.queryWord(line.trim().toLowerCase());
                if (word != null) {
                    System.out.println("Id: " + word.getId());
                    for (ReverseListItem item : word.getItemList()) {
                        System.out.println("DocId, lineId, position: " + item.getDocId() + ", " + item.getLineId() + ", " + item.getPosition());
                    }
                } else {
                    System.out.println("not found");
                }
            }
        }

    }
}
