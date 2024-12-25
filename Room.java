
public class Room {
	
	private String roomClass;
	private String description;
	private int roomNum;
	private String bedType;
	private boolean booked;

	public Room(String roomClass, String description, int roomNum, String bedType, boolean booked){
	  this.roomClass = roomClass;
	  this.description = description;
	  this.roomNum = roomNum;
	  this.bedType = bedType;
	  this.booked = booked;
	}
	
	public String sayHelloFromNewClass(){
	  return "Hello from New Class";
	}
	
	public String getRoomClass(){
		return roomClass;
	}
	
	public void setRoomClass(String roomClass){
		this.roomClass = roomClass;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public int getRoomNum(){
		return roomNum;
	}
	
	public void setRoomNum(int roomNum){
		this.roomNum = roomNum;
	}
	
	public String getBedType(){
		return bedType;
	}
	
	public void setBedType(String bedType){
		this.bedType = bedType;
	}
	
	public boolean getBooked(){
		return booked;
	}
	
	public void setBooked(boolean booked){
		this.booked = booked;
	}
	
	@Override
	public String toString() {
		return ("Room class: " + roomClass + " , description: " + description + " , room num: " + roomNum + 
				" , bed type: " + bedType + " , booked: " + booked);
	}
	
}
