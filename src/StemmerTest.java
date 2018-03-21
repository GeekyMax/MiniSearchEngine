import org.tartarus.snowball.ext.englishStemmer;

import java.util.Scanner;

public class StemmerTest {
    public static void main(String[] args) throws Exception {
        englishStemmer englishStemmer = new englishStemmer();
//        String sentence = "  Lady. We will have vengeance for it, fear thou not.\n" +
//            "    Then weep no more. I'll send to one in Mantua,\n" +
//            "    Where that same banish'd runagate doth live,\n" +
//            "    Shall give him such an unaccustom'd dram\n" +
//            "    That he shall soon keep Tybalt company;\n" +
//            "    And then I hope thou wilt be satisfied.";
//        String[] words = sentence.split("[ \\.,:;\\(\\)!\\?]");
//        for (String word : words) {
//            englishStemmer.setCurrent(word);
//            englishStemmer.stem();
//            System.out.println(englishStemmer.getCurrent());
//        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.contains("exit")) break;
            else {
                englishStemmer.setCurrent(line.trim().toLowerCase());
                englishStemmer.stem();
                System.out.println(englishStemmer.getCurrent());
            }
        }
    }
}
