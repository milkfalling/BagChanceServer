package web.member.bean;

import java.sql.Timestamp;

public class MeRightPath {
	private String uid;
	private String location;
    private String longitude;
    private String latitude;
	private Timestamp Last_update_date;
    private String storyId;
    
    
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Timestamp getLast_update_date() {
		return Last_update_date;
	}
	public void setLast_update_date(Timestamp last_update_date) {
		Last_update_date = last_update_date;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getStoryId() {
		return storyId;
	}
	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}
	
	
    
    
}
