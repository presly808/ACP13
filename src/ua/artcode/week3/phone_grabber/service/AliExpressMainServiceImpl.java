package ua.artcode.week3.phone_grabber.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ua.artcode.week3.phone_grabber.domain.Phone;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Created by serhii on 28.05.16.
 */
public class AliExpressMainServiceImpl implements AliExpressMainService {


    @Override
    public List<Phone> find(String name) {
        return null;
    }

    @Override
    public Phone grab(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            // css selector <tag id="go" class="button">
            // by id '#go'  class '.button'
            Element productNameEl = document.select(".product-name").first();
            String productName = productNameEl.text();

            Element imageElement = document.select(".ui-image-viewer-thumb-frame img").first();

            String imageUrl = imageElement.attr("src");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
