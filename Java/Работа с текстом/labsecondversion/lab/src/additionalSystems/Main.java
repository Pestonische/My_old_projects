package additionalSystems;

/*import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.PropertiesUtils;
import javafx.stage.Stage;

import java.util.List;

public class Main {
    public static Stage primary;
    public static void main(String[] args) {
        StanfordCoreNLP pipeline = new StanfordCoreNLP(
                PropertiesUtils.asProperties(
                        "annotators", "tokenize,ssplit,pos,lemma,parse,natlog"
                ));

// create an empty Annotation just with the given text
        String str="Hello, world!";
        Annotation document = new Annotation(str);

// run all Annotators on this text
        pipeline.annotate(document);


        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
// this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                System.out.println(String.format("%s/%s ", word, pos));
            }
        }
    }
}*/


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primary;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../forms/MenuForm.fxml"));
        primaryStage.setTitle("Vocabulary");
        primaryStage.setScene(new Scene(root, 1100, 850));
        primaryStage.show();
        primary = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
