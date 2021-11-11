package project.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    /*
    making our driver instance so that it is not reachable from outside of the class
    We make it static, we want to run it before everything else and we also we
    will use it in stating method
     */

//public static WebDriver driver;

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver() {

       /*
       creating reusable utility method  that will return same driver
       instance everytime we call it
        */
        if (driverPool.get() == null) {
            synchronized (Driver.class) {

           /*
           we read our browser type from configuration.properties file using
           .getProperty method we creating ConfigurationReader class
            */

                String browseType = ConfigurationReader.getProperty("browser");


           /*
           depending on the browser type our switch statement will
           determin to open specific type of browser/driver
            */
                switch (browseType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        // driver = new
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    // case "firefox":

                    //should be changed for driverPool as chrome
                    //   WebDriver.firefoxDriver().setUp();
                    //  driver = FirefoxDriver();
                    //    driver.manage().window().maximize();
                    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    //   break;

                    case "remote-chrome":
                        try {
                            String gridAddress = "54.147.215.133";//has to represent sever
                            URL url = new URL("http://" + gridAddress + ":4444/wd/hub");//always the same
                            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                            desiredCapabilities.setBrowserName("chrome");
                            driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

               /*
               Same driver instance will be returned every time we call Driver.getDriver(); method
                */


                }

            }
        }

            return driverPool.get();
        }




    /*
    this method makes sure we have some formof
     driver session or driver id has either null or not null it must exist
     */
        public static void closeDriver(){
            if(driverPool.get()!=null){
                driverPool.get().quit();
                driverPool.remove();
            }
        }
    }



