
import java.util.*;

public class DemoCollections {
    public static String cleanString(String s) {
        return s.toLowerCase().replaceAll("[^a-z]", "");
    }

    public static int countUniqueWords(List<String> words) {
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }

    public static List<String> getWords(String inputFileName) {
        List<String> words = new ArrayList<>();
        In in = new In(inputFileName);
        int count = 0;
        while (!in.isEmpty()) {
            count += 1;
            String nextWord = cleanString(in.readString());
            words.add(nextWord);
            System.out.println(nextWord);
        }
        System.out.println(count);
        return words;
    }

    //find the times of words in targetlist appear in wordslist, and return a new map counts{word:times}
    public static Map<String, Integer> collectWordCount(List<String> words, List<String> target) {
        Map<String, Integer> counts = new HashMap<>();
        for (String t : target) {
            counts.put(t, 0);
        }

        for (String word : words) {
            if (counts.containsKey(word)) {
                int oldCount = counts.get(word);
                counts.put(word, oldCount + 1);
            }

        }
        return counts;
    }

    public static void main(String[] args) {
        List<String> w = getWords("file/SteveJobsInStandford");
        //System.out.println(w);
        System.out.println(">> unique words in text: " + countUniqueWords(w));

        List<String> target = new ArrayList<>();
        target.add("apple");
        target.add("you");
        target.add("my");
        System.out.println(collectWordCount(w, target));
    }
}
