import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {

        Scanner input = new Scanner(System.in);
        float lat = input.nextFloat();
        float lon = input.nextFloat();

        City city = new City(lat, lon);

        city.printListOfClosestEarthquakes();
    }
}
