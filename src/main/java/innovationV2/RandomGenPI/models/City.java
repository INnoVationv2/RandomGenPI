package innovationV2.RandomGenPI.models;

import java.util.ArrayList;

public class City {
    private String cityName;
    private ArrayList<String> districts;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public ArrayList<String> getDistricts() {
        return districts;
    }

    public void setDistricts(ArrayList<String> districts) {
        this.districts = districts;
    }
}
