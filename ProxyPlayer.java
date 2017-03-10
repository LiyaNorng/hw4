
public class ProxyPlayer implements ProxyPattern {
	private String userName;
	private int age;
	private Player player;
	
	public ProxyPlayer(String userName, int age){
		this.userName = userName;
		this.age = age;
	}
	
	@Override
	public void permissionAccess() {

		if (this.age >= 7){
			player = new PlayerName(this.userName, 0, 1);
			player.permissionAccess();
		}
		else{
            System.out.println("No castle war game access granted. You must be age of 7 or above.");  
            System.out.println("System is shutting down.");
            player = null;
            System.exit(1);
		}
	}
	
	public Player getPlayer(){
		return this.player;
	}

}
