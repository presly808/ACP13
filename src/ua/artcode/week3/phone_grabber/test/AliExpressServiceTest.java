package ua.artcode.week3.phone_grabber.test;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.artcode.week3.phone_grabber.domain.Phone;
import ua.artcode.week3.phone_grabber.service.AliExpressMainService;
import ua.artcode.week3.phone_grabber.service.AliExpressMainServiceImpl;

/**
 * Created by serhii on 28.05.16.
 */
public class AliExpressServiceTest {

    public static final String PHONE_PATH = "http://ru.aliexpress.com/item/Huawei-Honor-5X-Mobile-Phone-Octa-Core-1920x1080-5-5inch-FHD-4G-LTE-Smartphone-2G-RAM/1000000665198.html?spm=2114.03010108.3.3.6rrthW&ws_ab_test=searchweb201556_7,searchweb201602_4_10039_10017_10021_507_10022_10020_10009_10008_10018_10019_101,searchweb201603_6&btsid=dc50ef74-f811-46ba-933e-6c2b191c1082";
    public static AliExpressMainService service;

    @BeforeClass
    public static void beforeClass(){
        service = new AliExpressMainServiceImpl();
    }

    @Test
    public void loadPhone(){
        Phone phone = service.grab(PHONE_PATH);

    }


}
