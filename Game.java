import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
class Game extends Duel{
	Player p1,p2, player;
	ArrayList <Player> listOfPlayer = new ArrayList<Player>();
	Scanner scanner = new Scanner(System.in);
	String userInput;
	boolean campaign=false;
	boolean automated=true;
	int stage=1;
	
	public Game(Player player1,Player player2) throws IOException{
		System.out.println("Do you want start a new game?");
		userInput = scanner.nextLine();
		if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y")){
			for (int i = 0; i < 2; i++){
				System.out.println("Please give me a userName.");
				userInput = scanner.nextLine();
				if (i == 0){
					Player p1=new PlayerName(userInput, 0, 1);
					p1.setLoad("new");
					listOfPlayer.add(p1);
					}
				else{
					Player p2=new PlayerName(userInput, 0, 1);
					p2.setLoad("new");
					listOfPlayer.add(p2);
				}
			}

			System.out.println("Would you like to select a character race?");
			userInput=scanner.nextLine();
			if(userInput.equalsIgnoreCase("yes")||userInput.equalsIgnoreCase("y")){
				System.out.println("Select a race: Human, Dwarf, Elven or DragonBorn");
				userInput=scanner.nextLine();
				if(userInput.equalsIgnoreCase("human")){
					p1 = new HumanRace();
				}else if(userInput.equalsIgnoreCase("dwarf")){
					p1 = new DwarfRace();
				}else if(userInput.equalsIgnoreCase("elven")){
					p1 = new ElvenRace();
				}else if(userInput.equalsIgnoreCase("dragonborn")){
					p1 = new DragonBornRace();
				}
			}
			System.out.println("Would you like to select a class?");
			userInput=scanner.nextLine();
			if(userInput.equalsIgnoreCase("yes")||userInput.equalsIgnoreCase("y")){
				System.out.println("Select a class: Cleric, Babarian, Paladin or Ranger");
				userInput=scanner.nextLine();
				if(userInput.equalsIgnoreCase("cleric")){
					p1 = new Cleric(p1);
				}else if(userInput.equalsIgnoreCase("barbarian")){
					p1 = new Barbarian(p1);
				}else if(userInput.equalsIgnoreCase("paladin")){
					p1 = new Paladin(p1);
				}else if(userInput.equalsIgnoreCase("Ranger")){
					p1 = new Ranger(p1);
				}
			}
			
			System.out.println("Would you like to play the campaign mode?");
			userInput=scanner.nextLine();
			if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y"))
				campaign=true;
				
			System.out.println("Would you like to choose your own moves?");
			userInput=scanner.nextLine();
			if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y"))
				automated=false;
	    }
	    else{
	    	System.out.println("Do you want to load up your mid game check point?");
			userInput = scanner.nextLine();
			if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y")){
        		for (int i= 0; i < 2; i++){
            		System.out.println("Please give me a name for a player and a computer: ");
                	userInput = scanner.nextLine();
                	player = new LoadCastleGame().loadGame(userInput);
                	if (i == 0){
            			p1 = player;
            		}
            		else{
            			p2 = player;
            			automated = p2.getAutomated();
            		}
            		listOfPlayer.add(player);	
        		}
			}
			else {
				System.out.println("Do you want to load up your end game check point?");
				userInput = scanner.nextLine();
				if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y")){
					for (int i = 0; i < 2; i++){
	            		System.out.println("Please give me a name for a player and a computer: ");
	                	userInput = scanner.nextLine();
	                	player = new LoadCastleGame().loadGame(userInput);
	                	player.resetPlayer();
                		player.addCardToHand();
                		if (i == 1){
                			automated = p2.getAutomated();
                		}
                    	listOfPlayer.add(player);	
	            	}
					
					
					/**
					Scanner scanner = new Scanner(new File("out.txt"));
					int builders=scanner.nextInt();
					int bricks=scanner.nextInt();
					int soldiers=scanner.nextInt();
					int weapons=scanner.nextInt();
					int magic=scanner.nextInt();
					int crystals=scanner.nextInt();
					int castle=scanner.nextInt();
					int fence=scanner.nextInt();
					
					p1.loadPlayer(builders, bricks, soldiers, weapons, magic, crystals, castle, fence);
					
				 	builders=scanner.nextInt();
					bricks=scanner.nextInt();
					soldiers=scanner.nextInt();
					weapons=scanner.nextInt();
					magic=scanner.nextInt();
					crystals=scanner.nextInt();
					castle=scanner.nextInt();
					fence=scanner.nextInt();
					
					p2.loadPlayer(builders, bricks, soldiers, weapons, magic, crystals, castle, fence);
					**/
				}
				else{
					System.exit(1);
				}
			}
	    }
		for ( int i = 0; i < listOfPlayer.size(); i++){
			if (i == 0){
				p1 = listOfPlayer.get(i);
			}
			else{
				p2 = listOfPlayer.get(i);
			}
		}

	}
	public void getStats(Player player){
		System.out.print("\tCastle: "+player.getCastle()+"\tFence: "+player.getFence()+"\t b:"+player.getBricks()+" w:"+player.getWeapons()+" c:"+player.getCrystals()+
				"\n__________________________________________________________________\nHand------->");
		
	}
	public void showHand(Player player)
	{
			getStats(player);
			player.showHand();
	}
	//each player gets a move
	//game checks for a winner after each move is executed
	public void round(){
		System.out.print("Player 1");
		showHand(p1);
		Move moveMade=null;
		if (automated){
			moveMade=p1.makeMove();
		}
		else{
			boolean gotMove=false;
			int index;
			System.out.println("would you like to save and continue the game later?\n This would overwrite any other restore point.");
			userInput = scanner.nextLine();
			if (userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("y")){
				p1.setAutomated(automated);
				for (int i = 0; i < listOfPlayer.size(); i++){
					new SaveCastleGame().saveGame(listOfPlayer.get(i));
				}
				System.out.println("Game Saved!");
				listOfPlayer.clear();
				System.exit(1);
				
				/**
				FileOutputStream out; // declare a file output object
						PrintStream p; // declare a print stream object

						try
						{
							// Create a new file output stream
							out = new FileOutputStream("out.txt");

							// Connect print stream to the output stream
							p = new PrintStream( out );
						
							p.println (p1.getBuilders());
							p.println(p1.getBricks());
							p.println(p1.getSoldiers());
							p.println(p1.getWeapons());
							p.println(p1.getMagic());
							p.println(p1.getCrystals());
							p.println(p1.getCastle());
							p.println(p1.getFence());
							p.println(p2.getBuilders());
							p.println(p2.getBricks());
							p.println(p2.getSoldiers());
							p.println(p2.getWeapons());
							p.println(p2.getMagic());
							p.println(p2.getCrystals());
							p.println(p2.getCastle());
							p.println(p2.getFence());
							
							p.close();
							System.exit(0);
						}
						catch (Exception e)
						{
							System.err.println ("Error writing to file");
						}
						
						**/
			}
			do{
				System.out.println("Would you like to use or discard a card?");
				userInput=scanner.nextLine();
				if(userInput.equalsIgnoreCase("use")){
					System.out.println("Please enter the position of the card in your hand. 1-8");
					index=scanner.nextInt()-1;
					scanner.nextLine();
					if (index>7|| index<0)
						System.out.println("Invalid input");
					else if (p1.getCard(index).isPlayable()==false)
						System.out.println("You're not able to use this card");
					else{
						moveMade=new UseCard(p1.getCard(index));
						gotMove=true;
					}
				}else if (userInput.equalsIgnoreCase("discard")){
					System.out.println("Please enter the position of the card in your hand. 1-8");
					index=scanner.nextInt()-1;
					scanner.nextLine();
					if (index>7|| index<0)
						System.out.println("Invalid input");
					else{
						moveMade=new DiscardCard(p1.getCard(index));
						gotMove=true;
					}
				}
					
			}while (!gotMove);
		}
		if (moveMade!=null){
			moveMade.execute(p1,p2);
			System.out.print(moveMade.getCard().getName());
			System.out.println(" - "+moveMade.getCard().getPower());
			System.out.println("\n\n\n");}
		checkForWin(p1,p2);
		
		System.out.print("Player 2");
		showHand(p2);
		moveMade=p2.makeMove();
		moveMade.execute(p2,p1);
		System.out.print(moveMade.getCard().getName());
		System.out.println(" - "+moveMade.getCard().getPower());
		System.out.println("\n\n\n");
		
		checkForWin(p1,p2);
		
		//after each round, stocks are increased for each player accordingly
		increaseStocks(p1,p2);
	}
	public void checkForWin(Player p1,Player p2)
	{
		
		//Users can win by destroying their enemy's castle or building their castle up to 100
		String winner=null;
		if(p1.getCastle()>99)
		{
			winner="Player 1 ";
		}
		else if (p1.getCastle()<1)
		{
			winner="Player 2 ";
		}
		else if (p2.getCastle()>99)
		{
			winner="Player 2 ";
		}
		else if (p2.getCastle()<1)
		{
			winner="Player 1 ";
		}
		//if there's a winner, display message and terminate the program
		if (winner!=null)
		{
			System.out.println(winner+ " won!");
			if (!campaign){
				if (winner.contains("1")){
					p1.setPoint(p1.getPoint() + 1);
				}
				else{
					p2.setPoint(p2.getPoint() + 1);
				}
				p1.setAutomated(automated);
				for (int i = 0; i < listOfPlayer.size(); i++){
					new SaveCastleGame().saveGame(listOfPlayer.get(i));
				}
				System.out.println("Game Saved!");
				listOfPlayer.clear();
			}
			if (campaign){
				if (winner.contains("1")){
					if (stage==3){
						System.out.println("You won the campaign challenge");
						System.exit(0);
					}
					else if (stage==1)
					{
						System.out.println("\n\n\n======================================");
						System.out.println("Congratulations you passed stage 1");
						System.out.println("======================================\n\n\n");
						stage+=1;
						playMediumDifficulty();
					}
					else if(stage==2){
						System.out.println("\n\n\n======================================");
						System.out.println("Congratulations you passed stage 1");
						System.out.println("======================================\n\n\n");
						stage+=1;
						playHardDifficulty();}
				}
				else{ System.out.println("You lost the campaign challenge in stage "+stage);
					System.exit(0);}
			}else System.exit(0);//quit the game
		}
		
	}
	public void playMediumDifficulty(){
		p1.resetPlayer();
		p2.resetPlayer();
		p2.buildFence(10);
		super.play();
	}
	public void playHardDifficulty(){
		p1.resetPlayer();
		p2.resetPlayer();
		p2.buildFence(15);
		super.play();
	}
	//bricks are increased depending on how many builders you have
	//weapons are increased depending on how many soldiers you have
	//crystals are increased depending on how much magic you have
	public void increaseStocks(Player p1, Player p2)
	{
		int amount;
		amount=p1.getBuilders();
		p1.increaseBricks(amount);
		amount=p2.getBuilders();
		p2.increaseBricks(amount);
		amount=p1.getSoldiers();
		p1.increaseWeapons(amount);
		amount=p2.getSoldiers();
		p2.increaseWeapons(amount);
		amount=p1.getMagic();
		p1.increaseCrystals(amount);
		amount=p2.getMagic();
		p2.increaseCrystals(amount);
	}
}