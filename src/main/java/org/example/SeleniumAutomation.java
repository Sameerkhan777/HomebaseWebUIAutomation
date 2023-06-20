package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumAutomation {

    public static void main(String[] args) {

        System.out.println("Hello world from Sameer");
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver driver = new ChromeDriver(chromeOptions);

        // Navigate to the demoqa website
        driver.get("https://www.toolsqa.com/");

        driver.quit();
    }
}
