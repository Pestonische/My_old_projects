package com.example.lab3_fx;

import com.example.lab3_fx.binarizing.AdaptiveThresholdBinarizer;
import com.example.lab3_fx.binarizing.GradientThresholdBinarizer;
import com.example.lab3_fx.binarizing.HistogramThresholdBinarizer;
import com.example.lab3_fx.binarizing.Segmentation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessorController {
    private BufferedImage bufImage;
    @FXML
    private ImageView srcImg;

    @FXML
    private ImageView processedImg;

    @FXML
    private ComboBox<String> cbAction;

    @FXML
    public void onChooseFileButtonClick(ActionEvent actionEvent) throws IOException {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(((Button) actionEvent.getSource()).getScene().getWindow());
        if (file != null) {
            bufImage = ImageIO.read(file);
            var image = new Image(file.toURI().toString());
            setAndFitImage(srcImg, image);
            processedImg.setImage(null);
            cbAction.setValue("");
        }
    }

    private void setAndFitImage(ImageView srcImg, Image image) {
        srcImg.setImage(image);
        srcImg.setFitHeight(600);
        srcImg.setFitWidth(600);
        srcImg.setPreserveRatio(true);
    }

    public void onActionChanged(ActionEvent actionEvent) {
        var cb = (ComboBox<String>) actionEvent.getSource();
        switch (cb.getValue()) {
            case "Histogram Global Threshold" -> doHistogramGlobal();
            case "Gradient Global Threshold" -> doGradientGlobal();
            case "Adaptive Threshold" -> doAdaptive();
            case "Segmentation" -> doSegmentation();
        }
    }

    private void doHistogramGlobal() {
        var processed = new HistogramThresholdBinarizer(0.01).binarize(bufImage);
        setAndFitImage(processedImg, convertToImageFX(processed));
    }

    private void doGradientGlobal() {
        var processed = new GradientThresholdBinarizer().binarize(bufImage);
        setAndFitImage(processedImg, convertToImageFX(processed));
    }

    private void doAdaptive() {
        var processed  = new AdaptiveThresholdBinarizer(5).binarize(bufImage);
        setAndFitImage(processedImg, convertToImageFX(processed));
    }

    private void doSegmentation() {
        var processed  = new Segmentation().binarize(bufImage);
        setAndFitImage(processedImg, convertToImageFX(processed));
    }


    private Image convertToImageFX(BufferedImage bf) {
        WritableImage wr = null;
        if (bf != null) {
            wr = new WritableImage(bf.getWidth(), bf.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < bf.getWidth(); x++) {
                for (int y = 0; y < bf.getHeight(); y++) {
                    pw.setArgb(x, y, bf.getRGB(x, y));
                }
            }
        }
        return wr;
    }
}