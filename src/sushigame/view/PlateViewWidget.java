package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import comp401sushi.IngredientPortion;
import comp401sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class PlateViewWidget extends JPanel implements BeltObserver, ActionListener {
	
	private Belt belt;
	private JPanel button_panel;
	private JTextArea info;
	private JButton[] buttons;
	
	public PlateViewWidget (Belt belt) {
		
		setLayout(new BorderLayout());
		
		this.belt = belt;
		belt.registerBeltObserver(this);
		
		info = new JTextArea();
		info.setMinimumSize(new Dimension(300,20 * belt.getSize()));
		info.setPreferredSize(new Dimension(300,20 * belt.getSize()));
		info.setEditable(false);
		add(new JScrollPane(info), BorderLayout.EAST);
		
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(belt.getSize(), 1));
		
		buttons = new JButton[belt.getSize()];
		
		for (int i = 0; i < belt.getSize(); i++) {
			
			JButton pbutton = new JButton("");
			pbutton.setMinimumSize(new Dimension(300, 20));
			pbutton.setPreferredSize(new Dimension(300, 20));
			pbutton.setOpaque(true);
			pbutton.setBackground(Color.GRAY);
			button_panel.add(pbutton);
			buttons[i] = pbutton;
			
		}
		
		add(button_panel, BorderLayout.WEST);
		
		for(Component c: button_panel.getComponents()) {
			JButton b = (JButton) c;
			b.addActionListener(this);
		}
		
		refresh();
	}
	
	public void refresh() {
		
		for (int i = 0; i < belt.getSize(); i++) {
			
			Plate p = belt.getPlateAtPosition(i);
			JButton pbutton = buttons[i];

			if (p == null) {
				
				pbutton.setText("");
				pbutton.setBackground(Color.GRAY);
				
			} else {
				
				pbutton.setText(p.toString());
				
				switch (p.getColor()) {
				case RED:
					pbutton.setBackground(Color.RED); break;
				case GREEN:
					pbutton.setBackground(Color.GREEN); break;
				case BLUE:
					pbutton.setBackground(Color.BLUE); break;
				case GOLD:
					pbutton.setBackground(Color.YELLOW); break;
					
				}
			}
		}
		
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		info.setText("");
		
		JButton button = (JButton) e.getSource();
		String splate = button.getText();
		Plate p = null;
		int z = 0;
		
		if (splate.equals("")) {
			return;
		} else {
			
			for (int i = 0; i < buttons.length; i++) {
				
				if (splate.equals(buttons[i].getText())) {
					p = belt.getPlateAtPosition(i);
					z = i;
				}
			}
			
			String color = null;
		
			if (p.getColor() == Plate.Color.GREEN) {
				color = "Green";
			} else if (p.getColor() == Plate.Color.RED) {
				color = "Red";
			} else if (p.getColor() == Plate.Color.BLUE) {
				color = "Blue";
			} else if (p.getColor() == Plate.Color.GOLD) {
				color = "Gold";
			}
			
			info.append("Color: " + color);
			info.append("\n");
			
			String name = p.getContents().getName();
			char last = name.charAt(name.length() - 2);
			String type = null;
			String kind = null;
			
			if (last == 'r') {
				type = "Nigiri";	
			} else if (last == 'm') {
				type = "Sashimi";
			} else {
				type = "Roll";
			}
			
			info.append("Type: " + type);
			info.append("\n");
			
			if (type == "Nigiri" || type == "Sashimi") {
				info.append("Kind: " + p.getContents().getName());
				info.append("\n");
			} else {
				info.append("Kind: " + p.getContents().getName());
				info.append("\n");
				info.append("Ingredients: ");
				info.append("\n");
				String ingredient = null;
				IngredientPortion[] list = p.getContents().getIngredients();
				for (int i = 0; i < list.length; i++) {
					String amount = String.format ("%.2f", list[i].getAmount());
					ingredient = list[i].getName() + ": " + amount + ";";
					info.append(ingredient);
					info.append("\n");
				}
			}
			
			info.append("Chef: " + p.getChef().getName());
			info.append("\n");
			info.append("Age: " + belt.getAgeOfPlateAtPosition(z));
			info.append("\n");
		}
		
	}

}
