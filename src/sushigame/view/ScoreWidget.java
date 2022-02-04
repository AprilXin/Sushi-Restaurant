package sushigame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreWidget extends JPanel implements BeltObserver, ActionListener {
	
	private SushiGameModel game_model;
	private JPanel button_panel;
	private JTextArea info;
	private JButton[] buttons;
	private String lastCommand = null;
	
	public ScoreWidget(SushiGameModel gm) {
		
		setLayout(new BorderLayout());
		
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		
		info = new JTextArea();
		info.setMinimumSize(new Dimension(300,300));
		info.setPreferredSize(new Dimension(300,300));
		info.setEditable(false);
		add(new JScrollPane(info), BorderLayout.SOUTH);
		
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(1, 3));
		
		JButton first = new JButton("balance");
		JButton second = new JButton("food sold");
		JButton third = new JButton("food spoiled");
		
		buttons = new JButton[] {first, second, third};
		
		for (int i = 0; i < 3; i++) {
			
//			buttons[i].setMinimumSize(new Dimension(50, 20));
//			buttons[i].setPreferredSize(new Dimension(50, 20));
			buttons[i].addActionListener(this);
			button_panel.add(buttons[i]);
			
		}
		
		add(button_panel, BorderLayout.CENTER);
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		
		JButton button = (JButton) e.getSource();
		String command = button.getText();
		
		if (command == "balance") {
			info.setText("");
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ")");
				info.append("\n");
			}
			lastCommand = "balance";
		} else if (command == "food sold") {
			info.setText("");
			Arrays.sort(chefs, new HighToLowSoldComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + "(" + (Math.round(c.getConsumed()*100.0)/100.0) + " ounces)");
				info.append("\n");
			}
			lastCommand = "food sold";
		} else if (command == "food spoiled") {
			info.setText("");
			Arrays.sort(chefs, new LowToHighSpoiledComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + "(" + (Math.round(c.getSpoiled()*100.0)/100.0) + " ounces)");
				info.append("\n");
			}
			lastCommand = "food spoiled";
		}		
	}
	
	public void refresh() {
		Chef[] opponent_chefs= game_model.getOpponentChefs();
		Chef[] chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		
		if (lastCommand == null) {
			info.setText("");
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ")");
				info.append("\n");
			}
		} else if (lastCommand == "balance") {
			info.setText("");
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + " ($" + Math.round(c.getBalance()*100.0)/100.0 + ")");
				info.append("\n");
			}
		} else if (lastCommand == "food sold") {
			info.setText("");
			Arrays.sort(chefs, new HighToLowSoldComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + "(" + (Math.round(c.getConsumed()*100.0)/100.0) + " ounces)");
				info.append("\n");
			}
		} else if (lastCommand == "food spoiled") {
			info.setText("");
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			for (Chef c : chefs) {
				info.append(c.getName() + "(" + (Math.round(c.getSpoiled()*100.0)/100.0) + " ounces)");
				info.append("\n");
			}
		} 
	}

}
