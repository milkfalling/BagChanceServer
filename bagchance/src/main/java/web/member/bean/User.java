package web.member.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String mail;
	private String phone;
	private String password;
	private String nickname;
	private Boolean gender;
	private Timestamp birthday;
	private String explore_area;
	private String profile_pic;
	private String profile_intro;
	private String user_status;
	private Timestamp create_date;
	private Timestamp last_update_date;
	private String token_google;
	private String token_facebook;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	public String getExplore_area() {
		return explore_area;
	}
	public void setExplore_area(String explore_area) {
		this.explore_area = explore_area;
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getProfile_intro() {
		return profile_intro;
	}
	public void setProfile_intro(String profile_intro) {
		this.profile_intro = profile_intro;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(Timestamp last_update_date) {
		this.last_update_date = last_update_date;
	}
	public String getToken_google() {
		return token_google;
	}
	public void setToken_google(String token_google) {
		this.token_google = token_google;
	}
	public String getToken_facebook() {
		return token_facebook;
	}
	public void setToken_facebook(String token_facebook) {
		this.token_facebook = token_facebook;
	}
	
	
}
	