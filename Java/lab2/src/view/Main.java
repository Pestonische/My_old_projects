package view;

//import controller.AccountLoader;
import javafx.application.Application;
import model.Bank;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Starting class
 *
 * @version 1.0 Sep 2021
 * @author  Kozunov Alexei
 */




public class Main extends Application {
    public static Stage primary;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../forms/main.fxml"));
        primaryStage.setTitle("Bank");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
        primary = primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
        /*Bank bank;
        bank = AccountLoader.initializationAccounts();
        BankOperations.menu(bank);*/
    }
}
