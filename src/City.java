import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;


class City {
    final String URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";
    float lat;
    float lon;

    public City(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    void getTenClosestEarthquakes() throws IOException, JSONException {
        ArrayList<Earthquake> listOfEarthquakes = new ArrayList<>();
        float dist;

        java.net.URL oracle = new URL(URL);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
        String inputLine;

        inputLine = in.readLine();
        int startOfEarthquakes = inputLine.indexOf("[");
        inputLine = inputLine.substring(startOfEarthquakes + 1);

        while (inputLine != null && JSON.isJSONValid(inputLine)) {
            JSONObject json = new JSONObject(inputLine);

            dist = Distance.calculateDistanceBetweenTwoPoints(JSON.getJSONLon(json), JSON.getJSONLat(json), lon, lat);

            Earthquake earthquake = new Earthquake(JSON.getJSONName(json), dist, JSON.getJSONLat(json), JSON.getJSONLon(json));
            Earthquake.putInList(earthquake, listOfEarthquakes);

            inputLine = in.readLine();
        }

        in.close();

        for (Earthquake earthquake : listOfEarthquakes)
            System.out.println(earthquake.name + " || " + earthquake.dist);
    }
}
