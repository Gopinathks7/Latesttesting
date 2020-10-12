package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class Simple 
{
@Test
public void testJar()
{
	String key="webdriver.chrome.driver";
	String value="/home/ubuntu/chromedriver";
	System.setProperty(key, value);
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--headless");
	WebDriver driver =new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	String title=driver.getTitle();
	System.out.println(title);
	driver.quit();
}

public static void main(String [] are)
{
	TestListenerAdapter t= new TestListenerAdapter();
	TestNG testng=new TestNG();
	testng.setTestClasses(new Class[]			{ 	Simple.class
			});
	testng.addListener(t);
	testng.run();
}
}
