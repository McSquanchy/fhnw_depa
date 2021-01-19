package patterns.factory.gui;

public interface Factory {
    Components.Frame newFrame(String title);

    Components.Field newField(int width, boolean enabled);

    Components.Button newButton(String label, Components.ActionListener listener);

    Components.Label newLabel(String text);

}
