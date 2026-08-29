package assigment_problems;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }

    static void printFilteredWordFrequency(String feedback) {
        String[] stopWordsArray = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopWords = new HashSet<>(Arrays.asList(stopWordsArray));
        
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    
}
