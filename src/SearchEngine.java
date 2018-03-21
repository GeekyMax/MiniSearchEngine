import org.tartarus.snowball.ext.englishStemmer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class SearchEngine {
    private int wordCount;
    private int docIdCount;
    private StopWords stopWords;
    private englishStemmer englishStemmer;
    private List<String> docPathList;
    private static SearchEngine searchEngine;
    private Map<String, Word> wordMap;

    private SearchEngine() {
        wordCount = 0;
        docIdCount = 1;
        wordMap = new HashMap<>();
        stopWords = StopWords.getInstance();
        englishStemmer = new englishStemmer();
        docPathList = new ArrayList<>();
    }

    public static SearchEngine getInstance() {
        if (searchEngine == null) {
            searchEngine = new SearchEngine();
        }
        return searchEngine;
    }

    public void addDocPath(String path) {
        docPathList.add(path);
    }

    public void createIndex() throws Exception {
        for (String docPath : docPathList) {
            String[] docPaths = docPath.split("/");
            String docName = docPaths[docPaths.length - 1];
            handleDoc(docPath, docName, docIdCount++);
        }
    }

    public Word queryWord(String input) {
        englishStemmer.setCurrent(input.trim().toLowerCase());
        englishStemmer.stem();
        String stemmedWord = englishStemmer.getCurrent();
        if (wordMap.containsKey(stemmedWord)) {
            return wordMap.get(stemmedWord);
        } else {
            return null;
        }
    }

    private void handleDoc(String docPath, String docName, int docId) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(docPath)));
        String line;
        int lineIdCount = 1;
        while ((line = reader.readLine()) != null) {
            handleLine(line, lineIdCount, docId);
            lineIdCount++;
        }
        reader.close();
    }

    private void handleLine(String line, int lineId, int docId) {
        int positionCount = 0;
        englishStemmer englishStemmer = new englishStemmer();
        for (String word : line.split("[ \\.,:;\\(\\)!\\?]")) {
            if (word.trim().length() > 0) {
                String handledWord = word.trim().toLowerCase();
                englishStemmer.setCurrent(handledWord);
                englishStemmer.stem();
                handledWord = englishStemmer.getCurrent();
                if (!stopWords.isStopWord(handledWord)) {
                    if (wordMap.containsKey(handledWord)) {
                        wordMap.get(handledWord).addItem(new ReverseListItem(docId, lineId, positionCount));
                    } else {
                        Word newWord = new Word(handledWord, wordCount++);
                        newWord.addItem(new ReverseListItem(docId, lineId, positionCount));
                        wordMap.put(handledWord, newWord);
                    }
                }
            }
        }
    }
}
