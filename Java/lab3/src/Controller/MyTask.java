package Controller;

import Model.TextClasses.Sentence;
import Model.TextClasses.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MyTask {

    static ResourceBundle bundle;
    private static final Logger logger = Logger.getLogger( MyTask.class.getName() );

    /**
     * default constructor
     */
    public MyTask(ResourceBundle bundle){
        MyTask.bundle = bundle;
    }

    /**
     * Method that return words in sentence with count
     * @param sentences
     * @param words
     * @return
     */
    public ArrayList<Sentence> wordsInSentencesFunction(ArrayList<Sentence> sentences, ArrayList<Word> words) {
        ArrayList<Sentence> wordsInSentences = new ArrayList<>();
        for (Word wordToFind : words) {
            for (Sentence sentence : sentences) {
                ArrayList<Word> sentenceWords = sentence.getWords();
                int counter = 0;
                for (Word word : sentenceWords) {
                    if (word.getWord().equals(wordToFind.getWord())) {
                        counter++;
                    }
                }
                wordsInSentences.add(new Sentence(wordToFind, sentences.indexOf(sentence), counter));
            }
        }

        logger.info("Words in sentences");
        return wordsInSentences;
    }

    /**
     * Method that sort words by count in sentences
     * @param wordsInSentences
     * @return
     */

    public Map<String, Integer> sortWords(ArrayList<Sentence> wordsInSentences) {
        Map<String, Integer> myMap = new HashMap<>();
        for(int i = 0; i < wordsInSentences.size(); i++) {
            int count = 0;
            for(int j = 0; j < wordsInSentences.size(); j++) {
                if (wordsInSentences.get(j).getWord().toString().equals(wordsInSentences.get(i).getWord().toString())) {
                    count += wordsInSentences.get(j).getCount();
                }
            }

            Sentence wordInCurrentSentence = new Sentence(wordsInSentences.get(i).getWord(), count);

            myMap.put(wordInCurrentSentence.getWord().toString(), count);
        }

        logger.info("All words count in sentences");
        return myMap;
    }
}
