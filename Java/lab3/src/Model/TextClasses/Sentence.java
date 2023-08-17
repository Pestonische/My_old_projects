package Model.TextClasses;

import java.util.ArrayList;
/**
 * Class Sentence describing part of Text
 */
public class Sentence extends TextPart {

    /**
     * private field - array of parts of sentence
     */
    private ArrayList<TextPart> sentencesParts;

    /**
     * GetMethod for field sentencesParts
     * @return parts of sentence
     */
    public ArrayList<TextPart> getSentencesParts() {
        return sentencesParts;
    }

    /**
     * Default constructor
     */
    public Sentence() {
        this.sentencesParts = new ArrayList<>();
    }

    /**
     * Constructor with parameter
     * @param parts
     */
    public Sentence(ArrayList<TextPart> parts) {
        this.sentencesParts = parts;
    }

    /**
     * Method that add word or punctuation mark to the sentence
     * @param tp - new part of sentence
     */
    public void addSentencePart(TextPart tp) {
        sentencesParts.add(tp);
    }

    /**
     * Method that gets all words in sentence
     * @return array of words
     */
    public ArrayList<Word> getWords(){
        ArrayList<Word> words = new ArrayList<>();
        for(TextPart tp : sentencesParts){
            if(tp.getClass() == Word.class){
                words.add((Word)tp);
            }
        }
        return words;
    }

    public ArrayList<Punctuation> getMarks(){
        ArrayList<Punctuation> punctuations = new ArrayList<>();
        for(TextPart tp : sentencesParts){
            if(tp.getClass() == Punctuation.class){
                punctuations.add((Punctuation) tp);
            }
        }
        return punctuations;
    }

    /**
     * Override method toString()
     * @return sentence
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(TextPart tp : sentencesParts){
            if(!s.toString().equals("") && tp.getClass() != Punctuation.class){
                s.append(" ");
            }
            s.append(tp);
        }
        return s.toString();
    }

    private Word word;
    private int numSentence;
    private int count;

    public Sentence(Word word, int numSentence, int count) {
        this.word = word;
        this.numSentence = numSentence;
        this.count = count;
    }

    public Sentence(Word word, int count) {
        this.word = word;
        this.count = count;
    }

    public Word getWord() {
        return word;
    }
    public int getCount() {
        return count;
    }
    public int getNumSentence() {
        return numSentence;
    }
}
