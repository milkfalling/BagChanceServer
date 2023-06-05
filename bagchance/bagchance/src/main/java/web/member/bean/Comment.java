package web.member.bean;

import java.sql.Timestamp;

public class Comment {
		private String sid;
	    private Timestamp LAST_UPDATE_DATE;
	    private byte[] profile_pic;
	    private String uid;
	    private String ppBase64;
		private String nickname;
	    private String comment;
	    
		public String getPpBase64() {
			return ppBase64;
		}
		public void setPpBase64(String ppBase64) {
			this.ppBase64 = ppBase64;
		}
	    private Timestamp Sclud;
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public Timestamp getLAST_UPDATE_DATE() {
			return LAST_UPDATE_DATE;
		}
		public void setLAST_UPDATE_DATE(Timestamp lAST_UPDATE_DATE) {
			LAST_UPDATE_DATE = lAST_UPDATE_DATE;
		}
		public byte[] getProfile_pic() {
			return profile_pic;
		}
		public void setProfile_pic(byte[] profile_pic) {
			this.profile_pic = profile_pic;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public Timestamp getSclud() {
			return Sclud;
		}
		public void setSclud(Timestamp sclud) {
			Sclud = sclud;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
	    
	    
	    
}