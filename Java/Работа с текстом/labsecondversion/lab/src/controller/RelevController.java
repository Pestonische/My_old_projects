package controller;

import entity.TextVoc;
import entity.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.util.Sequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RelevController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<TextVoc> table;

    @FXML
    private TableColumn<TextVoc, String> textNameColumn;

    @FXML
    private TableColumn<TextVoc, Double> relevanceColumn;

    @FXML
    private TextArea textArea;

    @FXML
    private Button button;

    @FXML
    void initialize() {
    button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
//            "They hsdave very big eyes thsdat let in lots of light."
            Sequence[] topSequences = null;
            String[] massWord = textArea.getText().split("[^A-Za-z]");
            try (FileInputStream modelIn = new FileInputStream("en-pos-maxent.bin")) {
                POSModel model = new POSModel(modelIn);
                POSTaggerME tagger = new POSTaggerME(model);
                topSequences = tagger.topKSequences(massWord);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] resultTags = new String[massWord.length];
            assert topSequences != null;
            for (int i = 0; i < resultTags.length; i++) {
                resultTags[i] = "";
                for (Sequence topSequence : topSequences) {
                    if (!resultTags[i].contains(topSequence.getOutcomes().get(i) + " ")) {
                        resultTags[i] += topSequence.getOutcomes().get(i) + " ";
                    }
                }
            }

            LemmatizerModel model = null;
            String[] lemmas = null;
            try (
                    InputStream modelIn = new FileInputStream("en-lemmatizer.bin")) {
                model = new LemmatizerModel(modelIn);
                LemmatizerME lemmatizer = new LemmatizerME(model);
                lemmas = lemmatizer.lemmatize(massWord, topSequences[0].getOutcomes().toArray(new String[0]));
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }

            Sequence topCan[] = null;
            try (FileInputStream modelInCan = new FileInputStream("en-pos-maxent.bin")) {
                POSModel modelCan = new POSModel(modelInCan);
                POSTaggerME taggerCan = new POSTaggerME(modelCan);
                topCan = taggerCan.topKSequences(lemmas);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] resultTagsCan = new String[lemmas.length];
            assert topCan != null;
            for (int i = 0; i < resultTagsCan.length; i++) {
                resultTagsCan[i] = "";
                for (Sequence topCa : topCan) {
                    if (!resultTagsCan[i].contains(topCa.getOutcomes().get(i) + " ")) {
                        resultTagsCan[i] += topCa.getOutcomes().get(i) + " ";
                    }
                }
            }

            ArrayList<Word> tempWords = new ArrayList<>();
            for (
                    int i = 0; i < massWord.length; i++) {
                tempWords.add(new Word(massWord[i], 1, resultTags[i], lemmas[i], resultTagsCan[i]));
            }

            ArrayList<Word> informWords = new ArrayList<>();
            for (int i = 0; i < tempWords.size(); i++){
                if (tempWords.get(i).getTags().contains("JJ") ||
                        tempWords.get(i).getTags().contains("JJR") ||
                        tempWords.get(i).getTags().contains("JJS") ||
                        tempWords.get(i).getTags().contains("NN") ||
                        tempWords.get(i).getTags().contains("NNS") ||
                        tempWords.get(i).getTags().contains("RB") ||
                        tempWords.get(i).getTags().contains("RBR") ||
                        tempWords.get(i).getTags().contains("RBS") ||
                        tempWords.get(i).getTags().contains("VB") ||
                        tempWords.get(i).getTags().contains("VBD") ||
                        tempWords.get(i).getTags().contains("VBG") ||
                        tempWords.get(i).getTags().contains("VBN") ||
                        tempWords.get(i).getTags().contains("VBP") ||
                        tempWords.get(i).getTags().contains("VBZ")){
                    informWords.add(tempWords.get(i));
                }
            }
            for (int i = 0; i < TextController.texts.size(); i++){
                TextController.texts.get(i).findFreqForText(informWords);
                TextController.texts.get(i).findWeight();
                TextController.texts.get(i).findRelev();
                //System.out.println(texts.get(i).getRelev());
            }

            ObservableList<TextVoc> obs = FXCollections.observableArrayList();
            obs.addAll(TextController.texts);
            table.setItems(obs);
            textNameColumn.setCellValueFactory(new PropertyValueFactory<TextVoc, String>("nameText"));
            relevanceColumn.setCellValueFactory(new PropertyValueFactory<TextVoc, Double>("relev"));
        }
    });

    }
}
