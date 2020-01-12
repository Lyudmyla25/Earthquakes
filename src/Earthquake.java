import java.util.ArrayList;

class Earthquake {
    String name;
    float dist;
    float lat;
    float lon;

    Earthquake(String name, float dist, float lat, float lon) {
        this.name = name;
        this.dist = dist;
        this.lat = lat;
        this.lon = lon;
    }

    int compare(Earthquake earthquake) {
        return -Float.compare(earthquake.dist, this.dist);
    }

    static void putInList(Earthquake earthquake, ArrayList<Earthquake> list) {
        if (isDuplicatedEarthquake(list, earthquake)) return;

        if (list.size() < 10) {
            list.add(earthquake);
        } else if (list.size() == 10 && earthquake.compare(list.get(9)) < 0) {
            list.set(9, earthquake);
        }

        list.sort(Earthquake::compare);
    }

    private static boolean isDuplicatedEarthquake(ArrayList<Earthquake> list, Earthquake earthquake) {
        for (Earthquake list_earthquake : list) {
            if (earthquake.lat == list_earthquake.lat && earthquake.lon == list_earthquake.lon) return true;
        }
        return false;
    }
}