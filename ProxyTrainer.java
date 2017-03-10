import java.util.Map;

public class ProxyTrainer implements ProxyPattern{
	private Trainer player;
	private String userName;
	private String gender;
	private String turn;
	private String computer;
	private int age;
	
	public ProxyTrainer(String userName, String gender, String turn, String computer, int age){
		this.userName = userName;
		this.gender = gender;
		this.turn = turn;
		this.computer = computer;
		this.age = age;
	}
	
	
	@Override
	public void permissionAccess() {

		if (this.age >= 10){
			player = new Trainer(this.userName, this.gender, this.turn, this.computer);
			player.permissionAccess();
		}
		else{
            System.out.println("No Monster game access granted. You must be age of 10 or above.");  
            System.out.println("System is shutting down.");
            player = null;
            System.exit(1);
		}
	}
	
	public Trainer getTrainer(){
		return this.player;
	}
}
