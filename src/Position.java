import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

abstract class Position {
    float lat;
    float lon;
    ArrayList<Earthquake> listOfEarthquakes = new ArrayList<>();

    public Position(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    abstract ArrayList<Earthquake> getTenClosestEarthquakes() throws IOException, JSONException;

    void printListOfClosestEarthquakes() throws IOException, JSONException {
        listOfEarthquakes = getTenClosestEarthquakes();

        for (Earthquake earthquake : listOfEarthquakes)
            System.out.println(earthquake.name + " || " + earthquake.dist);
    }
}
