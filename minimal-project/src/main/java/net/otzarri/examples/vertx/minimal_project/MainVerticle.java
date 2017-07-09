package net.otzarri.examples.vertx.minimal_project;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {
	
	@Override
	public void start() throws Exception {
		vertx.createHttpServer()
		.requestHandler(req -> {
			req.response().end("Hello from " + Thread.currentThread().getName());
		})
		.listen(config().getInteger("http.port", 8080));
		}
	}
