import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCastleGame {
	public static Player loadGame(String name){	
		Player player = new PlayerName("Smith", 0, 1);
		try{
			FileInputStream fis = new FileInputStream(name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			player = (Player) ois.readObject();
			ois.close();	
		} catch (FileNotFoundException exception) {
	        System.out.println("The file " + name + ".ser" + " was not found.");
	        System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
	        System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	        System.exit(1);
		}
		return player;
	}
}
