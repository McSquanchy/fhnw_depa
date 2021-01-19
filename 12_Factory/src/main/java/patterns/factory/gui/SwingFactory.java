package patterns.factory.gui;

public class SwingFactory implements Factory {
    @Override
    public Components.Frame newFrame(String title) {
        return new ComponentsSwing.FrameSwing(title);
    }

    @Override
    public Components.Field newField(int width, boolean enabled) {
        return new ComponentsSwing.FieldSwing(width, enabled);
    }

    @Override
    public Components.Button newButton(String label, Components.ActionListener listener) {
        return new ComponentsSwing.ButtonSwing(label, listener);
    }

    @Override
    public Components.Label newLabel(String text) {
        return new ComponentsSwing.LabelSwing(text);
    }
}
