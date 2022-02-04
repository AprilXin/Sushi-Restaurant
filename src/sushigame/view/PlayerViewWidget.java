package sushigame.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import comp401sushi.AvocadoPortion;
import comp401sushi.CrabPortion;
import comp401sushi.EelPortion;
import comp401sushi.IngredientPortion;
import comp401sushi.Nigiri;
import comp401sushi.RicePortion;
import comp401sushi.Roll;
import comp401sushi.Sashimi;
import comp401sushi.SeaweedPortion;
import comp401sushi.ShrimpPortion;
import comp401sushi.Sushi;
import comp401sushi.TunaPortion;
import comp401sushi.YellowtailPortion;
import sushigame.model.Belt;

public class PlayerViewWidget extends JPanel implements ActionListener {
	
	private List<ChefViewListener> listeners;
	private Sushi roll;
	private Sushi sashimi;
	private Sushi nigiri;
	private Belt belt;
	
	public PlayerViewWidget(Belt belt) {
		
		this.belt = belt;
		listeners = new ArrayList<ChefViewListener>();
		
		setLayout(new BorderLayout());
		
		JButton button = new JButton("Add");
		button.addActionListener(this);
		add(button, BorderLayout.CENTER);
		
	}
	
	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}
	
	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object[] plates = {"Red", "Green", "Blue", "Gold"};
		String color = (String) JOptionPane.showInputDialog(
				null,"The color of the plate:", "Color", 
				JOptionPane.PLAIN_MESSAGE, null, plates, "Red"); 
		
		int position = Integer.parseInt(JOptionPane.showInputDialog("The position of the plate"));
		position = ((position % this.belt.getSize()) + this.belt.getSize()) % this.belt.getSize();
		
		Object[] sushi = {"Nigiri", "Sashimi", "Roll"};
		String type = (String) JOptionPane.showInputDialog(
				null,"Which type of sushi?", "Type", 
				JOptionPane.PLAIN_MESSAGE, null, sushi, "Nigiri"); 
		
		if (!type.equals("Roll")) {
			
			Object[] fish = {"Tuna", "Yellowtail", "Eel", "Crab", "Shrimp"};
			String kind = (String) JOptionPane.showInputDialog(
					null,"Which kind of seafood?", "Kind", 
					JOptionPane.PLAIN_MESSAGE, null, fish, "Tuna"); 
			
			if (color.equals("Red")) {
				if (type.equals("Nigiri")) {
					if (kind.equals("Tuna")) {
						nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
						makeRedPlateRequest(nigiri, position);
					} else if (kind.equals("Yellowtail")) {
						nigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
						makeRedPlateRequest(nigiri, position);
					} else if (kind.equals("Eel")) {
						nigiri = new Nigiri(Nigiri.NigiriType.EEL);
						makeRedPlateRequest(nigiri, position);
					} else if (kind.equals("Crab")) {
						nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
						makeRedPlateRequest(nigiri, position);
					} else if (kind.equals("Shrimp")) {
						nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeRedPlateRequest(nigiri, position);
					}
				} else {
					if (kind.equals("Tuna")) {
						sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
						makeRedPlateRequest(sashimi, position);
					} else if (kind.equals("Yellowtail")) {
						sashimi = new Sashimi(Sashimi.SashimiType.YELLOWTAIL);
						makeRedPlateRequest(sashimi, position);
					} else if (kind.equals("Eel")) {
						sashimi = new Sashimi(Sashimi.SashimiType.EEL);
						makeRedPlateRequest(sashimi, position);
					} else if (kind.equals("Crab")) {
						sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
						makeRedPlateRequest(sashimi, position);
					} else if (kind.equals("Shrimp")) {
						sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeRedPlateRequest(sashimi, position);
					}
				}
			} else if (color.equals("Green")) {
				if (type.equals("Nigiri")) {
					if (kind.equals("Tuna")) {
						nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
						makeGreenPlateRequest(nigiri, position);
					} else if (kind.equals("Yellowtail")) {
						nigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
						makeGreenPlateRequest(nigiri, position);
					} else if (kind.equals("Eel")) {
						nigiri = new Nigiri(Nigiri.NigiriType.EEL);
						makeGreenPlateRequest(nigiri, position);
					} else if (kind.equals("Crab")) {
						nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
						makeGreenPlateRequest(nigiri, position);
					} else if (kind.equals("Shrimp")) {
						nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeGreenPlateRequest(nigiri, position);
					}
				} else {
					if (kind.equals("Tuna")) {
						sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
						makeGreenPlateRequest(sashimi, position);
					} else if (kind.equals("Yellowtail")) {
						sashimi = new Sashimi(Sashimi.SashimiType.YELLOWTAIL);
						makeGreenPlateRequest(sashimi, position);
					} else if (kind.equals("Eel")) {
						sashimi = new Sashimi(Sashimi.SashimiType.EEL);
						makeGreenPlateRequest(sashimi, position);
					} else if (kind.equals("Crab")) {
						sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
						makeGreenPlateRequest(sashimi, position);
					} else if (kind.equals("Shrimp")) {
						sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeGreenPlateRequest(sashimi, position);
					}
				}
			} else if (color.equals("Blue")) {
				if (type.equals("Nigiri")) {
					if (kind.equals("Tuna")) {
						nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
						makeBluePlateRequest(nigiri, position);
					} else if (kind.equals("Yellowtail")) {
						nigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
						makeBluePlateRequest(nigiri, position);
					} else if (kind.equals("Eel")) {
						nigiri = new Nigiri(Nigiri.NigiriType.EEL);
						makeBluePlateRequest(nigiri, position);
					} else if (kind.equals("Crab")) {
						nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
						makeBluePlateRequest(nigiri, position);
					} else if (kind.equals("Shrimp")) {
						nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeBluePlateRequest(nigiri, position);
					}
				} else {
					if (kind.equals("Tuna")) {
						sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
						makeBluePlateRequest(sashimi, position);
					} else if (kind.equals("Yellowtail")) {
						sashimi = new Sashimi(Sashimi.SashimiType.YELLOWTAIL);
						makeBluePlateRequest(sashimi, position);
					} else if (kind.equals("Eel")) {
						sashimi = new Sashimi(Sashimi.SashimiType.EEL);
						makeBluePlateRequest(sashimi, position);
					} else if (kind.equals("Crab")) {
						sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
						makeBluePlateRequest(sashimi, position);
					} else if (kind.equals("Shrimp")) {
						sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeBluePlateRequest(sashimi, position);
					}
				}
			} else if (color.equals("Gold")) {
				double price = Double.parseDouble(JOptionPane.showInputDialog(
						"How much is this plate? ($5.00 - $10.00)"));
				while (price < 5 || price > 10) {
					price = Double.parseDouble(JOptionPane.showInputDialog(
							"Please enter again: the price should between $5.00 and $10.00)"));
				}
				if (type.equals("Nigiri")) {
					if (kind.equals("Tuna")) {
						nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
						makeGoldPlateRequest(nigiri, position, price);
					} else if (kind.equals("Yellowtail")) {
						nigiri = new Nigiri(Nigiri.NigiriType.YELLOWTAIL);
						makeGoldPlateRequest(nigiri, position, price);
					} else if (kind.equals("Eel")) {
						nigiri = new Nigiri(Nigiri.NigiriType.EEL);
						makeGoldPlateRequest(nigiri, position, price);
					} else if (kind.equals("Crab")) {
						nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
						makeGoldPlateRequest(nigiri, position, price);
					} else if (kind.equals("Shrimp")) {
						nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
						makeGoldPlateRequest(nigiri, position, price);
					}
				} else {
					if (kind.equals("Tuna")) {
						sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
						makeGoldPlateRequest(sashimi, position, price);
					} else if (kind.equals("Yellowtail")) {
						sashimi = new Sashimi(Sashimi.SashimiType.YELLOWTAIL);
						makeGoldPlateRequest(sashimi, position, price);
					} else if (kind.equals("Eel")) {
						sashimi = new Sashimi(Sashimi.SashimiType.EEL);
						makeGoldPlateRequest(sashimi, position, price);
					} else if (kind.equals("Crab")) {
						sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
						makeGoldPlateRequest(sashimi, position, price);
					} else if (kind.equals("Shrimp")) {
						sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
						makeGoldPlateRequest(sashimi, position, price);
					}
				}	
			}
		} else {
			String name = JOptionPane.showInputDialog("What's the name of the roll?");
			Object[] ingredients = {"Avocado", "Crab", "Eel", "Rice", "Seaweed", "Shrimp", "Tuna", "Yellowtail"};
			IngredientPortion[] ingre = new IngredientPortion[8];
//			ArrayList<IngredientPortion> list = new ArrayList<IngredientPortion>();
//			double amount = 0;
			boolean finish = false;
			while (!finish) {
				String ingredient = (String) JOptionPane.showInputDialog(
						null,"Which ingredient do you want to add?", "Ingredient", 
						JOptionPane.PLAIN_MESSAGE, null, ingredients, "Avocado"); 
				double ounce = Double.parseDouble(JOptionPane.showInputDialog(
						"How much do you want to add?"));
				
				if (ingredient.equals("Avocado")) {
					if (ingre[0] == null) {
						if (ounce <= 1.5) {
							ingre[0] = new AvocadoPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[0] = new AvocadoPortion(ounce);
						}
					} else {
						if (ingre[0].getAmount() + ounce <= 1.5) {
							ingre[0] = new AvocadoPortion(ingre[0].getAmount() + ounce);
						} else {
							while (ingre[0].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[0].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[0] = new AvocadoPortion(ingre[0].getAmount() + ounce);
						}	
					}
				} else if (ingredient.equals("Crab")) {
					if (ingre[1] == null) {
						if (ounce <= 1.5) {
							ingre[1] = new CrabPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[1] = new CrabPortion(ounce);
						}
					} else {
						if (ingre[1].getAmount() + ounce <= 1.5) {
							ingre[1] = new CrabPortion(ingre[1].getAmount() + ounce);
						} else {
							while (ingre[1].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[1].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[1] = new CrabPortion(ingre[1].getAmount() + ounce);
						}	
					}
				} else if (ingredient.equals("Eel")) {
					if (ingre[2] == null) {
						if (ounce <= 1.5) {
							ingre[2] = new EelPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[2] = new EelPortion(ounce);
						}
					} else {
						if (ingre[2].getAmount() + ounce <= 1.5) {
							ingre[2] = new EelPortion(ingre[2].getAmount() + ounce);
						} else {
							while (ingre[2].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[2].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[2] = new EelPortion(ingre[1].getAmount() + ounce);
						}	
					}	
				} else if (ingredient.equals("Rice")) {
					if (ingre[3] == null) {
						if (ounce <= 1.5) {
							ingre[3] = new RicePortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[3] = new RicePortion(ounce);
						}
					} else {
						if (ingre[3].getAmount() + ounce <= 1.5) {
							ingre[3] = new RicePortion(ingre[3].getAmount() + ounce);
						} else {
							while (ingre[3].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[3].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[3] = new RicePortion(ingre[3].getAmount() + ounce);
						}	
					}
				} else if (ingredient.equals("Seaweed")) {
					if (ingre[4] == null) {
						if (ounce <= 1.5) {
							ingre[4] = new SeaweedPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[4] = new SeaweedPortion(ounce);
						}
					} else {
						if (ingre[4].getAmount() + ounce <= 1.5) {
							ingre[4] = new SeaweedPortion(ingre[4].getAmount() + ounce);
						} else {
							while (ingre[4].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[4].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[4] = new SeaweedPortion(ingre[4].getAmount() + ounce);
						}	
					}
				} else if (ingredient.equals("Shrimp")) {
					if (ingre[5] == null) {
						if (ounce <= 1.5) {
							ingre[5] = new ShrimpPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[5] = new ShrimpPortion(ounce);
						}
					} else {
						if (ingre[5].getAmount() + ounce <= 1.5) {
							ingre[5] = new ShrimpPortion(ingre[5].getAmount() + ounce);
						} else {
							while (ingre[5].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[5].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[5] = new ShrimpPortion(ingre[5].getAmount() + ounce);
						}	
					}
				} else if (ingredient.equals("Tuna")) {
					if (ingre[6] == null) {
						if (ounce <= 1.5) {
							ingre[6] = new TunaPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[6] = new TunaPortion(ounce);
						}
					} else {
						if (ingre[6].getAmount() + ounce <= 1.5) {
							ingre[6] = new TunaPortion(ingre[6].getAmount() + ounce);
						} else {
							while (ingre[6].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[6].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[6] = new TunaPortion(ingre[6].getAmount() + ounce);
						}	
					}
				} else if (ingredient.equals("Yellowtail")) {
					if (ingre[7] == null) {
						if (ounce <= 1.5) {
							ingre[7] = new YellowtailPortion(ounce);
						} else {
							while (ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. Please enter again."));
							}
							ingre[7] = new YellowtailPortion(ounce);
						}
					} else {
						if (ingre[7].getAmount() + ounce <= 1.5) {
							ingre[7] = new YellowtailPortion(ingre[7].getAmount() + ounce);
						} else {
							while (ingre[7].getAmount() + ounce > 1.5) {
								ounce = Double.parseDouble(JOptionPane.showInputDialog(
										"The ingredient weight cannot exceed 1.5 ounces. But it is now " 
								+ (ingre[7].getAmount() + ounce) + ". Please enter again."));
							}
							ingre[7] = new YellowtailPortion(ingre[7].getAmount() + ounce);
						}	
					}
				}
		
				int more = JOptionPane.showConfirmDialog(null, "Finish?", "MoreIngredient",
						JOptionPane.YES_NO_OPTION);
				if (more == 0) {
					finish = true;
				}
			}
			
			int count = 0;
			for (int i = 0; i < ingre.length; i++) {
				if (ingre[i] == null) {
					count++;
				}
			}
			
			IngredientPortion[] ingr = new IngredientPortion[ingre.length - count];
			int t = 0;
			for (int i = 0; i < ingre.length; i++) {
				if (ingre[i] != null) {
					ingr[t] = ingre[i];
					t++;
				}
			}
	      
			roll = new Roll(name, ingr);
			
			if (color.equals("Red")) {
				makeRedPlateRequest(roll, position);
			} else if (color.equals("Green")) {
				makeGreenPlateRequest(roll, position);
			} else if (color.equals("Blue")) {
				makeBluePlateRequest(roll, position);
			} else if (color.equals("Gold")) {
				double price = Double.parseDouble(JOptionPane.showInputDialog(
						"How much is this plate? ($5.00 - $10.00)"));
				while (price < 5 || price > 10) {
					price = Double.parseDouble(JOptionPane.showInputDialog(
							"Please enter again: the price should between $5.00 and $10.00)"));
				}
				makeGoldPlateRequest(roll, position, price);
			}
		}
	}

}
