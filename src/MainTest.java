import java.io.*;
import java.util.*;

public class MainTest {
    public static void main(String[] args) throws Exception {
        Map<String, Word> wordMap = new HashMap<>();

        String in;
        String out;
        MainTest mainTest = new MainTest();
        StopWords stopwords = StopWords.getInstance();
        Vector words = new Vector();
        stopwords.read("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/1.txt");
        stopwords.write("C:/Users/h2279/OneDrive/Course/A.D.S/mini search engine/without.txt");
        System.out.println(stopwords.stem("'"));
        wordMap = stopwords.getWordsMap();
//        for (Word word : wordMap.values()) {
//            System.out.print(word.getString() + ": ");
//            for (ReverseListItem item : word.getItemList()) {
//                System.out.print(item.getLineId() + ", ");
//            }
//            System.out.println();
//        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            String handledWord = line.trim().toLowerCase();
            if (line.contains("exit!")) {
                break;
            } else {
                if (wordMap.containsKey(handledWord)) {
                    Word word = wordMap.get(handledWord);
                    System.out.print(word.getString() + ": ");
                    for (ReverseListItem item : word.getItemList()) {
                        System.out.print(item.getLineId() + ", ");
                    }
                    System.out.println();
                } else {
                    System.out.println("not found!");
                }

            }
        }
    }

//    public String getWordsFromInput(String inputFile) {
//        Date start = new Date();
//        FileReader fileReader = null;
//        StringBuffer stringBuffer = new StringBuffer();
//        BufferedReader bufferedReader = null;
//        try {
//            fileReader = new FileReader(inputFile);
//            bufferedReader = new BufferedReader(fileReader);
//            String linevalue;
//            int i = 0;
//            while ((linevalue = bufferedReader.readLine()) != null) {
//                // 文件第一行保存行数
//                stringBuffer.append(linevalue);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                bufferedReader.close();
//                fileReader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return stringBuffer.toString();
//    }
}
