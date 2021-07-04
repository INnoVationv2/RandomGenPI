package innovationV2.RandomGenPI.models;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.LinkedHashMap;
import java.util.List;

public class Province {
    @JSONField(name = "name")
    private String provinceName;
    @JSONField(name = "city")
    private List<LinkedHashMap<String, Object>> cit;
    private List<City> cities;

    public void clearTempData() {
        cit = null;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<LinkedHashMap<String, Object>> getCit() {
        return cit;
    }

    public void setCit(List<LinkedHashMap<String, Object>> cit) {
        this.cit = cit;
    }
}

