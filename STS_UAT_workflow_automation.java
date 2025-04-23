package intro1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class STS_UAT_workflow_automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String username = "<NHI Bataunga>";
		String password = "<NIKAL>";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // globally applicable for each step

		driver.manage().window().maximize(); // maximize window

		// -----------------------------------------------------  login - Dashboard -------------------------------------------------------------

		driver.get("https://uat.naehas.com/WellsFargoUATDashboard/home");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn-primary']")).click();
		Thread.sleep(10000);
		
		// ---------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		// ---------------------------------------------------- DAM Metadata Validation  ---------------------------------------------------------
		
		
		
		// NDrive → Shared Content → Stock the Shelves → Home Lending Content Blocks →> Home Lending → HPLP → HPLP - Headline
//		
//		driver.findElement(By.xpath("//a[@aria-label='DAM']//span[@class='ItemIcon']")).click(); // click on DAM	
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@title='Reset']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[@title='Shared Content']")).click(); // -> Shared content
//		Thread.sleep(3000);
//		// Locate the element -> Stock the shelves and click
//		WebElement sts_btn = driver.findElement(By.xpath("//span[@title='Stock the Shelves']"));
//		// Scroll into view
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sts_btn);
//		// Click the element
//		sts_btn.click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[@title='Home Lending Content Blocks']")).click(); // -> Home Lending Content Block
//		Thread.sleep(3000);																				
//		// Locate the element -> Home lending
//		WebElement home_lending_btn = driver.findElement(By.xpath("//span[@title='Home Lending']"));
//		// Scroll into view
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",home_lending_btn);
//		// Click the element
//		home_lending_btn.click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//span[@title='HPLP']")).click(); // HPLP
//		//Locate the element --> HPLP - Headline
//	    WebElement headline_btn = driver.findElement(By.xpath("//span[@title='HPLP - Headline']"));
//	    // Scroll into view
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headline_btn);
//	    // Click the element
//	    headline_btn.click();
//	    Thread.sleep(3000);
//	    driver.findElement(By.xpath("//span[contains(text(), 'HL_Act now before mortgage rates rise')]")).click(); // clicking on content block
//		driver.findElement(By.xpath("//button[@data-testid='Info/Details']")).click(); // click on i button
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[@title='Edit']")).click();  // Metadata button
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@title='Save']")).click(); // save
//		Thread.sleep(3000);
		
		System.out.println("\n✅ Navigate to  HPLP -> Headline checked \n➡️ NDrive → Shared Content → Stock the Shelves → Home Lending Content Blocks → Home Lending → HPLP → HPLP - Headline\n");
		
		
		
		// -----------------------------------------------------------------------------------------------------------------------------------------

		// NDrive → Shared Content → Stock the Shelves → NaehasTest
		
		driver.findElement(By.xpath("//a[@aria-label='DAM']//span[@class='ItemIcon']")).click(); // click on DAM	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@title='Reset']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='Shared Content']")).click(); // -> Shared content
		Thread.sleep(3000);
		//Scroll and click on Stock the Shelves
		WebElement sts_btn_2 = driver.findElement(By.xpath("//span[@title='Stock the Shelves']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sts_btn_2);
		sts_btn_2.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'NaehasTest')]")).click(); // -> NaehasTest
		Thread.sleep(3000);
		
		System.out.println("\n✅ Navigate to NaehasTest \n➡️ NDrive → Shared Content → Stock the Shelves → NaehasTest\n");

		
		
		//------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		//---------------------------------------------------------- Making a new Headline Block ----------------------------------------------------
		
		System.out.println("\n➡️ Making a new content block");
		driver.findElement(By.xpath("//div[@class='sc-jcpbFC bsbeLx']")).click(); // Click on + New 	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='New Content Block']")).click(); 	// Click on "New Content Block"

		// Assigning content block name
		String content_block_name = "Headline_Content_Block_Test_KM_Dummy_Block_Selenium";
		String main_content = "A - This is a Dummy Headline KM";
		Thread.sleep(2000);

		// Switch to TinyMCE iframe before entering content
		WebElement iframe_content_block = driver.findElement(By.xpath("//iframe[contains(@class, 'tox-edit-area__iframe')]")); 
		driver.switchTo().frame(iframe_content_block);

		// Now, find the TinyMCE body and enter text
		WebElement editorBody = driver.findElement(By.xpath("//body[@id='tinymce']")); 
		editorBody.clear();  // Clear existing content if needed
		editorBody.sendKeys(main_content);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();// Switch back to the main page
		
		// Entering content block name and saving the content block
		driver.findElement(By.xpath("//input[@name='Content Block Name']")).sendKeys(content_block_name);
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click(); // save button
		Thread.sleep(3000);
		
		// assigning field in metadata tab
		driver.findElement(By.xpath("//span[normalize-space()='Headline_Content_Block_Test_KM_Dummy_Block_Selenium']")).click(); // click ont the content block
		driver.findElement(By.xpath("//button[@data-testid='Info/Details']")).click(); // click on i button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Edit']")).click(); // Metadata edit
		Thread.sleep(3000);
		
		System.out.println("\n✅ Content Block Creation -> Done");


		
		//********** Adding values to metadata ***********
		// 1 - Linked Asset: HPLP
		// 2 - blockType: Headline
		// 3 - Message Category: Purchase - General
		// 4 - LOB: Home Lending
		// 5 - Campaign: Home Lending
		
		
		// 1 - Linked Asset: HPLP
		
		WebElement linkedAssetField = driver.findElement(By.xpath("//input[@name='Linked Asset']"));
		linkedAssetField.clear();
		Thread.sleep(2000);
		String text = "HPLP";
		for (char c : text.toCharArray()) {
		    linkedAssetField.sendKeys(String.valueOf(c));
		    Thread.sleep(100); // Small delay between characters
		}
		Thread.sleep(2000);  // Ensure it processes the inputs
		System.out.println("\n✅ HPLP Selected in Linked Asset");
		
		
		// 2 - blockType: Headline
		
		WebDriverWait blockType_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Locate the dropdown input field
		WebElement blockType_dropdown = blockType_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='blockType']/following-sibling::div[contains(@class, 'css-b62m3t-container')]")));
		// Click to open dropdown
		blockType_dropdown.click();
		// Wait for the dropdown options to be visible
		WebElement blockType_option = blockType_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Headline')]")));
		// Click the option
		blockType_option.click();
		Thread.sleep(2000);
	
		System.out.println("\n✅ Headline Selected in blockType");
		
		
		// 3 - Message Category: Purchase - General
		
		WebDriverWait message_Category_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Locate the dropdown input field
		WebElement message_Category_dropdown = message_Category_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Message Category']/following-sibling::div[contains(@class, 'css-b62m3t-container')]")));
		// Click to open dropdown
		message_Category_dropdown.click();
		// Wait for the dropdown options to be visible
		WebElement message_Category_option = message_Category_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Purchase - general')]")));
		// Click the option
		message_Category_option.click();		
		Thread.sleep(2000);
		System.out.println("\n✅ Purchase - General selected in Message Category");
		
		
		// 4 - LOB: Home Lending
		
		WebDriverWait LOB_wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Locate the dropdown input field
		WebElement LOB_dropdown = LOB_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='LOB']/following-sibling::div[contains(@class, 'css-b62m3t-container')]")));
		// Click to open dropdown
		LOB_dropdown.click();
		// Wait for the dropdown options to be visible
		WebElement LOB_option = LOB_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Home Lending')]")));
		// Click the option
		LOB_option.click();
		Thread.sleep(2000);
		System.out.println("\n✅ Purchase - General selected in Message Category");
		
		
	
		// 5 - Campaign: Home Lending
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement campaignDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Campaign']/following-sibling::div[contains(@class, 'css-b62m3t-container')]//input")));
		campaignDropdown.click();
		Thread.sleep(1500); // Small delay for dropdown to load
		// Locate "Home Lending" option
		WebElement campaignOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[text()='Home Lending'])[last()]")));
		// Scroll into view to make sure it's visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", campaignOption);
		Thread.sleep(500); // Allow time for scroll
		// Click using JavaScript (avoids click interception issues)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", campaignOption);
		Thread.sleep(2000);
 
	
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();// save button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-testid='info-panel-close-btn']")).click();// closing the side window
		
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		
		//-------------------------------------------------------------------------------------------------  HTML Template ------------------------------------------------------------------------------------------------
	
	   
		//--------------------------------------------------------------------------------------------- Copying the BASE TEMPLATE -----------------------------------------------------------------------------------------

		
		//Handling static dropdown after right click  & click copy -- HTML template
//	    WebElement element5 = driver.findElement(By.xpath("//span[normalize-space()='HPLP_BASE_TEMPLATE.html']"));
//	    Actions actions = new Actions(driver);
//	    actions.contextClick(element5).perform();// right click on the base template
//	    Thread.sleep(2000); // Wait for the context menu
//
//	    // Locate all options in the context menu
//	    List<WebElement> options = driver.findElements(By.xpath("//div[@role='menuitem']")); 
//	    Thread.sleep(2000);
//	    // Click on copy
//	    for (WebElement option : options) 
//	    {
//	        if(option.getText().trim().equals("Copy"))
//	        {
//	    	   option.click();
//	        }
//	    }
//	    Thread.sleep(2000);
//	    
//	    String base_template_name = "BASE_Template_NG_25.2_TEST";
//		driver.findElement(By.xpath("//input[@name='Name']")).clear();//clear the text field
//		Thread.sleep(2000);
//	    driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(base_template_name); // re-naming
//	    Thread.sleep(2000);
//	    driver.findElement(By.xpath("//button[normalize-space()='Copy']")).click(); // click on copy

	
		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	    
	    
	    //----------------------------------------------------------------------------------------------- Edit the base template ------------------------------------------------------------------------------------------
	    
		
	    WebElement template = driver.findElement(By.xpath("//span[normalize-space()='BASE_Template_NG_25.2_TEST.html']"));
		Actions actions1 = new Actions(driver);
		actions1.contextClick(template).perform();//right click on the base template
		Thread.sleep(2000); // Wait for the context menu
		// Locate all options in the context menu
		List<WebElement> options1 = driver.findElements(By.xpath("//div[@role='menuitem']")); 
		Thread.sleep(2000);
		// Click on edit
		for (WebElement option : options1) 
		{
		    if(option.getText().trim().equals("Edit"))//right click on Edit
		    {
		    	option.click();
		    	break;
		    }
		}
		Thread.sleep(25000);
		driver.findElement(By.xpath("//button[@name='Configure']")).click(); // click on Configure button
		
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//------------------------------------------------------------------------------ Filling the values in DAM_Metadata_Required --------------------------------------------------------------------------------------
		
		
		WebDriverWait blockType_wait_1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Locate the dropdown input field
		WebElement DAM_Metadata_Required_dropdown = blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='DAM Metadata Required']/following-sibling::div[contains(@class, 'css-b62m3t-container')]/div/div//input")));
		// Click to open dropdown
		DAM_Metadata_Required_dropdown.click();
		
		
		// Wait for the dropdown options to be visible
		WebElement Message_Category_op = blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Message Category')]"))); // Message Category
		// Click the option
		Thread.sleep(2000);
		Message_Category_op.click();
		
		DAM_Metadata_Required_dropdown.click();
		WebElement LOB_op = blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'LOB')]")));//LOB
		// Click the option
		Thread.sleep(2000);
		LOB_op.click();
		
	
		Thread.sleep(2000);
		DAM_Metadata_Required_dropdown.click();
		WebElement Campaign_op = blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Campaign')]")));//Campaign
		// Click the option
		Thread.sleep(2000);
		Campaign_op.click();
		
		//saving the config
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(2000);
		
		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//----------------------------------------------------------------------------------------------- Assemble the options ------------------------------------------------------------------------------------------------------------------
		
		// 1 -> LOB: Home Lending
		// 2 -> Campaign: Home Lending
		// 3 -> Message Category: Purchase - General
		
		driver.findElement(By.xpath("//button[normalize-space()='Assemble']")).click(); // click on assemble button
	
		WebDriverWait Assemble_blockType_wait_1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Message Category: Purchase - General
		// Locate the dropdown input field
		WebElement Message_Category_dropdown = Assemble_blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Message Category']/following-sibling::div[contains(@class, 'css-b62m3t-container')]/div/div//input")));
		// Click to open dropdown
		Message_Category_dropdown.click();
		// Wait for the dropdown options to be visible
		WebElement Purchase_general_op = Assemble_blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Purchase - general')]")));
		// Click the option
		Thread.sleep(2000);
		Purchase_general_op.click();
		
		
		//LOB: Home Lending
		// Locate the dropdown input field
		WebElement LOB_dropdown1 = Assemble_blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='LOB']/following-sibling::div[contains(@class, 'css-b62m3t-container')]/div/div//input")));
		// Click to open dropdown
		LOB_dropdown1.click();
		// Wait for the dropdown options to be visible
		WebElement Home_Lending_op_lob = Assemble_blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Home Lending')]")));
		// Click the option
		Thread.sleep(2000);
		Home_Lending_op_lob.click();
		
		
		// Campaign: Home Lending
		// Locate the dropdown input field
		WebElement Campaign_dropdown = Assemble_blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Campaign']/following-sibling::div[contains(@class, 'css-b62m3t-container')]/div/div//input")));
		// Click to open dropdown
		Campaign_dropdown.click();
		// Wait for the dropdown options to be visible
		WebElement Home_Lending_op_campaign = Assemble_blockType_wait_1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Home Lending'])[last()]")));
		// Click the option
		Thread.sleep(2000);
		Home_Lending_op_campaign.click();
		
		
		// Switch to the iframe for clicking in the Headline Section
		WebElement iframe_Headline = driver.findElement(By.xpath("//iframe[contains(@id, 'tiny-react_')]"));
		driver.switchTo().frame(iframe_Headline);
        Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'Turn contemplation into celebration')])")).click(); // click on header place 
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Get Assets']")).click(); // click on Get Assets 
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[normalize-space()='A - This is a Dummy Headline NG'])")).click(); // Select the header block 
		driver.findElement(By.xpath("//button[normalize-space()='Select']")).click(); // Select the header block
		Thread.sleep(3000);		
				
		
		//click on the iframe for selecting the image element
		WebElement iframe_img = driver.findElement(By.xpath("//iframe[contains(@id, 'tiny-react_')]"));
		driver.switchTo().frame(iframe_img);
        Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='_idContainer007']/annotate")).click(); // click on header place  --  if it doesn't work the value might have changed
		driver.switchTo().defaultContent();
        Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement imageElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'gettyimages_1227327106_hl_hplp_1600x700.jpg')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", imageElement);
		Thread.sleep(500); // Allow time for the scroll to complete
		imageElement.click();

		
		driver.findElement(By.xpath("//button[normalize-space()='Select']")).click(); // Select the header block
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Save as']")).click(); // Save AS button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='fileName']")).clear(); // Save AS button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='fileName']")).sendKeys("BASE_TEMPLATE_NG_COMPLETE_25.2"); // Save AS button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Associate Folder']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sc-hXaEyf joGFzs']//span[contains(text(),'UAT Testing - Template PDFs')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Associate Folder']")).click();
	    

		//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



		

	}

}
