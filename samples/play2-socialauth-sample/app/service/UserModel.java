package service;

import java.util.Date;

import org.brickred.socialauth.Profile;

import utils.SocialUser;
/** this could be a USer data/model object */  
public class UserModel implements SocialUser {

	private String userKey;
	private Profile profile;
	private Date birthDate;
	private int loginCount;
	private Date lastLogin;

	
	public UserModel(Profile profile) {
		super();
		this.profile = profile;
		if (profile != null)
			userKey = profile.getProviderId() + profile.getValidatedId();
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
