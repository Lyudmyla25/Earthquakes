import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

abstract class Position {
    float lat;
    float lon;

    public Position(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    abstract ArrayList<Earthquake> getTenClosestEarthquakes() throws IOException, JSONException;

    abstract void printListOfClosestEarthquakes() throws IOException, JSONException;
}
