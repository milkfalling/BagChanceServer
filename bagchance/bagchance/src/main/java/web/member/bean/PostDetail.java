package web.member.bean;

public class PostDetail {
		private String sid;
		private byte[] pic;
		private String base64Pic;
		
		public String getSid() {
			return sid;
		}
		public void setSid(String sid) {
			this.sid = sid;
		}
		public byte[] getPic() {
			return pic;
		}
		public void setPic(byte[] pic) {
			this.pic = pic;
		}
		public String getBase64Pic() {
			return base64Pic;
		}
		public void setBase64Pic(String base64Pic) {
			this.base64Pic = base64Pic;
		}
		
		
}