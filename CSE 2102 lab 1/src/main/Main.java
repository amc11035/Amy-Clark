package main;

import ui.AppWindow;
import calculator.Calculator;

public class Main {
	public static void main(String[] args) { 
		System.out.println(System.getProperty("java.library.path"));
		
		//Start up the UI
		AppWindow appUI = new AppWindow();
		appUI.setVisible(true);
		
		//Fire up our calculator class
		Calculator c = new Calculator();
		//Register the back-end calculator with our front-end UI
		appUI.registerCalculator(c);
		appUI.run();
	}
}
