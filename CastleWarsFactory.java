import java.io.IOException;

public class CastleWarsFactory implements GameFactory {
	public Duel createGame() throws IOException{
		return new Game(new PlayerName("Simpson", 0, 1),new PlayerName("Jack", 0, 1));
	}
}