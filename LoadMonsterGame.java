import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadMonsterGame {

	public static Trainer loadGame(String name){	
		Trainer player = new Trainer();
		try{
			FileInputStream fis = new FileInputStream(name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			player = (Trainer) ois.readObject();
			ois.close();	
		} catch (FileNotFoundException exception) {
	        System.out.println("The file " + name + ".ser" + " was not found.");
	        System.out.println("Please create an account first to resume the game.");
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
