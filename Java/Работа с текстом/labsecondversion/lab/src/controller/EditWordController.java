package controller;

import entity.Vocabulary;
import entity.Word;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditWordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField oldWordTF;

    @FXML
    private TextField newWordTF;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button searchButton;

    @FXML
    private TextField tagsTF1;

    @FXML
    private TextField canonicTF11;

    @FXML
    private TextField canTagsTF11;

    @FXML
    void initialize() {
        Word temp = new Word("", 0, "", "", "");
        searchButton.setOnAction(event -> {
            Word word = null;
            String oldWord = oldWordTF.getText();
            if (oldWord == null  || oldWord.equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid word");
                alert.setHeaderText("You must write the word you want to replace!");
            } else {
                for (int i = 0; i < ShowController.data.size(); i++) {
                    if (ShowController.data.get(i).getWord().equals(oldWord)){
                        word = ShowController.data.get(i);
                        break;
                    }
                }
                tagsTF1.setText(word.getTags());
                canonicTF11.setText(word.getForms());
                canTagsTF11.setText(word.getCanonicalTags());

                temp.setTags(word.getTags());
                temp.setForms(word.getForms());
                temp.setCanonicalTags(word.getCanonicalTags());
            }
        });

        okButton.setOnAction(event -> {
            String oldWord = oldWordTF.getText();
            String newWord = newWordTF.getText();

            if (oldWord == null || newWord == null || oldWord.equals("") || newWord.equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid word");
                alert.setHeaderText("You must write the word you want to replace!");
            } else {
                Word word = null;
                Integer value2 = (Integer) Vocabulary.getInstance().getVocabulary().get(oldWord);
                Integer value1 = 0;
                if(Vocabulary.getInstance().getVocabulary().containsKey(newWord))
                {
                    value1 = (Integer) Vocabulary.getInstance().getVocabulary().get(newWord);
                    value2 += value1;
                    Vocabulary.getInstance().getVocabulary().put(newWord, value2);

                    for (int i = 0; i < ShowController.data.size(); i++) {
                        if (ShowController.data.get(i).getWord().equals(newWord)){
                            word = ShowController.data.get(i);
                            break;
                        }
                    }
                    tagsTF1.setText(word.getTags());
                    canonicTF11.setText(word.getForms());
                    canTagsTF11.setText(word.getCanonicalTags());

                    ShowController.data.remove(new Word(newWord, value1, tagsTF1.getText(), canonicTF11.getText(), canTagsTF11.getText()));
                }
                else
                {
                    Vocabulary.getInstance().getVocabulary().put(newWord, value2);
                }
                Vocabulary.getInstance().getVocabulary().remove(oldWord);


                ShowController.data.remove(new Word(oldWord, value2 - value1, temp.getTags(), temp.getForms(), temp.getCanonicalTags()));
                ShowController.data.add(new Word(newWord, value2, tagsTF1.getText(), canonicTF11.getText(), canTagsTF11.getText()));
                /*for (int i = 0; i < StartFormController.file.size(); i++) {
                    new Command().replaceWord(StartFormController.file.get(i).getPath(), oldWord, newWord);
                }*/
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
        });
        cancelButton.setOnAction(event -> {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        });
    }
}
