package June25th_Class_API;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab132 {
    @Parameters({"browser"})
    @Test
    public void startBrowser(String value){
        System.out.println("starting the browser");
        switch(value){
            case "firefox":
                System.out.println("starting the firefox browser");
                break;
            case "chrome":
                System.out.println("starting the chrome browser");
                break;
            case "ie":
                System.out.println("starting the internet browser");
                break;
            case "Safai":
                System.out.println("starting the safari browser");
                break;

            default:
                System.out.println("please change the browser, this browser doesn't exists");
                break;
        }
    }
}
