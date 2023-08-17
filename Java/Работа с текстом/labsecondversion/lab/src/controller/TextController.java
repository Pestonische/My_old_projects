package controller;

import additionalSystems.Main;
import additionalSystems.WindowApp;
import com.sun.media.sound.InvalidDataException;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;
import entity.TextVoc;
import entity.Vocabulary;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TextController {

    public static ArrayList<TextVoc> texts = new ArrayList<>();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button open;

    @FXML
    private Button openColor;

    @FXML
    private Button button;

    @FXML
    private Text textFile;

    public static String fileName;

    public static String colorText;

    @FXML
    void initialize() {
        textFile.setStyle("-fx-fill:  #8B008B;");

        if (MenuController.checkFile == 2) {
            openColor.setVisible(true);
        }

        button.setOnAction(event1 -> {
            new WindowApp().getWindow(button, "../forms/MenuForm.fxml");
        });

        open.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(Main.primary);
            //File file=new File("textHello.txt");
            if (file != null) {
                textFile.setText("Τΰιλ: " + file.getPath());
                textFile.setStyle("-fx-fill:  #8B008B;");
                fileName = file.getPath();
                texts.add(new TextVoc(readTextToString(), file.getName()));
                button.setOnAction(event1 -> {
                    if (MenuController.checkFile == 0) {
                        readText();
                    } else if (MenuController.checkFile == 1) {
                        readVoc();
                    } else {
                        colorText(readTextToString());
                        new WindowApp().getWindow(button, "../forms/ColorForm.fxml");
                        return;
                    }
                    new WindowApp().getWindow(button, "../forms/MenuForm.fxml");
                });
            }
        });

        openColor.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(Main.primary);
            if (file != null) {
                textFile.setText("Τΰιλ: " + file.getPath());
                textFile.setStyle("-fx-fill:  #8B008B;");
                fileName = file.getPath();
                button.setOnAction(event1 -> {
                    colorText = readTextToString();
                    new WindowApp().getWindow(button, "../forms/ColorForm.fxml");
                });
            }
        });
    }

    private void readText() {
        String delimiters = "[^A-Za-z]";
        try {
            FileReader file = new FileReader(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(delimiters);
                for (String word : words) {
                    if (word.equals("")) {
                        continue;
                    }
                    if (Vocabulary.getInstance().getVocabulary().containsKey(word.toLowerCase())) {
                        Vocabulary.getInstance().getVocabulary().put(word.toLowerCase(),
                                Vocabulary.getInstance().getVocabulary().get(word.toLowerCase()) + 1);
                    } else {
                        Vocabulary.getInstance().getVocabulary().put(word.toLowerCase(), 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readVoc() {
        try {
            FileReader file = new FileReader(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split("\t");
                if (words.length != 2) {
                    throw new InvalidDataException();
                }
                if (Vocabulary.getInstance().getVocabulary().containsKey(words[0])) {
                    Vocabulary.getInstance().getVocabulary().put(words[0],
                            Vocabulary.getInstance().getVocabulary().get(words[0]) + Integer.valueOf(words[1]));
                } else {
                    Vocabulary.getInstance().getVocabulary().put(words[0], Integer.valueOf(words[1]));
                }
            }
        } catch (FileNotFoundException | NumberFormatException | InvalidDataException e) {
            textFile.setStyle("-fx-fill: red;");
            textFile.setText("Invalid file!");
        }
    }

    private String readTextToString() {
        StringBuilder str = new StringBuilder();
        try {
            FileReader file = new FileReader(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str.append(scanner.nextLine());
                str.append('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    private void colorText(String str) {
        StanfordCoreNLP pipeline = new StanfordCoreNLP(PropertiesUtils.asProperties(
                "annotators", "tokenize,ssplit,pos,lemma,parse,natlog"));
        Annotation document = new Annotation(str);
        pipeline.annotate(document);
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        colorText = "";
        StringBuilder sb = new StringBuilder(colorText);
        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                ColorController.words.add(word);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                ColorController.tags.add(pos);
                sb.append(String.format("%s / %s ", word, pos));
            }
        }
        colorText = sb.toString();
    }
}
