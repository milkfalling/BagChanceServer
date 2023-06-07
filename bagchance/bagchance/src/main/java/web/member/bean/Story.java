package web.member.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Story implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sid;
	private String uid;
	private String location;
	private String longitude;
	private String latitude;
	private String content;
	private String last_update_date;
	private byte[] profile_pic;
	private String ppBase64;
	private String nickname;
	
	
	public byte[] getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(byte[] profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}
	public String getPpBase64() {
		return ppBase64;
	}
	public void setPpBase64(String ppBase64) {
		this.ppBase64 = ppBase64;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
}