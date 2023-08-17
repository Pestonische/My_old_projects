package controller;

import entity.Stats;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StatsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Stats> table;

    @FXML
    private TableColumn<Stats, String> tagTableColumn;

    @FXML
    private TableColumn<Stats, Integer> frequencyTableColumn;

    @FXML
    void initialize() {
        table.setItems(ColorController.obs);
        tagTableColumn.setCellValueFactory(new PropertyValueFactory<Stats, String>("tag"));
        frequencyTableColumn.setCellValueFactory(new PropertyValueFactory<Stats, Integer>("freq"));
    }
}
