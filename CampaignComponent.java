import java.io.IOException;

public abstract class CampaignComponent {

	public void add(CampaignComponent campaignComponent){
		throw new UnsupportedOperationException();
	}
	
	public void remove(CampaignComponent campaignComponent){
		throw new UnsupportedOperationException();
	}
	
	public String getDifficulty(){
		throw new UnsupportedOperationException();
	}
	
	public void startCampaign(){
		throw new UnsupportedOperationException();
	}
	
	public int getStage(){
		throw new UnsupportedOperationException();
	}
	
	public CampaignComponent getComponent(int i){
		throw new UnsupportedOperationException();
	}
	public int getFence(){
		throw new UnsupportedOperationException();
	}

	public boolean contains(CampaignComponent campaignComponent) {
		throw new UnsupportedOperationException();
	}

}
