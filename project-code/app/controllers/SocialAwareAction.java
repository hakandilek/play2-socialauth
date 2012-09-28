package controllers;

import play.Logger;
import play.Logger.ALogger;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import utils.SocialUser;
import utils.SocialUtils;

public class SocialAwareAction extends Action<SocialAware> {

	private static ALogger log = Logger.of(SocialAwareAction.class);

	@Override
	public Result call(Context ctx) throws Throwable {
		if (log.isDebugEnabled())
			log.debug("call() <-");
		SocialUser user = SocialUtils.currentUser(ctx);
		if (log.isDebugEnabled())
			log.debug("user : " + user);
		if (user != null) {
			ctx.args.put(SocialLogin.USER_KEY, user);
		}
		if (log.isDebugEnabled())
			log.debug("calling delegate action");
		return delegate.call(ctx);
	}
	
}
