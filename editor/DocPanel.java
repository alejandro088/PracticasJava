package editor;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class DocPanel extends JPanel {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	public DocPanel() {
		
		setLayout(new BorderLayout());
		
		ClickEvents click = new ClickEvents();
		
		JMenuBar menu = new JMenuBar();
		
		JMenu mnFile = new JMenu("Archivo");
		
		JMenu mnEdit = new JMenu("Edición");
		
		JMenu mnFont = new JMenu("Fuente");
		
		JMenu mnStyle = new JMenu("Estilo");
		
		JMenu mnSize = new JMenu("Tamaño");
		
		
		addMenuItem("Abrir...", mnFile);
				
		menu.add(mnFile);
		
		addMenuItem("Cortar", mnEdit);
		addMenuItem("Copiar", mnEdit);
		addMenuItem("Pegar", mnEdit);
		
		
		menu.add(mnEdit);

		String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for (String s: fonts) {
			addActionMenuFont(addMenuItem(s, mnFont));
		}
		
		
		//mnFont.setAutoscrolls(true);
		//MenuScroller.setScrollerFor(mnFont, 8, 125, 3, 1);
		
		
		//Clase MenuScroller thanks by https://tips4java.wordpress.com/2009/02/01/menu-scroller/
		MenuScroller.setScrollerFor(mnFont);
		
		menu.add(mnFont);
		
		addMenuItem("Negrita", mnStyle).addActionListener(new StyledEditorKit.BoldAction());
		addMenuItem("Cursiva", mnStyle).addActionListener(new StyledEditorKit.ItalicAction());
		addMenuItem("Subrayado", mnStyle).addActionListener(new StyledEditorKit.UnderlineAction());
		
		menu.add(mnStyle);
		
		
		for (int i=10; i<=80; i+=4) {
			addActionMenuSize(addMenuItem(""+ i, mnSize));
		}
		
		menu.add(mnSize);
		
		add(menu);
		
	}
	
	private JMenuItem addMenuItem(String title, JMenu m) {
		
		JMenuItem item = new JMenuItem(title);
		m.add(item);
		
		return item;
		
	}
	
	@SuppressWarnings("unused")
	private void addMenuItem(String title, JMenu m, Font f) {
		
		
		addMenuItem(title, m);
			
		
	}

	
	private void addActionMenuSize(JMenuItem item) {
		
		int iTitle =  Integer.parseInt(item.getText());
		
		item.addActionListener(new StyledEditorKit.FontSizeAction(item.getText(), iTitle));
	}
	
	private void addActionMenuFont(JMenuItem item) {
		
		item.addActionListener(new StyledEditorKit.FontFamilyAction(item.getText(), item.getText()));
	}
	
	
	
	private class ClickEvents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//System.out.println("Se ha hecho click en el boton Registrar");
			
		}
		
	}
	
}
