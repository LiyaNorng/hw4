import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveMonsterGame {

	public static void saveGame(Trainer player){		
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
