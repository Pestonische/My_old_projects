package additionalSystems;

import entity.Vocabulary;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {
    public void add(String[] words) {
        for (String word : words) {
            if (Vocabulary.getInstance().getVocabulary().containsKey(word)) {
                Vocabulary.getInstance().getVocabulary().put(word,
                        Vocabulary.getInstance().getVocabulary().get(word) + 1);
            } else {
                Vocabulary.getInstance().getVocabulary().put(word, 1);
            }
        }
    }

    public Map<String, Integer> sortByAlphabet() {
        return new TreeMap<>(new HashMap<>(Vocabulary.getInstance().getVocabulary()));
    }

    public Map<String, Integer> sortByFrequency(final boolean change) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(Vocabulary.getInstance().getVocabulary().entrySet());
        list.sort((o1, o2) -> change ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    }
}
