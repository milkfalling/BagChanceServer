package web.member.bean;

import java.io.Serializable;
import java.security.Timestamp;

public class user implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String mail;
	private String phone;
	private String password;
	private String nickname;
	private Boolean gender;
	private Timestamp birthday;
	private String EXPLORE_AREA;
	private String PROFILE_PIC;
	private String PROFILE_INTRO;
	private String USER_STATUS;
	private Timestamp CREATE_DATE;
	private Timestamp LAST_UPDATE_DATE;
	private String TOKEN_GOOGLE;
	private String TOKEN_FACEBOOK;
	
	
	
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
	public String getEXPLORE_AREA() {
		return EXPLORE_AREA;
	}
	public void setEXPLORE_AREA(String eXPLORE_AREA) {
		EXPLORE_AREA = eXPLORE_AREA;
	}
	public String getPROFILE_PIC() {
		return PROFILE_PIC;
	}
	public void setPROFILE_PIC(String pROFILE_PIC) {
		PROFILE_PIC = pROFILE_PIC;
	}
	public String getPROFILE_INTRO() {
		return PROFILE_INTRO;
	}
	public void setPROFILE_INTRO(String pROFILE_INTRO) {
		PROFILE_INTRO = pROFILE_INTRO;
	}
	public String getUSER_STATUS() {
		return USER_STATUS;
	}
	public void setUSER_STATUS(String uSER_STATUS) {
		USER_STATUS = uSER_STATUS;
	}
	public Timestamp getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(Timestamp cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public Timestamp getLAST_UPDATE_DATE() {
		return LAST_UPDATE_DATE;
	}
	public void setLAST_UPDATE_DATE(Timestamp lAST_UPDATE_DATE) {
		LAST_UPDATE_DATE = lAST_UPDATE_DATE;
	}
	public String getTOKEN_GOOGLE() {
		return TOKEN_GOOGLE;
	}
	public void setTOKEN_GOOGLE(String tOKEN_GOOGLE) {
		TOKEN_GOOGLE = tOKEN_GOOGLE;
	}
	public String getTOKEN_FACEBOOK() {
		return TOKEN_FACEBOOK;
	}
	public void setTOKEN_FACEBOOK(String tOKEN_FACEBOOK) {
		TOKEN_FACEBOOK = tOKEN_FACEBOOK;
	}
	
	
	
	
}
