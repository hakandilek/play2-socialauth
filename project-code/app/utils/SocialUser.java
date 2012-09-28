package utils;

import java.util.Date;

import org.brickred.socialauth.Profile;

public interface SocialUser {

	String getUserKey();

	Profile getProfile();

	Date getBirthDate();

	int getLoginCount();

	void setLoginCount(int i);

	void setLastLogin(Date date);

}