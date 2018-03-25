package com.nasa.rover.api;

import com.google.gson.Gson;
import com.nasa.rover.helper.CommandParser;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.Movement;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class RestVerticle extends AbstractVerticle {
    private Rover rover;
    public static void main(String[] args) {
        Launcher.executeCommand("run", RestVerticle.class.getName());
    }

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.get("/rover").handler(this::handleGetRover);
        router.post("/rover/command").handler(this::handlePostCommand);
        router.post("/rover/command/sequence").handler(this::handlePostCommandSequence);

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(8080);
    }

    private void handleGetRover(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        if (rover != null) {
            response.putHeader("content-type", "application/json").setStatusCode(200).end(new Gson().toJson(this.rover));
        } else {
            sendError(404, response);
        }
    }

    private void handlePostCommand(RoutingContext routingContext) {
        String command = routingContext.getBodyAsString();
        HttpServerResponse response = routingContext.response();

        if (command == null || command.length() != 1 || Movement.getName(command.charAt(0)) == null) {
            sendError(400, response);
        } else {
            if (this.rover == null) {
                sendError(404, response);
            } else {
                //TODO: improve. Move CommandParser usage inside Rover class
                rover.move(command);
                response.putHeader("content-type", "application/json").setStatusCode(200).end(new Gson().toJson(this.rover));
            }
        }
    }

    private void handlePostCommandSequence(RoutingContext routingContext) {
        String commandSequence = routingContext.getBodyAsString();
        HttpServerResponse response = routingContext.response();

        if (commandSequence == null) {
            sendError(400, response);
        } else {
            //TODO: improve. Move CommandParser usage inside Rover class
            this.rover = new CommandParser().parse(commandSequence);

            if (this.rover == null) {
                sendError(400, response);
            } else {
                //TODO: improve. Move CommandParser usage inside Rover class
                rover.move(commandSequence.substring(3));
                response.putHeader("content-type", "application/json").setStatusCode(200).end(new Gson().toJson(this.rover));
            }
        }
    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }
}