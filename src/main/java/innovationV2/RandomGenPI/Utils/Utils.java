package innovationV2.RandomGenPI.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import innovationV2.RandomGenPI.models.City;
import innovationV2.RandomGenPI.models.Province;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Utils {
    private static final SourceInputUtils sourceInputUtils = new SourceInputUtils();

    public static List<Province> getProvinces() {
        List<Province> provinces;
        String file = sourceInputUtils.parseFileToString("Address.json");
        provinces = JSON.parseArray(file, Province.class);
        for (Province province : provinces) {//循环处理每个省
            ArrayList<City> cities = new ArrayList<>();
            for (LinkedHashMap<String, Object> c : province.getCit())//处理每个市
                cities.add(map2City(c));
            province.setCities(cities);
            province.clearTempData();
        }
        return provinces;
    }

    private static City map2City(LinkedHashMap<String, Object> c) {
        City city = new City();//新建一个City类用户返回
        city.setCityName((String) c.get("name"));//设置市名
        JSONArray dis = (JSONArray) c.get("area");//获取市地下的县区
        ArrayList<String> districts = new ArrayList<>();//初始化存储区的线性表
        for (Object di : dis) districts.add((String) di);//将区放进去
        city.setDistricts(districts);
        return city;
    }

    public static List<String> getFamilyNames() {
        List<String> familyName;
        String source = sourceInputUtils.parseFileToString("FamilyName.txt");
        familyName = Arrays.asList(source.split(","));
        return familyName;
    }

    public static List<String> getMenNames() {
        List<String> menName;
        String source = sourceInputUtils.parseFileToString("MenName.txt");
        menName = Arrays.asList(source.split(","));
        return menName;
    }

    public static List<String> getWomenNames() {
        List<String> womenName;
        String source = sourceInputUtils.parseFileToString("WomenName.txt");
        womenName = Arrays.asList(source.split(","));
        return womenName;
    }
}
