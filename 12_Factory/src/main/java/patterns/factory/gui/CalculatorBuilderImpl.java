package patterns.factory.gui;

import patterns.factory.gui.Components.Frame;

public class CalculatorBuilderImpl implements CalculatorBuilder {
	Factory componentFactory;
	String appTitle;

	public void setComponentFactory(Factory fact) {
		if(fact != null)
			componentFactory = fact;
	}

	public Frame newCalculatorFrame() {
		Frame f = componentFactory.newFrame(appTitle == null ? "Calculator" : appTitle);
		final Components.Field x = componentFactory.newField(10, true);
		final Components.Field y = componentFactory.newField( 10, true);
		final Components.Field sum = componentFactory.newField( 10, false);
		Components.Button b = componentFactory.newButton("Compute",
				source -> {
					int ix = Integer.parseInt(x.getText());
					int iy = Integer.parseInt(y.getText());
					sum.setText("" + (ix + iy));
				}
		);
		f.setGrid(4, 2);
		f.add(componentFactory.newLabel("x"));
		f.add(x);
		f.add(componentFactory.newLabel("y"));
		f.add(y);
		f.add(componentFactory.newLabel("Summe"));
		f.add(sum);
		f.add(b);
		f.setVisible(true);
		return f;
	}

	public void setAppTitle(String title) {
		appTitle = title;
	}
}
