import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class SaveMonsterCardGame{
	
	public void saveGame(Map<String, Trainer> player, String playerWon){
		try{
			ArrayList <String> listOfPlayer = new ArrayList<String>();
        	String line = "";
	    	Trainer setPlayer = null;
        	String playerOneUserName = null;
        	String computerUserName = null;
        	for (String key: player.keySet()){
        		setPlayer = player.get(key);
        		if (setPlayer.getComputer().equals("1")){
        			computerUserName = setPlayer.getUserName();
        		}
        		else{
        			playerOneUserName = setPlayer.getUserName();
        		}
        	}

			FileReader file_Input = new FileReader("textFile.txt");
			BufferedReader buffers = new BufferedReader(file_Input);
			while((line = buffers.readLine()) != null){
				if (line.equals(playerOneUserName) || line.equals(computerUserName)){
					buffers.readLine();
					buffers.readLine();
					buffers.readLine();
					line = buffers.readLine();
					if (playerWon.equals(playerOneUserName) && player.get(playerOneUserName).getLoad().equals("new")){
						player.get(playerOneUserName).setPoint(player.get(playerOneUserName).getPoint() + Integer.valueOf(line));
						player.get(playerOneUserName).setLevel(Integer.valueOf(buffers.readLine()));
					}
					else if (playerWon.equals(computerUserName) && player.get(computerUserName).getLoad().equals("new")){
						player.get(computerUserName).setPoint(player.get(computerUserName).getPoint() + Integer.valueOf(line));
						player.get(computerUserName).setLevel(Integer.valueOf(buffers.readLine()));
					}
					else
					{
						buffers.readLine();
					}
				}
				else
				{
					for (int i = 0; i < 5; i++){
						line = buffers.readLine();
						listOfPlayer.add(line);
					}	
				}
				
			}
			
			FileWriter fileWriter = new FileWriter("textFile.txt");
        	BufferedWriter buffer = new BufferedWriter(fileWriter);        	
	    	
	    	for (int i = 0; i < listOfPlayer.size(); i++){
	    		buffer.write(listOfPlayer.get(i));
	    		buffer.newLine();
	    	}

	    	for (String key: player.keySet())
	        {
	    		setPlayer = player.get(key);
    			buffer.write(setPlayer.getUserName());
    			buffer.newLine();
    			buffer.write(setPlayer.getGender());
    			buffer.newLine();
    			buffer.write(setPlayer.getTurn());
    			buffer.newLine();
    			buffer.write(setPlayer.getComputer());
    			buffer.newLine();
    			if (setPlayer.getPoint() >= 3){
    				setPlayer.setLevel(setPlayer.getLevel() + 1);
    				setPlayer.setPoint(0);
    			}
    			buffer.write(String.valueOf(setPlayer.getPoint()));
    			buffer.newLine();
    			buffer.write(String.valueOf(setPlayer.getLevel()));
    			buffer.newLine();
	        }   
	    	buffer.close();
	    	buffers.close();
	    	listOfPlayer.clear();
	    	System.out.println("Game Saved");
		}
		catch ( IOException e){
            e.printStackTrace();
		}	
	}
}
