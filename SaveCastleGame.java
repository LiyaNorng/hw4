import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCastleGame {
	public static void saveGame(Player player){		
		try{
			FileOutputStream fos = new FileOutputStream(player.getUserName() + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
			oos.close();	
			System.out.println("Game Saved!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
