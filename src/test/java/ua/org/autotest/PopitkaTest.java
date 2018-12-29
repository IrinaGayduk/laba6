package ua.org.autotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static junit.framework.TestCase.assertTrue;

public  class PopitkaTest {
    protected WebDriver driver;
    private String _url = "https://rozetka.com.ua/";


    @Before
    public void openTheBrowser() {
        String exePath = "D:\\КПИ\\3 курс\\Тестировка\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.get(_url);

    }

    @After
    public void closeTheBrowser() {
        driver.quit();
    }

    @Test
    public void checkYouCanBuyItem() {
        RozetkaTest page = new RozetkaTest(driver);

        page.searchItem("Блокнот");
       page.SetMinimumPrice(100);
       page.SetMaximumPrice(2000);
       page.submitPriceFilter();

       page.SetManufacturer();
        TsenaTest buyPage = new TsenaTest(driver);
        buyPage.fillContactInfo();
        assertTrue(buyPage.purchaseItem());
    }

}

