package StepDefinations;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;

public class TodoListSteps {
			
	
	WebDriver driver = null;
	
	@Given("user is on todos page")
	public void user_is_on_todos_page() {
	    System.out.println("Inside Step - user is on todos page");
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is:"+projectPath);   
	    System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/driver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS );
	    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS );
	    driver.manage().window().maximize();
	    driver.navigate().to("https://todomvc.com/examples/vue/#/all");
	}

	@When("user enters todo item")
	public void user_enters_todo_item() throws InterruptedException {
	    System.out.println("Inside Step - user enters todo item");
	    driver.findElement(By.xpath("/html/body/section/header/input")).sendKeys("test item1");
	    Thread.sleep(500);
	}

	@And("clicks on enter button")
	public void clicks_on_enter_button() throws InterruptedException {
	    System.out.println("Inside Step - clicks on enter button");
	    driver.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(500);

	}

	@Then("new item displayed on the todos list page")
	public void new_item_displayed_on_the_todos_list_page() throws InterruptedException {
	    System.out.println("Inside Step - new item displayed on the todos list page");
	    driver.getPageSource().contains("test item1");
	    Thread.sleep(500);	  

	}
	//-----------------------------------------------
	@When("user double click on todo item")
	public void user_double_click_on_todo_item() throws InterruptedException {
		Thread.sleep(500);
		System.out.println("Inside Step - user double click on todo item");
		driver.findElement(By.xpath("//label[(text() ='test item1'or.='test item1')]")).click();
	}

	@And("enter new item name")
	public void enter_new_item_name() throws InterruptedException {
		System.out.println("Inside Step - enter new item name");
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("/html/body/section/section/ul/li/div/label')]")); 
		act.doubleClick(ele).perform();
		driver.findElement(By.xpath("/html/body/section/section/ul/li/div/label')]")).sendKeys("test item11");
	    Thread.sleep(500);
	}

	@Then("update item name from todos list page")
	public void update_item_name_from_todos_list_page() throws InterruptedException {
		System.out.println("Inside Step - update item name from todos list page");
		 driver.getPageSource().contains("test item11");
		    Thread.sleep(500);
	    
	}
	
	//-----------------------------------------------
	@When("user enters todo item1")
	public void user_enters_todo_item1() throws InterruptedException {
	    System.out.println("Inside Step - user enters todo item");
	    driver.findElement(By.xpath("/html/body/section/header/input")).sendKeys("test item2");
	    Thread.sleep(500);
	}

	@And("clicks on enter button1")
	public void clicks_on_enter_button1() throws InterruptedException {
	    System.out.println("Inside Step - clicks on enter button");
	    driver.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.ENTER);
	    Thread.sleep(500);

	}

	@Then("new item displayed on the todos list page1")
	public void new_item_displayed_on_the_todos_list_page1() throws InterruptedException {
	    System.out.println("Inside Step - new item displayed on the todos list page");
	    driver.getPageSource().contains("test item2");
	    Thread.sleep(500);	
	}
	
	@When("user filter todo item by Active")
	public void user_filter_todo_item_by_active() {
		System.out.println("Inside Step - user filter todo item by Active");
	}

	@And("clicks on Active button")
	public void clicks_on_active_button() throws InterruptedException {
		System.out.println("Inside Step - clicks on Active button");
		driver.findElement(By.xpath("/html/body/section/footer/ul/li[2]/a")).click();
		Thread.sleep(500);
		  
	}

	@Then("Active todo items should be displayed excluded \\(Completed)")
	public void active_todo_items_should_be_displayed_excluded_completed() throws InterruptedException {
		System.out.println("Inside Step - Active todo items should be displayed excluded \\(Completed)");		
		boolean testitem1 = driver.getPageSource().contains("test item11");
		assertEquals(true, testitem1);
		boolean testitem2 = driver.getPageSource().contains("test item2");
		assertEquals(true, testitem2);
		Thread.sleep(500);
	}
	//-----------------------------------------------
	@When("user completed a todo item")
	public void user_completed_a_todo_item() {
		System.out.println("Inside Step - user completed a todo item");
	    
	}

	@And("clicks on the item checkbox")
	public void clicks_on_the_item_checkbox() {
		System.out.println("Inside Step - clicks on the item checkbox");
		driver.findElement(By.xpath("/html/body/section/section/ul/li[2]/div/input")).click();
	  
	}

	@Then("strikethrough the todo item")
	public void strikethrough_the_todo_item() {
		System.out.println("Inside Step - strikethrough the todo item");

	}

	@When("user filter todo item by Completed")
	public void user_filter_todo_item_by_completed() {
		System.out.println("Inside Step - user filter todo item by Completed");
		
	}

	@And("clicks on Completed button")
	public void clicks_on_completed_button() throws InterruptedException {
		System.out.println("Inside Step - clicks on Completed button");
		driver.findElement(By.xpath("/html/body/section/footer/ul/li[3]/a")).click();
		Thread.sleep(500);

	}

	@Then("Completed items should be displayed excluded \\(Active)")
	public void completed_items_should_be_displayed_excluded_active() throws InterruptedException {
		System.out.println("Inside Step - Completed items should be displayed excluded \\(Active)");
		boolean testitem1 = driver.getPageSource().contains("test item11");
		assertEquals(false, testitem1);
		boolean testitem2 = driver.getPageSource().contains("test item2");
		assertEquals(true, testitem2);
		Thread.sleep(500);
	  
	}
	
	//-----------------------------------------------

	@When("user filter todo item by ALL")
	public void user_filter_todo_item_by_all() {
		System.out.println("Inside Step - user filter todo item by ALL");

	}

	@And("clicks on ALL button")
	public void clicks_on_all_button() throws InterruptedException {
		System.out.println("Inside Step - clicks on ALL button");
		driver.findElement(By.xpath("/html/body/section/footer/ul/li[1]/a")).click();
		Thread.sleep(500);
	  
	}

	@Then("ALL todo items should be displayed included \\(Active\\/Completed)")
	public void all_todo_items_should_be_displayed_included_active_completed() throws InterruptedException {
		System.out.println("Inside Step - ALL todo items should be displayed included \\(Active\\/Completed)");
		boolean testitem1 = driver.getPageSource().contains("test item11");
		assertEquals(true, testitem1);
		boolean testitem2 = driver.getPageSource().contains("test item2");
		assertEquals(true, testitem2);
		Thread.sleep(500);
	    
	}
	
	//-----------------------------------------------

	@When("user clear completed item")
	public void user_clear_completed_item() {
		System.out.println("Inside Step - user clear completed item");
	  
	}

	@And("clicks on Clear Completed button")
	public void clicks_on_clear_completed_button() throws InterruptedException {
		System.out.println("Inside Step - clicks on Clear Completed button");
		driver.findElement(By.xpath("/html/body/section/footer/button")).click();
		Thread.sleep(500);
	  
	}

	@Then("Completed items should be removed from the list")
	public void completed_items_should_be_removed_from_the_list() throws InterruptedException {
		System.out.println("Inside Step - Completed items should be removed from the list");
		boolean testitem1 = driver.getPageSource().contains("test item11");
		assertEquals(true, testitem1);
		boolean testitem2 = driver.getPageSource().contains("test item2");
		assertEquals(false, testitem2);
		Thread.sleep(500);
	    
	}
	//-----------------------------------------------

	@When("user mouseover on todo item")
	public void user_mouseover_on_todo_item() throws InterruptedException {
		System.out.println("Inside Step - user mouseover on todo item");
		Actions action = new Actions(driver);
		WebElement element1 =  driver.findElement(By.xpath("//label[(text() ='test item11'or.='test item11')]"));
		 action.moveToElement(element1).build().perform();
		    Thread.sleep(500);	    
	}

	@And("clicks on x button")
	public void clicks_on_x_button() throws InterruptedException {
		System.out.println("Inside Step - clicks on x button");
		driver.findElement(By.xpath("/html/body/section/section/ul/li/div/button")).click();
		Thread.sleep(500);
	}
	
	@Then("item removed from todos list page")
	public void item_removed_from_todos_list_page() throws InterruptedException {
		System.out.println("Inside Step - item removed from todos list page");
		boolean testitem1 = driver.getPageSource().contains("test item11");
		assertEquals(false, testitem1);
		boolean testitem2 = driver.getPageSource().contains("test item2");
		assertEquals(false, testitem2);
		Thread.sleep(500);
		  driver.close();
		  driver.quit();
	    
	}

}

