package ch.fhnw.depa.mcsquanchy.colorpicker;

import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;

public class ColorRadioButton extends RadioButton implements ColorChanged{
    private final Model m;
    private final Color color;

    public ColorRadioButton(String text, Color c, Model model) {
        this.setText(text);
        this.m = model;
        this.color = c;
        this.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if (t1) {
                m.redProperty().set((int)(color.getRed()*255));
                m.greenProperty().set((int)(color.getGreen()*255));
                m.blueProperty().set((int)(color.getBlue()*255));
            }
        });
    }

    @Override
    public void update() {
        this.setSelected(false);
    }



}
