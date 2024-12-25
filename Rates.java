
public class Rates extends Room {
	
	private double rate;
	
	public Rates(String roomClass, String description, int roomNum, String bedType, boolean booked, double rate) {
		super(roomClass, description, roomNum, bedType, booked);
		this.rate = rate;
		// TODO Auto-generated constructor stub
	}
	
	public void setRate(int rate) {
		this.rate=rate;
	}
	
	public double getRate(){
		return rate;
	}
	
	@Override
	public String toString() {
		return (super.toString() + " , rate: " + rate);
	}
	
}
