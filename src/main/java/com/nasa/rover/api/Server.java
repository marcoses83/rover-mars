package com.nasa.rover.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;

public class Server extends AbstractVerticle {
    public static void main(String[] args) {
        Launcher.executeCommand("run", Server.class.getName());
    }

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x!");
        }).listen(8080);
    }
}