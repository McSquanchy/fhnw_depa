package patterns.factory.gui;

public class FactoryFX implements Factory{

    @Override
    public Components.Frame newFrame(String title) {
        return new ComponentsFX.FrameFX(title);
    }

    @Override
    public Components.Field newField(int width, boolean enabled) {
        return new ComponentsFX.FieldFX(width, enabled);
    }

    @Override
    public Components.Button newButton(String label, Components.ActionListener listener) {
        return new ComponentsFX.ButtonFX(label, listener);
    }

    @Override
    public Components.Label newLabel(String text) {
        return new ComponentsFX.LabelFX(text);
    }
}
