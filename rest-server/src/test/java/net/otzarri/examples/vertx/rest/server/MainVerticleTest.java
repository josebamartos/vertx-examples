package net.otzarri.examples.vertx.rest;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import net.otzarri.examples.vertx.rest.MainVerticle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class MainVerticleTest {

	private Vertx vertx;

	@Before
	public void setup(TestContext context) {
		vertx = Vertx.vertx();
		vertx.deployVerticle(MainVerticle.class.getName(),
				context.asyncAssertSuccess());
	}

	@After
	public void tearDown(TestContext context) {
		vertx.close(context.asyncAssertSuccess());
	}

	@Test
	public void myAppTest(TestContext context) {
	}
}
