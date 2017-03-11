import java.util.ArrayList;
import java.util.Iterator;

public class Campaign extends CampaignComponent{
	ArrayList<CampaignComponent> campaignComponents = new ArrayList<CampaignComponent>();
	String difficulty;
	int stage = 1;
	Player p1;
	Player p2;
	CampaignComponent campaignComponent;
	
	public Campaign(String difficulty){
		this.difficulty = difficulty;
	}
	
	public void add(CampaignComponent campaignComponent){
		campaignComponents.add(campaignComponent);
	}
	
	public void remove(CampaignComponent campaignComponent){
		campaignComponents.remove(campaignComponent);		
	}
	
	
	public String getDifficulty(){
		return difficulty;
	}

	
	public void startCampaign(){
		
		Iterator<CampaignComponent> iterator = campaignComponents.iterator();
		while(iterator.hasNext()){
			CampaignComponent campaignComponent = (CampaignComponent)iterator.next();
			campaignComponent.startCampaign();
		}
		
	}
	
}
