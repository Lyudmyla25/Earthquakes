import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSON {
    static String getJSONName(JSONObject json) throws JSONException {
        return (String) json.getJSONObject("properties").get("title");
    }

    static Float getJSONLon(JSONObject json) throws JSONException {
        return Float.valueOf(json.getJSONObject("geometry").getJSONArray("coordinates").get(0).toString());
    }

    static Float getJSONLat(JSONObject json) throws JSONException {
        return Float.valueOf(json.getJSONObject("geometry").getJSONArray("coordinates").get(1).toString());
    }

    static boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}