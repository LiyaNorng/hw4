
public class CampaignItem extends CampaignComponent{
	int stage;
	int fence;
	
	public CampaignItem(int fence, int stage){
		this.fence = fence;
		this.stage = stage;
	}
	
	public int getFence(){
		return fence;
	}
	
	
	public int getStage(){
		return stage;
	}
}
