package com.nasa.rover.api;

import com.nasa.rover.helper.CommandParser;
import com.nasa.rover.model.Rover;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class Server extends AbstractVerticle {
    public static void main(String[] args) {
        Launcher.executeCommand("run", Server.class.getName());
    }

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.get("/commands/:commandSequence").handler(this::handleGetProduct);

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }

    private void handleGetProduct(RoutingContext routingContext) {
        String commandSequence = routingContext.request().getParam("commandSequence");
        HttpServerResponse response = routingContext.response();
        if (commandSequence == null) {
            sendError(400, response);
        } else {
            //TODO: parse commands
            Rover rover = new CommandParser().parse(commandSequence);

            if (rover == null) {
                sendError(404, response);
            } else {
                response.putHeader("content-type", "application/json").setStatusCode(200).end(rover.getPosition().toString());
            }
        }
    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }
}