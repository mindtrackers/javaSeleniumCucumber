package com.project.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    static WebDriver driver;
    static Properties p;
    

    public static String getConfigProperty(String propertyName) throws IOException{
        FileReader file = new FileReader("./src//main//resource//config.properties");
        p=new Properties();
        p.load(file);
        return p.getProperty(propertyName);
    }

    public static void initiateBrowser() throws IOException{
        if (getConfigProperty("executionENV").equalsIgnoreCase("local")){
            switch (getConfigProperty("browser")) {
                case "chrome": driver=new ChromeDriver(); break;
                case "firefox": driver=new FirefoxDriver(); break;
                case "MicrosoftEdge": driver=new EdgeDriver(); break;
                default: System.out.println("Browser not available");
            }
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("startttinggggggg browser");
        }
        else if (getConfigProperty("executionENV").equalsIgnoreCase("remote")) {
            DesiredCapabilities caps =new DesiredCapabilities();
            caps.setPlatform(Platform.WIN10);
            caps.setBrowserName(getConfigProperty("browser"));

            driver= new RemoteWebDriver(URI.create(getConfigProperty("gridURL")).toURL(), caps);
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        System.out.println("quittttinggggggggg");
        if (getDriver()!= null){
            getDriver().quit(); 
        }
    }
    
}
