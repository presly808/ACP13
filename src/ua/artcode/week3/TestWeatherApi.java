package ua.artcode.week3;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by serhii on 28.05.16.
 */
public class TestWeatherApi {


    public static void main(String[] args) throws URISyntaxException, IOException {
        URI uri = new URI("http://api.openweathermap.org/data/2.5/forecast?q=London,us&mode=json&APPID=afb13b5f78c377d21e0962a07c2a3ecc");
        URL url = uri.toURL();
        InputStream inputStream = url.openStream();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();

        String line = "";

        while((line = bufferedReader.readLine()) != null){
            sb.append(line);
        }

        String json = sb.toString();

        Gson gson = new Gson();
        // gson.fromJson(json, Class)

        System.out.println();



    }
}
