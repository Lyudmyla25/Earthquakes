class Distance {
    static float calculateDistanceBetweenTwoPoints(float lon1, float lat1, float lon2, float lat2) {
        float earthRadiusKm = 6371;

        float dLat = degreesToRadians(lat2 - lat1);
        float dLon = degreesToRadians(lon2 - lon1);

        lat1 = degreesToRadians(lat1);
        lat2 = degreesToRadians(lat2);

        float a = (float) (Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2));
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        return earthRadiusKm * c;
    }

    private static float degreesToRadians(float degrees) {
        return degrees * (float) Math.PI / 180;
    }
}