package service;

import java.util.HashMap;
import java.util.Map;

import org.brickred.socialauth.Profile;

import play.Application;
import utils.SocialUser;

public class SampleSocialAuthService extends SocialAuthService {

	private final Map<String, SocialUser> store = new HashMap<String, SocialUser>();
	
	public SampleSocialAuthService(Application app) {
		super(app);
	}

	public SocialUser createNew(Profile user) {
		return new UserModel(user);
	}

	protected void doSave(SocialUser user) {
		if (user != null)
		{
			String key = user.getUserKey();
			store.put(key, user);
		}
	}

	protected void doSave(String key, SocialUser user) {
		if (user != null && key != null)
		{
			store.put(key, user);
		}
	}

	public SocialUser find(String key) {
		return store.get(key);
	}

}
