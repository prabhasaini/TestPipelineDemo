package PkgTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class TestNGClass {

    WebDriver driver;

    @Test(groups = "test1", priority = 0)
    @Parameters({"browser","url"})
    public void SetUp(String browser, String url){
    if(browser.equalsIgnoreCase("chrome")){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    else if(browser.equalsIgnoreCase("edge")){
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }}
    @Test(groups = "test1", priority = 1)
    public void Enter_Username(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        System.out.println("1 method");
    }
   @Test(groups = "test2",priority = 2)
    public void Enter_Password(){
        driver.findElement(By.name("password")).sendKeys("admin123");
        System.out.println("2 method");
    }
    @Test(groups="test2",priority = 3)
    public void Click_LoginBtn(){
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
        System.out.println("3 method");
        WebElement Text = driver.findElement(By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]"));
        Assert.assertEquals(Text.getText(),"Dashboard");
    }
    @Test(groups="test3", priority = 4)
    public void tear_down(){
        driver.quit();
        System.out.println("4 method");
        System.out.println("Git Test");
    }

}