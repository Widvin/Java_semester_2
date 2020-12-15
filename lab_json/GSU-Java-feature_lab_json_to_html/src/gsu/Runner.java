package gsu;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static Map<String, Object> jsonToMap(String str){
        return new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
    }


    public static void main(String[] args) {
        String apiKey = "1b2af87acfd89dea6b1d35e536a3b10e";
        String location = "London";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey +
                "&units=metric";

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null){
                result.append(line);
            }
            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());

            Map<String, Object> weatherMap = (Map<String, Object>) ((List<Object>) respMap.get("weather")).get(0);
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
            Map<String, Object> cloudsMap = jsonToMap(respMap.get("clouds").toString());
            Map<String, Object> sysMap = jsonToMap(respMap.get("sys").toString());

            String city = respMap.get("name").toString();
            String country = sysMap.get("country").toString();
            String iconCode = weatherMap.get("icon").toString();
            String shortDescription = weatherMap.get("main").toString();
            String longDescription = weatherMap.get("description").toString();
            double temperature = (double) mainMap.get("temp");
            double pressure = (double) mainMap.get("pressure");
            double humidity = (double) mainMap.get("humidity");
            double minTemperature = (double) mainMap.get("temp_min");
            double maxTemperature = (double) mainMap.get("temp_max");
            double windSpeed = (double) windMap.get("speed");
            double windDirection = (double) windMap.get("deg");
            double cloudinessPercents = (double) cloudsMap.get("all");

            Weather weather = new Weather(city, country, iconCode, shortDescription, longDescription, temperature,
                    pressure, humidity, minTemperature, maxTemperature, windSpeed, windDirection, cloudinessPercents);

            System.out.println(weather);

            weather.createHtmlReport();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
