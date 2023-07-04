package MakeMyTrip;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




import io.github.bonigarcia.wdm.WebDriverManager;

public class M_M_trip {
	 WebDriver driver;
	  Actions act;
	  JavascriptExecutor jav;
@BeforeTest
public void BT() {
	  WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();    
    driver.get("https://www.makemytrip.com");
    driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
}
@Test(enabled = true )
public void test() throws InterruptedException {
	
	driver.findElement(By.xpath("(//*[@class='menu_Holidays removeItemMargin'])")).click();
	driver.findElement(By.xpath("//*[@for='fromCity']")).click();
	driver.findElement(By.xpath("(//*[@class='font14 blackText appendBottom6 autoSuggestValue'])[3]")).click();
//	driver.findElement(By.xpath("(//*[@class='lbl_input latoBold makeFlex column'])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("toCity")).click();
	Thread.sleep(3000);
//	driver.findElement(By.className("(//*[@class='dest-city-container'])[1]")).click();
//	driver.findElement(By.linkText("Singapore")).click();
//	  driver.findElement(By.xpath("//*[@class='dest-search-container']/input")).sendKeys("Singapore");
//	  driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("Singapore");
//    driver.findElement(By.className("dest-search-input")).sendKeys("Singapore");
//    driver.findElement(By.xpath("//*[@class='dest-search-input']")).sendKeys("Singapore");
//   WebElement sgp = driver.findElement(By.className("dest-city-name"));
//   Thread.sleep(3000);
//   Actions act=new Actions(driver);
//   act.click(sgp).build().perform();
    driver.findElement(By.className("dest-search-input")).sendKeys("Singapore");
    Thread.sleep(2000);
    WebElement SGP = driver.findElement(By.className("dest-city-name"));
    Actions act=new Actions(driver);
    act.click(SGP).build().perform();
//    driver.findElement(By.xpath("//*[@class='DayPicker-Day DayPicker-Day--selected']")).click();
    driver.findElement(By.xpath("//*[@aria-label='Fri Jun 30 2023']")).click();
    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@class='applyBtn']")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button[class='action']")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("search_button")).click();
    Thread.sleep(8000);
    driver.findElement(By.xpath("//*[@class='nextBtn']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@class='skipBtn']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[@class='close closeIcon']")).click();
    Thread.sleep(2000);
    JavascriptExecutor jav=(JavascriptExecutor)driver;
    Thread.sleep(10000);
    jav.executeScript("window.scrollBy(0,1250);");
    Thread.sleep(5000);
    jav.executeScript("window.scrollBy(0,1100);");
  
}
   @Test(dependsOnMethods = "test()")
   public void select() throws InterruptedException {
	   Thread.sleep(5000);
	 WebElement sec = driver.findElement(By.xpath("(//*[@class='sliderCardShadow'])[1]"));
	 Actions act=new Actions(driver);
      act.click(sec).build().perform();
      Set<String> handles = driver.getWindowHandles();

      Iterator<String> values = handles.iterator();

      while (values.hasNext()) {
          String parentWindow = values.next();
          driver.switchTo().window(parentWindow);
          String childWindow = values.next();
          driver.switchTo().window(childWindow);
          driver.findElement(By.xpath("//*[@class='skipBtn']")).click();

          WebElement changeRoom = driver.findElement(By.xpath("(//*[@id='change'])[4]"));

          Thread.sleep(2000);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          // js.executeScript("arguments[0].scrollIntoView(true);", changeRoom);
          // Thread.sleep(3000);

          js.executeScript("window.scrollTo(0,150)");
          act.click(changeRoom).build().perform();

          Thread.sleep(8000);

          driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click();
          Thread.sleep(3000);

          String ActualchangeHotelName = driver.findElement(By.xpath("//*[text()='Citadines Connect City Centre Holiday Selection']")).getText();
                  
          System.out.println(ActualchangeHotelName);
          Thread.sleep(4000);

          driver.findElement(By.xpath("(//*[@class='updatePackageBtnText font10'])[1]")).click();
          String changeHotelName = driver.findElement(By.xpath("//*[text()='Citadines Connect City Centre Holiday Selection']")).getText();
                  

          Assert.assertEquals(ActualchangeHotelName, changeHotelName);
          System.out.println(changeHotelName);

          driver.findElement(By.id("chooseAndAddBtn")).click();

          String addedActivity1 = driver.findElement(By.xpath("(//*[@class='activityHeading'])[1]")).getText();

          Thread.sleep(5000);

          driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[1]")).click();

          driver.findElement(By.xpath("(//*[@class='updatePackageBtnWrapper btn'])[1]")).click();
          Thread.sleep(5000);
          String iteneraryRoomName = driver .findElement(By.xpath("//*[text()='Citadines Connect City Centre Holiday Selection']")).getText();
          Thread.sleep(2000);    
          Assert.assertEquals(iteneraryRoomName, ActualchangeHotelName);
          Thread.sleep(2000);

          driver.findElement(By.xpath("//ul[@id='initeraryNav']//li[3]")).click();
          Thread.sleep(2000);
          String hotelDetails = driver .findElement(By.xpath("//*[text()='Citadines Connect City Centre Holiday Selection']")).getText();
          Thread.sleep(2000);      
          Assert.assertEquals(iteneraryRoomName, hotelDetails);
          Thread.sleep(2000);
          driver.findElement(By.xpath("//ul[@id='initeraryNav']//li[5]")).click();
          Thread.sleep(2000);
          String activityAdded=driver.findElement(By.xpath("(//*[@class='activity-row-details-title'])[1]")).getText();
          Thread.sleep(2000);
          Assert.assertEquals(addedActivity1, activityAdded);
          System.out.println("sucessfully registered");
          driver.close();
          }
}
}

