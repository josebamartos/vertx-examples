package net.otzarri.examples.vertx.rest.client;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.HttpRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.codec.BodyCodec;

public class MainVerticle extends AbstractVerticle {

	@Override
	public void start() {
		Router router = Router.router(vertx);
		
		router.get("/").handler(this::invokeGreet);
		
		vertx.createHttpServer()
		.requestHandler(router::accept)
		.listen(8081);
	}
	
	private void invokeGreet(RoutingContext rc) {
		WebClient client = WebClient.create(vertx);
		
		HttpRequest<JsonObject> request = client
		.get(8080, "localhost","/Vert.x%20client")
		.as(BodyCodec.jsonObject());

		request.send(ar -> {
			if (ar.failed()) {
				rc.fail(ar.cause());
			} else {
				rc.response().end(ar.result().body().encode());
			}
		});
	}
}