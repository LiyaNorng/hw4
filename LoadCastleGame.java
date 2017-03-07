import java.io.FileInputStream;
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
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return player;
	}
}
