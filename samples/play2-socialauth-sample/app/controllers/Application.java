package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	/** User aware page, with optinal authentication */
	public static Result user() {
		return ok(index.render("This is a user aware page"));
	}

	/** A Secure page, requiring authentication */
	public static Result secure() {
		return ok(index.render("This is an authenticated page"));
	}
}