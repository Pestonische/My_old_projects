package View;

import Controller.MyTask;
import Controller.Parsers.ParseSentence;
import Controller.Parsers.ParseText;
import Model.EmptyFileException;
import Model.TextClasses.*;
import Model.TextException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Main {
    static ResourceBundle bundle;
    static String stringtext = "";
    static ArrayList<Word> stringtWords = new ArrayList<>();
    private static final Logger logger = Logger.getLogger( Main.class.getName() );


    public static void main(String[] args) throws EmptyFileException, TextException{
        setLocale();
        if (!readFile("text.txt")){
            System.out.println(bundle.getString("ErrorWithReadingFile"));
            return;
        }

        if (stringtext == "") {
            logger.info("File is empty!!!");
            //throw new EmptyFileException(bundle.getString("FileIsEmpty"));
            System.out.println(bundle.getString("FileIsEmpty"));
            return;
        }

        ParseText parseText = createParseChain();
        Text text = (Text) parseText.parse(stringtext);

        if (text.getSentences().size() == 0 && text.getCode().size() == 0) {
            logger.info("No sentences and parts of code in text!");
            //throw new TextException(bundle.getString("NullArrayParts"));
            System.out.println(bundle.getString("NullArrayParts"));
            return;
        }

        System.out.println("\n\n" + bundle.getString("AllText") + "\n");
        System.out.println(text);


        if (text.getSentences().size() == 0) {
            logger.info( "No sentences in text!");
            //throw new TextException(bundle.getString("NoSentences"));
            System.out.println(bundle.getString("NoSentences"));
            return;
        }
        System.out.println(bundle.getString("Sentences") + "\n");
        ArrayList<Sentence> sentences = text.getSentences();
        for(Sentence sentence: sentences) {
            System.out.println(sentence);
        }
        System.out.println("\n\n" + bundle.getString("Words"));
        ArrayList<Word> words1 = sentences.get(0).getWords();
        for(Word word: words1) {
            System.out.print(word);
            System.out.print(", ");
        }

        System.out.println("\n\n" + bundle.getString("Punctuation"));
        ArrayList<Punctuation> punctuations1 = sentences.get(0).getMarks();
        for(Punctuation punctuation: punctuations1) {
            System.out.print(punctuation);
            System.out.print(" ");
        }

        if (!readWordsFile("text1.txt")){
            System.out.println(bundle.getString("ErrorWithReadingFile"));
            return;
        }

        if (stringtWords.size() == 0) {
            System.out.println("File is empty!");
            System.out.println(bundle.getString("FileIsEmpty"));
            return;
        }

        System.out.println("\n\n" + bundle.getString("MyTask") + "\n" + bundle.getString("WordsInSentence"));
        MyTask myTask = new MyTask(bundle);
        ArrayList <Sentence> wordsInSentences = myTask.wordsInSentencesFunction(sentences, stringtWords);
        for(Sentence word: wordsInSentences) {
            System.out.println("Word " + word.getWord().toString() +
                    " in " + word.getNumSentence() + " sentence: " + word.getCount());
        }
        System.out.println(bundle.getString("sortWords"));
        Map<String, Integer> words =  myTask.sortWords(wordsInSentences);
        for(Map.Entry<String, Integer> item : words.entrySet()){

            System.out.printf("%s %d \n", item.getKey(), item.getValue());
        }

    }

    private static ParseText createParseChain() {
        ParseText parseText = new ParseText();
        parseText.setNextParse(new ParseSentence());
        return parseText;
    }

    private static boolean readFile(String filename) {
        try {
            Files.lines(Paths.get(filename)).forEach(s -> stringtext += s);
        } catch (Exception ex) {
            logger.info(ex.toString());
            return false;
        }
        return true;
    }

    private static boolean readWordsFile(String filename) {
        try {
            Files.lines(Paths.get(filename)).forEach(s -> stringtWords.add(new Word(s)));
        } catch (Exception ex) {
            logger.info(ex.toString());
            return false;
        }
        return true;
    }


    private static void setLocale() {
        Locale enLocale = new Locale("en", "EN", "UNIX");
        Locale ruLocale = new Locale("ru", "RU", "UNIX");
        Locale beLocale = new Locale("be", "BY", "UNIX");
        bundle = ResourceBundle.getBundle("Model.Localization.Localization", enLocale);
    }
}
