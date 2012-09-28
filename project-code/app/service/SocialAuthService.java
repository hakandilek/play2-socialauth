package service;

import java.util.Date;

import org.brickred.socialauth.Profile;

import play.Application;
import play.Logger;
import play.Logger.ALogger;
import play.api.Plugin;
import utils.SocialUser;

public abstract class SocialAuthService implements Plugin {
	
	private static ALogger log = Logger.of(SocialAuthService.class);

	private static SocialAuthService instance;// plugin instance

	public SocialAuthService(Application app) {
		if (log.isInfoEnabled())
			log.debug(getClass().getSimpleName() + " created.");
	}

	public void save(String userKey, Profile profile) {
		if (log.isDebugEnabled())
			log.debug("save() <-");
		if (log.isDebugEnabled())
			log.debug("userKey : " + userKey);
		if (log.isDebugEnabled())
			log.debug("profile : " + profile);
		
		SocialUser user = find(userKey);
		
		if (user != null) {
			user.setLoginCount(user.getLoginCount() + 1);
			user.setLastLogin(new Date());
			doSave(userKey, user);
		} else {
			user = createNew(profile);
			doSave(user);
		}
		
		if (log.isDebugEnabled())
			log.debug("saved user profile.");
	}

	public abstract SocialUser createNew(Profile profile);

	protected abstract void doSave(SocialUser user);

	protected abstract void doSave(String userKey, SocialUser user);

	public abstract SocialUser find(String userKey);

	@Override
	public boolean enabled() {
		return true;
	}

	@Override
	public void onStart() {
		instance = this;
		if (log.isInfoEnabled())
			log.debug(getClass().getSimpleName() + " started and associated as SocialUserService.");

	}

	@Override
	public void onStop() {
		instance = null;
		if (log.isInfoEnabled())
			log.debug(getClass().getSimpleName() + " stopped and disassociated as SocialUserService.");
	}

	public static SocialAuthService getInstance() {
		return instance;
	}

}
