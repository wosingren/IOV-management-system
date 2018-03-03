public class LatLng {

    public double latitude;
    public double longitude;

    public LatLng(double longitude , double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LatLng(String longitude, String latitude) {

        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
    }
}
