package entity;

import java.util.Map;
import java.util.TreeMap;

public class Vocabulary {
    private static Vocabulary instance;
    private Map<String, Integer> vocabulary = new TreeMap<>();

    private Vocabulary() {
    }

    public static Vocabulary getInstance() {
        if (instance == null) {
            instance = new Vocabulary();
        }
        return instance;
    }

    public Map<String, Integer> getVocabulary() {
        return vocabulary;
    }

}
