package ua.artcode.week3.phone_grabber.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * //div[class='image']/img
 */
public class Phone {

    private String name;
    private String price;
    private String imageUrl;
    private Map<String, String> properties;

    public Phone() {
        properties = new HashMap<>();

    }

    public Phone(String name, String imageUrl,String price, Map<String, String> properties) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
