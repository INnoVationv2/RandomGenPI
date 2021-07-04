package innovationV2.RandomGenPI;

import innovationV2.RandomGenPI.Utils.Utils;
import innovationV2.RandomGenPI.models.Address;
import innovationV2.RandomGenPI.models.City;
import innovationV2.RandomGenPI.models.User;
import innovationV2.RandomGenPI.models.Province;

import java.util.*;

public class Generator {
    private static final Random random = new Random();
    private static final List<Province> provinces;
    private static final List<String> familyNames, menNames, womenNames;

    static {
        provinces = Utils.getProvinces();
        familyNames = Utils.getFamilyNames();
        menNames = Utils.getMenNames();
        womenNames = Utils.getWomenNames();
    }

    private static int getRandNum(int end) {
        return random.nextInt(end);
    }

    public static String getRandUsername() {
        return String.valueOf((char) (getRandNum(26) + 'a')) +
                (char) (getRandNum(26) + 'a') +
                (char) (getRandNum(26) + 'a') +
                getRandPhone().substring(5);
    }

    public static Address getRandAddress() {
        Address address = new Address();
        Province province = provinces.get(getRandNum(provinces.size()));
        address.setProvince(province.getProvinceName());
        List<City> cities = province.getCities();//获得城市表
        City city = province.getCities().get(getRandNum(cities.size()));
        address.setCity(city.getCityName());
        ArrayList<String> districts = city.getDistricts();//获取区表
        address.setDistrict(districts.get(getRandNum(districts.size())));
        return address;
    }

    public static Integer getRandAge() {
        return getRandNum(40) + 18;
    }

    private static Integer getAge(Calendar date) {
        Calendar current = Calendar.getInstance();
        return current.get(Calendar.YEAR) - date.get(Calendar.YEAR);
    }

    public static String getRandSex() {
        return getRandNum(2) == 0 ? "男" : "女";
    }

    public static String getRandMaleName() {
        return getRandName("男");
    }

    public static String getRandFemaleName() {
        return getRandName("女");
    }

    private static String getRandName(String sex) {
        String lastName = familyNames.get(getRandNum(familyNames.size()));
        String firstName;
        if (sex.equals("男"))
            firstName = menNames.get(getRandNum(menNames.size()));
        else
            firstName = womenNames.get(getRandNum(womenNames.size()));
        return lastName.concat(firstName);
    }

    private static final String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    public static String getRandPhone() {
        String first = telFirst[getRandNum(telFirst.length)];
        String second = String.valueOf(getRandNum(9999) + 10000).substring(1);
        String third = String.valueOf(getRandNum(9999) + 10000).substring(1);
        return first + second + third;
    }

    public static Calendar getRandBirthDay() {
        Calendar calendar = Calendar.getInstance();
        int year = getRandNum(60) + 50;
        calendar.set(Calendar.YEAR, year + 1900);
        int month = getRandNum(12) + 1;
        calendar.set(Calendar.MONTH, month);
        int day = getRandNum(28) + 1;
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@qq.com,@163.com,@126.com".split(",");

    public static String getRandEmail() {
        StringBuilder email = new StringBuilder();
        for (int i = 0; i < getRandNum(5) + 8; i++)
            email.append(getRandNum(10));
        email.append(email_suffix[getRandNum(email_suffix.length)]);
        return email.toString();
    }

    public static User getRandPersonInfo() {
        User user = new User();
        user.setUsername(getRandUsername());
        user.setSex(getRandSex());
        user.setName(getRandName(user.getSex()));
        user.setBirthDay(getRandBirthDay());
        user.setAge(getAge(user.getBirthDay()));
        user.setAddress(getRandAddress());
        user.setPhone(getRandPhone());
        user.setEmail(getRandEmail());
        return user;
    }
}