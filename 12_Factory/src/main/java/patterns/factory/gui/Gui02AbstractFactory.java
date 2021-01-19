package patterns.factory.gui;

public class Gui02AbstractFactory {


    public static void main(String[] args) {

        Factory factory = new AWTFactory();

        Components.Frame f = factory.newFrame("Calculator");
        final Components.Field x = factory.newField(10, true);
        final Components.Field y = factory.newField(10, true);
        final Components.Field sum = factory.newField(10, false);
        Components.Button b = factory.newButton("Compute",
                source -> {
                    int ix = Integer.parseInt(x.getText());
                    int iy = Integer.parseInt(y.getText());
                    sum.setText("" + (ix + iy));
                }
        );
        f.setGrid(4, 2);
        f.add(factory.newLabel("x"));
        f.add(x);
        f.add(factory.newLabel("y"));
        f.add(y);
        f.add(factory.newLabel( "Summe"));
        f.add(sum);
        f.add(b);
        f.setVisible(true);
    }
}
