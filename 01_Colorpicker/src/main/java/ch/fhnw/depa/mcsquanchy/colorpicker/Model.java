package ch.fhnw.depa.mcsquanchy.colorpicker;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import java.text.DecimalFormat;

public class Model {

    private final SimpleIntegerProperty red = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty green = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty blue = new SimpleIntegerProperty(0);

    private final ObjectProperty<Color> color = new SimpleObjectProperty<>(Color.BLACK);

    DecimalFormat df = new DecimalFormat();

    private final SimpleStringProperty redHexString;
    private final SimpleStringProperty greenHexString;
    private final SimpleStringProperty blueHexString;

    public Model() {
        df.setMaximumFractionDigits(3);
        redHexString = new SimpleStringProperty(Integer.toString(red.getValue(), 16).toUpperCase());
        greenHexString = new SimpleStringProperty(Integer.toString(green.getValue(), 16).toUpperCase());
        blueHexString = new SimpleStringProperty(Integer.toString(blue.getValue(), 16).toUpperCase());

        red.addListener((observable, oldValue, newValue) -> {
            int val = Math.max(0, Math.min(255, newValue.intValue()));
            color.set(Color.rgb(val, green.get(), blue.get()));
            updateHex();
        });
        green.addListener((observable, oldValue, newValue) -> {
            int val = Math.max(0, Math.min(255, newValue.intValue()));
            color.set(Color.rgb(red.get(), val, blue.get()));
            updateHex();
        });
        blue.addListener((observable, oldValue, newValue) -> {
            int val = Math.max(0, Math.min(255, newValue.intValue()));
            color.set(Color.rgb(red.get(), green.get(), val));
            updateHex();
        });
    }

    public void updateHex() {
        redHexString.setValue(Integer.toString(red.getValue(), 16).toUpperCase());
        greenHexString.setValue(Integer.toString(green.getValue(), 16).toUpperCase());
        blueHexString.setValue(Integer.toString(blue.getValue(), 16).toUpperCase());
    }

    public SimpleIntegerProperty redProperty() {
        return red;
    }

    public SimpleIntegerProperty greenProperty() {
        return green;
    }

    public SimpleIntegerProperty blueProperty() {
        return blue;
    }

    public SimpleStringProperty redHexStringProperty() {
        return redHexString;
    }

    public SimpleStringProperty greenHexStringProperty() {
        return greenHexString;
    }

    public SimpleStringProperty blueHexStringProperty() {
        return blueHexString;
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }
}
