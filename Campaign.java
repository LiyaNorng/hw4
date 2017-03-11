import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Campaign extends CampaignComponent{
	ArrayList<CampaignComponent> campaignComponents = new ArrayList<CampaignComponent>();
	String difficulty;
	int stage;
	int index;
	Player p1;
	Player p2;
	
	public Campaign(String difficulty){
		this.difficulty = difficulty;
	}
	
	public void add(CampaignComponent campaignComponent){
		campaignComponents.add(campaignComponent);
	}
	
	public void remove(CampaignComponent campaignComponent){
		campaignComponents.remove(campaignComponent);		
	}
	
	public CampaignComponent getComponent(int index){
		return campaignComponents.get(index);
	}
	public String getDifficulty(){
		return difficulty;
	}

	public void startCampaign(){
		Game campaign = null;
		try {
			campaign = new Game(p1, p2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<CampaignComponent> iterator = campaignComponents.iterator();
		while(iterator.hasNext()){
			CampaignComponent campaignComponent = (CampaignComponent)iterator.next();
			campaignComponent.startCampaign();
		}
		
	}
	
}
