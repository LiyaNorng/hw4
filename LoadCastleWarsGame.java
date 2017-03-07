import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadCastleWarsGame {
	public Player loadGame(String name){
		Player player = new PlayerName("", 0, 1);
		FileReader file_Input;
		BufferedReader buffer;
		String userName;
		int level;
		String line = "";
		int point;

		try{
			file_Input = new FileReader("textFiles.txt");
			 buffer = new BufferedReader(file_Input);
			
			while((line = buffer.readLine()) != null){
				if (name.equals(line)){
					userName = line;
					point = Integer.valueOf(buffer.readLine());
					level = Integer.valueOf(buffer.readLine());
					player = new PlayerName(userName, point, level);
					break;
				}

			}
            buffer.close();
		}
		catch (IOException e){
            e.printStackTrace();
		}
		return player;
	}

	/**
	
	 file format:
	
	 player username
	 point
	 
	 .......
	 .......
	 ....... //// more player
	 .......
	 
	 

	 */
	
}