package ch.fhnw.depa.mcsquanchy.colorpicker;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.converter.NumberStringConverter;

public class UI extends VBox {
    private final Model model;

    public UI(Model m) {
        this.model = m;
        MenuBar bar = new MenuBar();
        Menu menu = new Menu("File");
        MenuItem exit = new Menu("Exit");
        exit.setMnemonicParsing(true);
        exit.setOnAction(e -> Platform.exit());
        menu.getItems().add(exit);
        bar.getMenus().add(menu);

        getChildren().addAll(bar, getColorControls("R"), getColorControls("G"), getColorControls("B"), getColorControls("CANVAS"));
    }


    private HBox getColorControls(String s){
        HBox box = new HBox();
        box.setPadding(new Insets(10));
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);

        switch(s) {
            case "R":
                Label redLabel = new Label(s);
                TextField rgbRed = new TextField();
                TextField hexRgbRed = new TextField();
                hexRgbRed.textProperty().bindBidirectional(model.redHexStringProperty());
                rgbRed.textProperty().bindBidirectional(model.redProperty(), new NumberStringConverter());
                Slider redSlider = new Slider(0, 255,0);
                redSlider.valueProperty().bindBidirectional(model.redProperty());
                box.getChildren().addAll(redLabel, redSlider, rgbRed, hexRgbRed);
                break;
            case "G":
                Label greenLabel = new Label(s);
                TextField rgbGreen = new TextField();
                TextField hexRgbGreen = new TextField();
                hexRgbGreen.textProperty().bindBidirectional(model.greenHexStringProperty());
                rgbGreen.textProperty().bindBidirectional(model.greenProperty(), new NumberStringConverter());
                Slider greenSlider = new Slider(0, 255,0);
                greenSlider.valueProperty().bindBidirectional(model.greenProperty());
                box.getChildren().addAll(greenLabel, greenSlider, rgbGreen, hexRgbGreen);
                break;
            case "B":
                Label blueLabel = new Label(s);
                TextField rgbBlue = new TextField();
                TextField hexRgbBlue = new TextField();
                hexRgbBlue.textProperty().bindBidirectional(model.blueHexStringProperty());
                rgbBlue.textProperty().bindBidirectional(model.blueProperty(), new NumberStringConverter());
                Slider blueSlider = new Slider(0, 255,0);
                blueSlider.valueProperty().bindBidirectional(model.blueProperty());
                box.getChildren().addAll(blueLabel, blueSlider, rgbBlue, hexRgbBlue);
                break;
            case "CANVAS":
                Rectangle display = new Rectangle();
                VBox presets = new VBox();
                display.setStroke(Color.BLACK);
                presets.getChildren().addAll(new ColorRadioButton("Red", Color.rgb(255,0,0), model));
                presets.getChildren().addAll(new ColorRadioButton("Green", Color.rgb(0,255,0), model));
                presets.getChildren().addAll(new ColorRadioButton("Blue", Color.rgb(0,0,255), model));

//                display.widthProperty().bind();
                display.setWidth(160);
                display.setHeight(160);
                display.fillProperty().bind(model.colorProperty());
                box.getChildren().addAll(display, presets);
        }

        return box;

    }

    private GridPane getGridPane(Model m) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label redLabel = new Label("R");
        TextField rgbRed = new TextField();
        TextField hexRgbRed = new TextField();
        hexRgbRed.textProperty().bindBidirectional(m.redHexStringProperty());

        rgbRed.textProperty().bindBidirectional(m.redProperty(), new NumberStringConverter());
        Slider redSlider = new Slider(0, 255,0);
        redSlider.valueProperty().bindBidirectional(m.redProperty());

        Label greenLabel = new Label("G");
        TextField rgbGreen = new TextField();
        TextField hexRgbGreen = new TextField();
        hexRgbGreen.textProperty().bind(m.greenHexStringProperty());
        rgbGreen.textProperty().bindBidirectional(m.greenProperty(), new NumberStringConverter());
        Slider greenSlider = new Slider(0, 255,0);
        greenSlider.valueProperty().bindBidirectional(m.greenProperty());

        Label blueLabel = new Label("B");
        TextField rgbBlue = new TextField();
        TextField hexRgbBlue = new TextField();
        hexRgbBlue.textProperty().bindBidirectional(m.blueHexStringProperty());
        rgbBlue.textProperty().bindBidirectional(m.blueProperty(), new NumberStringConverter());

        Slider blueSlider = new Slider(0, 255,0);
        blueSlider.valueProperty().bindBidirectional(m.blueProperty());

        Rectangle display = new Rectangle();
        display.setStroke(Color.BLACK);
        display.widthProperty().bind(pane.widthProperty().divide(3));
        display.fillProperty().bind(m.colorProperty());

        pane.add(redLabel, 0,0,1,1);
        pane.add(redSlider, 1,0,1,1);
        pane.add(rgbRed,2,0,1,1);
        pane.add(hexRgbRed, 3,0,1,1);

        pane.add(greenLabel, 0,1,1,1);
        pane.add(greenSlider,1,1,1,1);
        pane.add(rgbGreen, 2,1,1,1);
        pane.add(hexRgbGreen, 3,1,1,1);

        pane.add(blueLabel,0,2,1,1);
        pane.add(blueSlider,1,2,1,1);
        pane.add(rgbBlue, 2,2,1,1);
        pane.add(hexRgbBlue, 3,2,1,1);

        VBox testbox = new VBox();
//        ColorRadioButton test = new ColorRadioButton("Green", Color.GREEN, m.colorProperty());
//        testbox.getChildren().add(test);
        pane.add(testbox, 3,4,3,4);

        GridPane.setValignment(display, VPos.CENTER);

        display.setHeight(160);
        pane.add(display, 0,4, 3,4);

        return pane;
    }
}
