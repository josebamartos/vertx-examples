package net.otzarri.examples.vertx.rest.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {

	@Override
	public void start() {
		Router router = Router.router(vertx);
		
		// Response using RoutingContext directly
		//router.get("/").handler(rc -> rc.response().end("hello"));
		//router.get("/:name").handler(rc -> rc.response().end("hello " + rc.pathParam("name")));
		
		// Response using method as handler
		router.get("/").handler(this::greet);
		router.get("/:name").handler(this::greet);
		
		vertx.createHttpServer()
			.requestHandler(router::accept)
			.listen(8080);
	}
	
	private void greet(RoutingContext rc) {
		String message = "Hello";
		if (rc.pathParam("name") != null) {	message += " " + rc.pathParam("name"); }
		JsonObject json = new JsonObject().put("message", message);
		
		rc.response()
			.putHeader(HttpHeaders.CONTENT_TYPE, "application/json")
			.end(json.encode());
	}
}