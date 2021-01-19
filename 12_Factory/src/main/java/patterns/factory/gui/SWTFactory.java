package patterns.factory.gui;

public class SWTFactory implements Factory {

    @Override
    public Components.Frame newFrame(String title) {
        return new ComponentsSWT.FrameSWT(title);
    }

    @Override
    public Components.Field newField(int width, boolean enabled) {
        return new ComponentsSWT.FieldSWT(enabled);
    }

    @Override
    public Components.Button newButton(String label, Components.ActionListener listener) {
        return new ComponentsSWT.ButtonSWT(label, listener);
    }

    @Override
    public Components.Label newLabel(String text) {
        return new ComponentsSWT.LabelSWT(text);
    }
}
