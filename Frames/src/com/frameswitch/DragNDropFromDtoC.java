package com.frameswitch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropFromDtoC {
	WebDriver driver;
	   
    @BeforeMethod
    public void openBrowser(){
        this.driver=new FirefoxDriver();
        driver.get("http://www.ankur.com/projects/FrameGlider/demo/simple/a.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
       
    }

    @AfterMethod
    public void closeBrowser(){
     this.driver.close();
    }
   
    @Test
    public void withinframeDC(){
        //.//*[@id='messages']
        WebElement mousedownDra3=driver.findElement(By.xpath(".//span[@id='messages']"));
        System.out.println(mousedownDra3.getText());
       
        WebElement iframeB=driver.findElement(By.xpath(".//*[@id='b']"));
        driver.switchTo().frame(iframeB);                       //switch to B
       
        WebElement iframeD=driver.findElement(By.xpath(".//*[@id='d']"));
        driver.switchTo().frame(iframeD);                        //switch to D
       
        WebElement Dra3=driver.findElement(By.xpath(".//*[@id='Dra3']"));    //ref for Dra3 fr-D
       
        Actions act=new Actions(driver);
        act.clickAndHold(Dra3);                //holding Dra3 from fr-D
       
        //driver.switchTo().frame(iframeB);       //switch to B
        driver.switchTo().defaultContent();
       
        WebElement iframeC=driver.findElement(By.xpath(".//*[@id='c']"));
        driver.switchTo().frame(iframeC);            //switching to Fr-C
        WebElement Dro2=driver.findElement(By.xpath(".//*[@id='Dro2']"));
       

       
        act.moveToElement(Dro2).release();  //
        //builder.release(Dro2);
        //action=builder.build();
        act.build().perform();
        driver.switchTo().frame(iframeB);
        driver.switchTo().defaultContent();
       
        String getTitle=driver.getTitle();
        System.out.println(getTitle);
       
       
       
    }

    

}
