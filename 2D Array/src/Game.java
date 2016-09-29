import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game
	{
		static String name;
		static int waterLevel = 10;
		static int playerRow = 19;
		static int playerCol = 10;
		static int numOfFood = 10;
		static int health = 100;
		static String weapon = "Fists";
		static int attack;
		static boolean gameContinue = true;
		private static final long serialVersionUID=1L;
		static JFrame frame=new JFrame();
		static String arrayGame[][] = new String [20][20];
		public static void main(String[] args)
			{
				//doIntro();
				fillWithStars();
				while (gameContinue)
				{
					printStats();
					doMove();
				}
			}
		public static void doHouse()
		{
			int choice;
			Object[] options = {"Run Away", "Fight"};
			ImageIcon icon =  new ImageIcon("uu.gif");
			choice = JOptionPane.showOptionDialog(null, 
				"A Man Attacks You With a Knife",
				"You Enter the House",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
				case 0:
					{
					JOptionPane.showMessageDialog(frame, "You Got Away Safely");
					break;
					}
				case 1:
					{
					JOptionPane.showMessageDialog(frame, "Prepare your "+weapon);
					doHouseFight();
					break;
					}
				}
		}
		public static void dieFight()
			{
				int choice;
				Object[] options = {"Restart", "End"};
				ImageIcon icon =  new ImageIcon("bg.gif");
				choice = JOptionPane.showOptionDialog(null, 
					"You Died",
					"Choose Your Action",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, 
					icon,
					options, 
					options[1]);
					switch(choice)
					{
						case 0:
								{
									gameContinue=true;
								}
						case 1:
								{
									JOptionPane.showMessageDialog(frame, "Good Try");
								}
					}
			}
		public static void doHouseFight()
		{
			if (weapon.equals("Fists"))
				{
					attack=5;
				}
			else if (weapon.equals("Knife"))
				{
					attack=10;
				}
			else if (weapon.equals("Gun"))
				{
					attack=50;
				}
			int ownerHealth=30;
			int choice;
			boolean fight = true;
			if (weapon.equals("Fists"))
				{
			while (fight)
				{
					Object[] options = {"Punch (x5 Attack)", "Heal (-1 Food | +10 Health)"};
					ImageIcon icon =  new ImageIcon("bbbb.gif");
					choice = JOptionPane.showOptionDialog(null, 
						"Enemy Health = "+ownerHealth+"  |   Your Health = "+health,
						"Choose Your Action",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						icon,
						options, 
						options[1]);
						switch(choice)
						{
						case 0:
							{
							int chance1 = (int)(Math.random()*2+1);
							if (chance1 == 1)
								{
							ownerHealth-=attack;
							health-=10;
							if (ownerHealth==0)
								{
									JOptionPane.showMessageDialog(frame, "Good Win. You found water, food, and a knife");
									waterLevel=10;
									numOfFood+=5;
									health-=10;
									weapon.equals("Knife");
									fight = false;
									break;
								}
							if (health==0)
								{
									dieFight();
									fight = false;
									gameContinue=false;
									
								}
							else
								{
									break;
								}
								}
							else 
								{
									if (health==0)
										{
											dieFight();
											fight = false;
											gameContinue=false;
											
										}
									else
										{
									JOptionPane.showMessageDialog(frame, "You Missed");
									health-=10;
									break;
										}
								}
							}
						case 1:
							{
							numOfFood-=1;
							health+=10;
							break;
							}
						}
				}
				}
			else if (weapon.equals("Knife"))
				{
					while (fight)
						{
							Object[] options = {"Punch (x5 Attack)", "Heal (-1 Food | +10 Health)"};
							ImageIcon icon =  new ImageIcon("bbbb.gif");
							choice = JOptionPane.showOptionDialog(null, 
								"Enemy Health = "+ownerHealth+"  |   Your Health = "+health,
								"Choose Your Action",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, 
								icon,
								options, 
								options[1]);
								switch(choice)
								{
								case 0:
									{
									int chance1 = (int)(Math.random()*2+1);
									if (chance1 == 1)
										{
									ownerHealth-=attack;
									health-=10;
									if (ownerHealth==0)
										{
											JOptionPane.showMessageDialog(frame, "Good Win. You found water, food, and a knife");
											waterLevel=10;
											numOfFood+=5;
											health-=10;
											weapon.equals("Knife");
											fight = false;
											break;
										}
									else if (health==0)
										{
											fight = false;
											gameContinue=false;
											dieFight();
											break;
										}
									else
										{
											break;
										}
										}
									else 
										{
											JOptionPane.showMessageDialog(frame, "You Missed");
											health-=10;
											break;
										}
									}
								case 1:
									{
									numOfFood-=1;
									health+=10;
									break;
									}
								}
						}
				}
			else if (weapon.equals("Gun"))
				{
					while (fight)
						{
							Object[] options = {"Punch (x5 Attack)", "Heal (-1 Food | +10 Health)"};
							ImageIcon icon =  new ImageIcon("bbbb.gif");
							choice = JOptionPane.showOptionDialog(null, 
								"Enemy Health = "+ownerHealth+"  |   Your Health = "+health,
								"Choose Your Action",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, 
								icon,
								options, 
								options[1]);
								switch(choice)
								{
								case 0:
									{
									int chance1 = (int)(Math.random()*2+1);
									if (chance1 == 1)
										{
									ownerHealth-=attack;
									health-=10;
									if (ownerHealth==0)
										{
											JOptionPane.showMessageDialog(frame, "Good Win. You found water, food, and a knife");
											waterLevel=10;
											numOfFood+=5;
											health-=10;
											weapon.equals("Knife");
											fight = false;
											break;
										}
									if (health==0)
										{
											fight = false; 
											gameContinue=false;
											dieFight();
											break;
										}
									else
										{
											break;
										}
										}
									else 
										{
											JOptionPane.showMessageDialog(frame, "You Missed");
											health-=10;
											break;
										}
									}
								case 1:
									{
									numOfFood-=1;
									health+=10;
									break;
									}
								}
						}
				}
		}
		public static void doMine()
		{
			int choice;
			Object[] options = {"Go Inside", "Leave"};
			ImageIcon icon =  new ImageIcon("ll.gif");
			choice = JOptionPane.showOptionDialog(null, 
				"A Seemingly Abandoned Mine",
				"Choose Your Action",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
					case 0:
							{
								gameContinue=true;
								
								break;
							}
					case 1:
							{
								JOptionPane.showMessageDialog(frame, "You Got Away Safely");
								break;
							}
				}
		}
		public static void doCave()
		{
			int choice;
			Object[] options = {"Go Inside", "Leave"};
			ImageIcon icon =  new ImageIcon("6666.jpg");
			choice = JOptionPane.showOptionDialog(null, 
				"A Dark Cave",
				"Choose Your Action",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
					case 0:
							{
								gameContinue=true;
								
								break;
							}
					case 1:
							{
								JOptionPane.showMessageDialog(frame, "You Got Away Safely");
								break;
							}
				}
		}
		public static void doVillage()
		{
			int choice;
			Object[] options = {"Enter the Village", "Leave"};
			ImageIcon icon =  new ImageIcon("55555.jpg");
			choice = JOptionPane.showOptionDialog(null, 
				"This Village Seems Quiet",
				"Choose Your Action",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				icon,
				options, 
				options[1]);
				switch(choice)
				{
					case 0:
							{
								gameContinue=true;
								ImageIcon icon3 =  new ImageIcon("gtg.jpg");
								JOptionPane.showMessageDialog(
										frame, 
										"You Died from a Lack of Hydration",
										"Stranded in a Field", 
										JOptionPane.INFORMATION_MESSAGE, icon3); 	
								break;
							}
					case 1:
							{
								JOptionPane.showMessageDialog(frame, "You Got Away Safely");
								break;
							}
				}
		}
		public static void printStats()
		{
			System.out.println(" ");
			System.out.println("---------------------------------");
			System.out.println("| Water Level:"+waterLevel+" |  Health:"+health+"  |");
			System.out.println("---------------------------------");
			System.out.println("| Food Level:"+numOfFood+"  | Weapon:"+weapon+" |");
			System.out.println("---------------------------------");
		}
		public static void doWaterEnding()
		{
			ImageIcon icon3 =  new ImageIcon("gtg.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"You Died from a Lack of Hydration",
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon3); 	
			gameContinue=false;
		}
		public static void display()
		{
			arrayGame[playerRow][playerCol]=" @ ";
			for(int row = 0; row<arrayGame.length; row++)
				{
					System.out.println(" ");
					for(int col = 0; col<arrayGame[0].length;col++)
						{
							System.out.print(arrayGame[row][col]);
						}
				}
		}
		public static void doIntro()
		{
			ImageIcon icon =  new ImageIcon("gt.jpg");
			name = (String)JOptionPane.showInputDialog(
                    frame,
                    "Hey There, What is Your Name?",
                    "Stranded in a Field",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    null,  
                    null); 
			ImageIcon icon2 =  new ImageIcon("mm.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"Well "+name+"... You just woke up in a deserted field and you can't remember how you got there...", 
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon2); 
			ImageIcon icon3 =  new ImageIcon("gtg.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"Walk around... Explore... Survive... "
					+ " Head For That Seemingly Empty, Old House Over There",
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon3); 
			ImageIcon icon4 =  new ImageIcon("yu.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"Houses are Labeled 'h' On Your Map	"
					+ " -- "
					+" Other Areas are As Follows: "
					+" m = Mine "
					+" v = Village "
					+" c = Cave ",
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon4); 
			ImageIcon icon5 =  new ImageIcon("c.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"Every Step You Take Will Deplete You of Water"
					+ " -- "
					+ " You Have 10 Water Units Right Now",
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon5); 
			ImageIcon icon6 =  new ImageIcon("nn.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"If You Take Damage, You Will Eat Food to Replenish Your Health"
					+ " -- "
					+ " You Have 10 Food Units Right Now",
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon6); 
			ImageIcon icon7 =  new ImageIcon("tt.jpg");
			JOptionPane.showMessageDialog(
					frame, 
					"Use WASD plus Enter to Walk Around",
					"Stranded in a Field", 
					JOptionPane.INFORMATION_MESSAGE, icon7); 
		}
				public static void fillWithStars()
					{
						for(int row = 0; row<arrayGame.length; row++)
							{
								System.out.println(" ");
								for(int col = 0; col<arrayGame[0].length;col++)
									{
										int letter=(int)(Math.random()*75)+1;
										switch (letter)
										{
											case 1:
											case 2:
											case 3:
											case 4:
											case 5:
											case 6:
											case 7:
											case 8:
											case 9:
											case 10:
											case 11:
											case 12:
											case 13:
											case 14:
											case 15:
											case 16:
											case 17:
											case 18:
											case 19:
											case 20:
											case 21:
											case 22:
											case 23:
											case 24:
											case 25:
											case 26:
											case 27:
											case 28:
											case 29:
											case 30:
											case 31:
											case 32:
											case 33:
											case 34:
											case 35:
											case 36:
											case 37:
											case 38:
											case 39:
											case 40:
											case 41:
											case 42:
											case 43:
											case 44:
											case 45:
											case 46:
											case 47:
											case 48:
											case 49:
											case 50:
											case 51:
											case 52:
											case 53:
											case 54:
											case 55:
											case 56:
											case 57:
											case 58:
											case 59:
											case 60:
											case 61:
											case 62:
											case 63:
											case 64:
											case 65:
											case 66:
											case 67:
											case 68:
											case 69:
											case 70:
											case 71:
													{
														arrayGame[row][col]=" ~ ";
														break;
													}
											case 72:
													{
														arrayGame[row][col]=" h ";
														break;
													}
											case 73:
													{
														arrayGame[row][col]=" m ";
														break;
													}
											case 74:
													{
														arrayGame[row][col]=" c ";
														break;
													}
											case 75:
													{
														arrayGame[row][col]=" v ";
														break;
													}
										}
									}
								arrayGame[playerRow][playerCol]=" @ ";
							}
						for(int row = 0; row<arrayGame.length; row++)
							{
								System.out.println(" ");
								for(int col = 0; col<arrayGame[0].length;col++)
									{
										System.out.print(arrayGame[row][col]);
									}
							}
					}
				public static void doMove()
				{
					System.out.println(" ");
					Scanner userInput = new Scanner(System.in);
					String move = userInput.nextLine();
					switch (move)
					{
					case "w":
					{
						if (arrayGame[playerRow-1][playerCol].equals(" m "))
		        			{
		        				doMine();
		        			}
		        			else if (arrayGame[playerRow-1][playerCol].equals(" h "))
		        			{
		        				doHouse();
		        			}
		        			else if (arrayGame[playerRow-1][playerCol].equals(" c "))
		        			{
		        				doCave();
		        			}
		        			else if (arrayGame[playerRow-1][playerCol].equals(" v "))
		        			{
		        				doVillage();
		        			}
		        			else
		        			{
						arrayGame[playerRow][playerCol]=" ~ ";
						playerRow=playerRow-1;
	        			waterLevel=waterLevel-1;
	        			display();
	        			if (waterLevel == 0)
	        			{
	        				gameContinue=false;
	        				doWaterEnding();
	        			}
		        			}
			            break;
					}
					case "a":
					{
						
	        			if (arrayGame[playerRow][playerCol-1].equals(" m "))
	        			{
	        				doMine();
	        			}
	        			else if (arrayGame[playerRow][playerCol-1].equals(" h "))
	        			{
	        				doHouse();
	        			}
	        			else if (arrayGame[playerRow][playerCol-1].equals(" c "))
	        			{
	        				doCave();
	        			}
	        			else if (arrayGame[playerRow][playerCol-1].equals(" v "))
	        			{
	        				doVillage();
	        			}
	        			else
	        			{
	        				arrayGame[playerRow][playerCol]=" ~ ";
							playerCol=playerCol-1;
		        			waterLevel=waterLevel-1;
		        			display();
		        			if (waterLevel == 0)
		        			{
		        				gameContinue=false;
		        				doWaterEnding();
		        			}
	        			}
	        			break;
					}
					case "s":
					{
						if (arrayGame[playerRow+1][playerCol].equals(" m "))
	        			{
	        				doMine();
	        			}
	        			else if (arrayGame[playerRow+1][playerCol].equals(" h "))
	        			{
	        				doHouse();
	        			}
	        			else if (arrayGame[playerRow+1][playerCol].equals(" c "))
	        			{
	        				doCave();
	        			}
	        			else if (arrayGame[playerRow+1][playerCol].equals(" v "))
	        			{
	        				doVillage();
	        			}
	        			else
	        			{
						arrayGame[playerRow][playerCol]=" ~ ";
						playerRow=playerRow+1;
	        			waterLevel=waterLevel-1;
	        			display();
	        			if (waterLevel == 0)
	        			{
	        				gameContinue=false;
	        				doWaterEnding();
	        			}
	        			}
	        			break;
					}
					case "d":
					{
						if (arrayGame[playerRow][playerCol+1].equals(" m "))
		        			{
		        				doMine();
		        			}
		        			else if (arrayGame[playerRow][playerCol+1].equals(" h "))
		        			{
		        				doHouse();
		        			}
		        			else if (arrayGame[playerRow][playerCol+1].equals(" c "))
		        			{
		        				doCave();
		        			}
		        			else if (arrayGame[playerRow][playerCol+1].equals(" v "))
		        			{
		        				doVillage();
		        			}
		        			else
		        			{
						arrayGame[playerRow][playerCol]=" ~ ";
						playerCol=playerCol+1;
	        			waterLevel=waterLevel-1;
	        			display();
	        			if (waterLevel == 0)
	        			{
	        				gameContinue=false;
	        				doWaterEnding();
	        			}
		        			}
	        			break;
					}
					default:
					{
						System.out.println("Only press WASD");
						doMove();
						break;
					}
					}
				}
	}