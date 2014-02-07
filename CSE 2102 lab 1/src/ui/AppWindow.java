package ui;

/**
 * CSE 2012 Spring 2014
 * Java Swing UI
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Rectangle;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import calculator.Calculator;
import calculator.Grapher;

import java.util.*;

public class AppWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private Calculator _theCalc;

//	private String x;
	private Scanner input;
	private int value,num;
	private JTextField _textfield;
	private JTextArea txtAppOut;
	private JButton btnGraph;
	private JButton btnTwoPTwo;
	private JButton btnLoadFile;
	private JMenuItem mntmNewMenuItem;
	final JFileChooser fc = new JFileChooser();
	private boolean addi=false, subs=false, divi=false, multi=false, plusminus= false, sqrti= false;

	/**
	 * Create the frame.
	 */
	public AppWindow() {
		_theCalc = null;
		
		//Initialize all our Swing components! 
		//Text areas 
		txtAppOut = new JTextArea();
		//Buttons
		btnGraph = new JButton("Graph y = 3x + 2");
		btnTwoPTwo = new JButton("Compute file");
		btnLoadFile = new JButton("Open Computation File");
		//s_f= new JButton ("compute 6 - 5");
	//	runOperations( );
		//Menu items
		mntmNewMenuItem = new JMenuItem("Exit");	
	}
		
	public void run(){
		
		/**
		 * First off we specify what our window looks like (size in pixels). 
		 * Here is a 640x480 Window. Default behavior when we close this window
		 * is to close the entire program. Assign to it a Swing border layout
		 * for adding components
		 */
		setBounds(new Rectangle(50, 50, 440, 480));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		/**
		 * Our layout will contain a "top" and "bottom" section for components.
		 * JSplitPanes give us two different 'canvases' to put components on. 
		 */
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLastDividerLocation(10);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		//Stick the split pane in the center of our layout. Since we are
		//using now other regions, this will extend across the entire window.
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		/**
		 * The "top" section of our UI will have yet another split pane.
		 * But we split this horizontally, creating a "left" and "right" section
		 */
		JSplitPane paneTop = new JSplitPane();
		paneTop.setLastDividerLocation(40);
		paneTop.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		paneTop.setEnabled(false);
		//The left component will be the graph button.
		paneTop.setLeftComponent(btnGraph);
		
		//The right component will be yet another split pane.
		//Vertical split, and we will put two buttons on top of each other. 
		JSplitPane setBtnPane = new JSplitPane();
		setBtnPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		setBtnPane.setEnabled(false);
		setBtnPane.setTopComponent(btnLoadFile);
		setBtnPane.setBottomComponent(btnTwoPTwo);
		//setBtnPane.setBottomComponent(s_f);
		paneTop.setRightComponent(setBtnPane);
		
		//Finally, take paneTop and add it to the "top" section of our UI. 
		splitPane.setTopComponent(paneTop);		
		
		/**
		 * The "bottom" of section of our UI will be a tab view. 
		 * One tab will show the output of the calculator (think of it
		 * like a console window for the app), the other will be a simple
		 * calculator UI that you have to implement. 
		 */
		//Create a Tab Pane. Put the tabs on top of the pane. 
		JTabbedPane tabOuts = new JTabbedPane(JTabbedPane.BOTTOM);
		tabOuts.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		//Put the tab pane on the bottom of our UI. 
		splitPane.setBottomComponent(tabOuts);
		
		
		JScrollPane paneAppOut = new JScrollPane();
		paneAppOut.setPreferredSize(new Dimension(50, 50));
		//Adding the tab. 
		tabOuts.addTab("Output",paneAppOut);
		
		txtAppOut.setEditable(false);
		paneAppOut.setViewportView(txtAppOut);
		
		
//-==--==--==--==--==--==-==--------------------------------------------------------------------
		
		JScrollPane paneROut = new JScrollPane();
		paneROut.setPreferredSize(new Dimension(100, 240));
		tabOuts.addTab("Calculator",paneROut);
		//paneROut.setViewportView();
		
		 _textfield= new JTextField();
		 _textfield.setSize(10,20);
		 _textfield.setLocation(20,10);
		 _textfield.setFont(new Font("Times",Font.BOLD,52));
		 _textfield.setEditable(false);
		
		
		GridLayout grid = new GridLayout(4,3);
		GridLayout Fgrid = new GridLayout(4,1);

		
		JPanel p = new JPanel(new BorderLayout());
		JPanel g = new JPanel();
		g.setLayout(grid);
		
		paneROut.getViewport().add(p);
		
		JButton  seven= new JButton ("7");
		JButton  eight= new JButton ("8");
		JButton  nine= new JButton ("9");
		JButton  four= new JButton ("4");
		JButton  five= new JButton ("5");
		JButton  six= new JButton ("6");
		JButton  one= new JButton ("1");
		JButton  two= new JButton ("2");
		JButton  three= new JButton ("3");
		JButton  zero= new JButton ("0");
		JButton  add= new JButton ("+");
		JButton  sub= new JButton ("-");
		JButton  mult= new JButton ("*");
		JButton  div= new JButton ("/");
		JButton  clr= new JButton ("C/AC");
		JButton equals= new JButton("=");
		JButton sqrt= new JButton("sqrt");
		JButton  neg= new JButton ("(negative)-");
		
		JPanel func = new JPanel();
		func.setLayout(Fgrid);
		
		func.add(mult);
		func.add(div);
		func.add(add);
		func.add(sub);
		
		
		g.add(seven);
		g.add(eight);
		g.add(nine);
		g.add(four);
		g.add(five);
		g.add(six);
		g.add(one);
	    g.add(two);
		g.add(three);
		
		g.add(neg);
		g.add(zero);
		g.add(sqrt);

		p.add(g, BorderLayout.SOUTH);
		p.add(func, BorderLayout.WEST);
		p.add(equals, BorderLayout.EAST);
		p.add(_textfield);
		p.add(clr, BorderLayout.NORTH);
		
		 seven.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "7");}}); 
		 
		 eight.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "8");}}); 
		 
		 nine.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "9");}}); 
		 
		 four.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "4");}}); 
		 
		 five.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "5");}}); 
		 
		 six.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
			 	   { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "6");}}); 
		 
		 one.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
			 	     { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "1");}}); 
		 
		 two.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
			 	       { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "2");}});
		 
		 three.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 	            { //Execute when button is pressed
			 	_textfield.setText(_textfield.getText() + "3");}}); 
		 		 		 		 
		 zero.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(_textfield.getText() + "0");}}); 
	
		 clr.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
	            { //Execute when button is pressed
	_textfield.setText(null);
	divi=false;
	multi=false;
	subs=false;
	addi=false;
	sqrti= false;
	plusminus=false;
	num=0;
	value=0;
	            }}); 
		 	 
		 add.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
		{ //Execute when button is pressed
	if( _textfield.getText() != null || _textfield.getText() != "" ){
         value =  Integer.parseInt(String.valueOf(_textfield.getText()));
         _textfield.setText(null);
	}
	addi=true;
	plusminus=false;
	sqrti=false;
	divi=false;
	multi=false;
	subs=false;
	
         ;}}); 
		 
		 sub.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 		{ //Execute when button is pressed
			 	if( _textfield.getText() != null || _textfield.getText() != "" ){
			          value =  Integer.parseInt(String.valueOf(_textfield.getText()));
			          _textfield.setText(null);
			 	}
			 	subs=true;
			 	divi=false;
				multi=false;
				addi=false;
				plusminus=false;
				sqrti=false;
			 	
			          ;}}); 
		 
		 div.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 		{ //Execute when button is pressed
			 	if( _textfield.getText() != null || _textfield.getText() != "" ){
			          value =  Integer.parseInt(String.valueOf(_textfield.getText()));
			          _textfield.setText(null);
			 	}
			 	divi=true;
			 	multi=false;
				addi=false;
			 	subs=false;
			 	plusminus=false;
				sqrti=false;
			 	
			 	;}}); 
		 
		 mult.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 		{ //Execute when button is pressed
			 	if( _textfield.getText() != null || _textfield.getText() != "" ){
			          value =  Integer.parseInt(String.valueOf(_textfield.getText()));
			          _textfield.setText(null);
			 	}
			 	multi=true;
			 	subs=false;
			 	divi=false;
			 	plusminus=false;
			 	sqrti=false;
			 	addi=false;
			          ;}});
		 
		 sqrt.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 		{ 
			 	if( _textfield.getText() != null || _textfield.getText() != "" ){
			          value =  Integer.parseInt(String.valueOf(_textfield.getText()));
			          _textfield.setText(null);
			 	}
			 	sqrti=true;
			 	plusminus=false;
			 	multi=false;
			 	subs=false;
			 	divi=false;
			 	addi=false;
			          ;}});
		 
		 neg.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 		{ 
			 	if( _textfield.getText() != null || _textfield.getText() != "" ){
			          value =  Integer.parseInt(String.valueOf(_textfield.getText()));
			         _textfield.setText(null);}
			 	sqrti=false;
			 	plusminus=true;
			 	multi=false;
			 	subs=false;
			 	divi=false;
			 	addi=false;
			          ;}});
		 
		 equals.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e)
			 		{ 
				 if( _textfield.getText() != null && _textfield.getText() != "" ){
					 num = Integer.parseInt( _textfield.getText() );}
				 
				 if (addi==true){
					 int finalans = value + num;
					 _textfield.setText(finalans + "");}
				 if (subs==true){
					 int finalans = value-num;
					 _textfield.setText(finalans + "");}
				 if (divi==true){
					 int finalans = value/num;
					 _textfield.setText(finalans + "");}
				 if (multi==true){
					 int finalans = value*num;
					 _textfield.setText(finalans + "");}
				 if (plusminus==true){
					int finalans=value*-1; 
					 _textfield.setText(finalans+"");}
				 if (sqrti==true){
					 int finalans = (int)Math.sqrt(num);
					 _textfield.setText(finalans + "");}
			     ;}}); 
		
		 
		 /**
		 * JMenuBar: This is a bar for the menu items at the top of the application. 
		 */
		
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		//Add a Menu to the bar.
		JMenu mnuFile = new JMenu("File");
		menuBar.add(mnuFile);
		
		//Add an item to the menu. 
		mnuFile.add(mntmNewMenuItem);
		
		//Assign action listeners to UI components. 
		this.setActionListeners();
	
	}
	
	private void setActionListeners(){ 
		
		//Graph Button
		btnGraph.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e){
				JFrame f = new JFrame();
				//close the graph window, but not the app. 
		        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        f.add(new Grapher());
		        f.setSize(600,600);
		        f.setLocation(100,100);
		        f.setVisible(true);
			}
		});
		
		//"Exit" item on menu 
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
				
		
		btnLoadFile.addActionListener(new OpenCompFileActionListener(this));
		
	}
	
	/**
	 * UI Class Methods
	 */
	public void registerCalculator(Calculator c){
		_theCalc = c;
	}
	
	public void addOutput(String text){
		txtAppOut.setText(txtAppOut.getText() + text+ "\n");
	}
	
	public Calculator getCalculator(){
		return _theCalc;
	}
	
	public void runOperations(File f)throws RuntimeException,FileNotFoundException{
		
		//TODO. Display a message in the output console should
		//an exception occurs. 
		try {
			input = new Scanner(f);
			int num_eq= Integer.parseInt(input.next());
			for (int i =1; i<=num_eq; i++){
				int firstint=Integer.parseInt(input.next());
				String operation= input.next();
				
				int nextint=Integer.parseInt(input.next());
							if (operation.contains("+")){
								btnTwoPTwo.addActionListener(new CalculateActionListener(this, ""+firstint,""+"","" + nextint));
							}
							else if (operation.contains("-")){
								btnTwoPTwo.addActionListener(new CalculateActionListener(this, ""+firstint,"-","" + nextint));
							}
							else if (operation.contains("/")){
								btnTwoPTwo.addActionListener(new CalculateActionListener(this, ""+firstint,"/","" + nextint));
							}
							else if (operation.contains("*")){
								btnTwoPTwo.addActionListener(new CalculateActionListener(this, ""+firstint,"*","" + nextint));
							}}
		} catch (FileNotFoundException e) {
			//
			System.out.println("Cannot find file");
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e0) {
			//
			System.out.println(" Operand not found or invalid");
			System.out.println(e0.getMessage());
		}}
		
	
	
	/**
	 * Custom action listeners 
	 * These are private classes -- classes only visible to AppWindow.
	 */
	private  class CalculateActionListener implements ActionListener {
		private AppWindow _window;
		private String _op; 
		private String _x;
		private String _y;
		public CalculateActionListener(AppWindow w, String x, String y, String operation){
			_window = w;
			_op = operation;
			_x = x;
			_y = y;
			}
		public void actionPerformed(ActionEvent e){
			if(_op == "add"){ 
				_window.addOutput(
					Integer.toString(_window.getCalculator().addition(_x,_y)));}
	
				if(_op=="+"){
					_window.addOutput(Integer.toString(_window.getCalculator().addition(_x,_y)));
				}
				else if(_op=="-"){
					_window.addOutput(Integer.toString(_window.getCalculator().subtraction(_x,_y)));
				}
				else if (_op=="/"){
					_window.addOutput(Integer.toString(_window.getCalculator().division(_x,_y)));
				}
				else if (_op=="*"){
					_window.addOutput(Integer.toString(_window.getCalculator().multiplication(_x,_y)));
				}
		}}
	
	private  class OpenCompFileActionListener implements ActionListener {
		private AppWindow _window;
		public OpenCompFileActionListener(AppWindow w){
			_window = w;
		}
		public void actionPerformed(ActionEvent e) {
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        int returnVal = fc.showOpenDialog(AppWindow.this);
	        
	        
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            _window.addOutput("Running operations in: " + file.getName());
	            //Now run all the operations in the file.. 
	            try {
					_window.runOperations(file);
				} catch (FileNotFoundException e1) {
					System.out.println("File not Found");
				} catch (RuntimeException e1) {
					System.out.println("invalid input");	
					System.out.println(e1.getMessage());}
	        	 }}}}