package controller;

import additionalSystems.Main;
import additionalSystems.WindowApp;
import entity.Stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ColorController {

    public static ArrayList<String> tags = new ArrayList<>();
    public static ArrayList<String> words = new ArrayList<>();
    public static ObservableList<Stats> obs;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private Button save;

    @FXML
    private Button meaning;

    @FXML
    private Button freqEveryCode;

    @FXML
    private Button freqWordCode;

    @FXML
    private Button pairCode;

    @FXML
    private TextArea text;

    @FXML
    void initialize() {
        back.setOnAction(event -> new WindowApp().getWindow(back, "../forms/MenuForm.fxml"));

        text.setWrapText(true);
        text.setText(TextController.colorText);
        save.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            try {
                File temp = fileChooser.showSaveDialog(Main.primary);
                if (temp != null) {
                    FileWriter file = new FileWriter(temp);
                    file.write(text.getText());
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        freqEveryCode.setOnAction(event -> {
            obs = FXCollections.observableArrayList();
            ArrayList<String> tempTags = new ArrayList<>(tags);
            while (!tempTags.isEmpty()){
                String teg = tempTags.get(0);
                int count = 0;
                for (int i = 0; i < tempTags.size(); i++){
                    if (teg.equals(tempTags.get(i))){
                        count++;
                        tempTags.remove(i);
                    }
                }
                obs.add(new Stats(teg, count));
            }
            newScene("/forms/StatsForm.fxml", "Stats");
        });

        freqWordCode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                obs = FXCollections.observableArrayList();
                ArrayList<String> tempTags = new ArrayList<>();
                for (int i = 0; i < tags.size(); i++){
                    tempTags.add(String.format("%s_%s", words.get(i), tags.get(i)));
                }
                while (!tempTags.isEmpty()){
                    String teg = tempTags.get(0);
                    int count = 0;
                    for (int i = 0; i < tempTags.size(); i++){
                        if (teg.equals(tempTags.get(i))){
                            count++;
                            tempTags.remove(i);
                        }
                    }
                    obs.add(new Stats(teg, count));
                }
                newScene("/forms/StatsForm.fxml", "Stats");
            }
        });

        pairCode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                obs = FXCollections.observableArrayList();
                HashMap<String, Integer> tempTags = new HashMap<>();
                for (int i = 0; i < tags.size() - 1; i++){
                    String pairTags = String.format("%s_%s", tags.get(i), tags.get(i+1));
                    if (tempTags.containsKey(pairTags)){
                        tempTags.replace(pairTags, tempTags.get(pairTags), tempTags.get(pairTags) + 1);
                    } else {
                        tempTags.put(pairTags, 1);
                    }
                }
                for (Map.Entry<String, Integer> entry : tempTags.entrySet()){
                    obs.add(new Stats(entry.getKey(),entry.getValue()));
                }
                newScene("/forms/StatsForm.fxml", "Stats");
            }
        });
        meaning.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About tags");
            alert.setHeaderText("Meaning of tags");
            String tagsInfo = "1.\tCC\tCoordinating conjunction\n" +
                    "2.\tCD\tCardinal number\n" +
                    "3.\tDT\tDeterminer\n" +
                    "4.\tEX\tExistential there\n" +
                    "5.\tFW\tForeign word\n" +
                    "6.\tIN\tPreposition or subordinating conjunction\n" +
                    "7.\tJJ\tAdjective\n" +
                    "8.\tJJR\tAdjective, comparative\n" +
                    "9.\tJJS\tAdjective, superlative\n" +
                    "10.\tLS\tList item marker\n" +
                    "11.\tMD\tModal\n" +
                    "12.\tNN\tNoun, singular or mass\n" +
                    "13.\tNNS\tNoun, plural\n" +
                    "14.\tNNP\tProper noun, singular\n" +
                    "15.\tNNPS\tProper noun, plural\n" +
                    "16.\tPDT\tPredeterminer\n" +
                    "17.\tPOS\tPossessive ending\n" +
                    "18.\tPRP\tPersonal pronoun\n" +
                    "19.\tPRP$\tPossessive pronoun\n" +
                    "20.\tRB\tAdverb\n" +
                    "21.\tRBR\tAdverb, comparative\n" +
                    "22.\tRBS\tAdverb, superlative\n" +
                    "23.\tRP\tParticle\n" +
                    "24.\tSYM\tSymbol\n" +
                    "25.\tTO\tto\n" +
                    "26.\tUH\tInterjection\n" +
                    "27.\tVB\tVerb, base form\n" +
                    "28.\tVBD\tVerb, past tense\n" +
                    "29.\tVBG\tVerb, gerund or present participle\n" +
                    "30.\tVBN\tVerb, past participle\n" +
                    "31.\tVBP\tVerb, non-3rd person singular present\n" +
                    "32.\tVBZ\tVerb, 3rd person singular present\n" +
                    "33.\tWDT\tWh-determiner\n" +
                    "34.\tWP\tWh-pronoun\n" +
                    "35.\tWP$\tPossessive wh-pronoun\n" +
                    "36.\tWRB\tWh-adverb";
            alert.setContentText(tagsInfo);
            alert.showAndWait();
        });
    }
    private void newScene(String urlToForm, String nameTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(urlToForm));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(nameTitle);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.primary);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

