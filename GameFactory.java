import java.io.IOException;

public interface GameFactory {
	public Duel createGame() throws IOException;
}