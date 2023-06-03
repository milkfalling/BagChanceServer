package web.member.bean;

import java.sql.Timestamp;

public class StoryPic {
	private String id;
	private String storyId;
	private byte[] pic;
	private Timestamp createDate;
	private String picBase64;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
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
