package ua.artcode.week3.phone_grabber.service;

import ua.artcode.week3.phone_grabber.domain.Phone;

import java.util.List;

/**
 * Created by serhii on 28.05.16.
 */
public interface AliExpressMainService {

    List<Phone> find(String name);

    Phone grab(String url);



}
