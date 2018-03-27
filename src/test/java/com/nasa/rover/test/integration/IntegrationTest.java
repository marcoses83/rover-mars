package com.nasa.rover.test.integration;

import com.nasa.rover.client.RestClient;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.service.Navigator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    private static RestClient client;

    @BeforeClass
    public static void loadConfig() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src/test/resources/config.properties")));

        String baseUrl = properties.getProperty("integrationtest.baseurl");
        client = new RestClient(baseUrl);
    }

    @Test
    public void postCommandSequenceShouldReturnStatus200() {
        Response response = client.postCommandSequence("83WRFFFLFRB");
        Rover expectedRover = new Rover(new Position(7, 5), CardinalPoint.NORTH, new Navigator());

        assertEquals(200, response.getStatus());
        //TODO
        //assertEquals(expectedRover, response.readEntity(Rover.class));
    }
}
