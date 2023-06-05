package web.member.bean;

import java.sql.Timestamp;

public class MePageAllPost{
	private String uid;
	private String content;
	private Timestamp Last_update_date;
	private String storyId;
	private byte[] pic;
	private String picBase64;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getLast_update_date() {
		return Last_update_date;
	}
	public void setLast_update_date(Timestamp last_update_date) {
		Last_update_date = last_update_date;
	}
	public String getStoryId() {
		return storyId;
	}
	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public String getPicBase64() {
		return picBase64;
	}
	public void setPicBase64(String picBase64) {
		this.picBase64 = picBase64;
	}
	


}
