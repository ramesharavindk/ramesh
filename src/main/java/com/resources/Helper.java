package com.resources;

	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.util.List;
	import java.util.NoSuchElementException;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	//import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Helper {
		static WebDriver driver;

		// Opening Browser
		public void openBrowser() {
			System.setProperty("webdriver.chrome.driver", "\\BaseClass1\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		// Closing Browser
		public void quitBrowser() {
			driver.quit();
		}

		// Close Window
		public void closeWindow() {
			driver.close();
		}

		// Enter URL
		public void enterUrl(String url) {
			driver.get(url);
		}

		// Get PageTitle
		public String getPageTitle() {
			String title = driver.getTitle();
			return title;
		}

		// Get Url
		public String getCurrentUrl() {
			String url = driver.getCurrentUrl();
			return url;
		}

		// Get PageSource
		public String getPageSource() {
			String pgs = driver.getPageSource();
			return pgs;
		}

		// Type Text
		public void enterValue(WebElement elt, String val) {
			elt.sendKeys("val");
		}

		// Move to element and click
		public void moveAndClick(WebElement elt) {
			Actions ac = new Actions(driver);
			ac.moveToElement(elt).perform();
			ac.click();
		}

		// Perform RightClick
		public void rightClick(WebElement elt) {
			Actions ac = new Actions(driver);
			ac.contextClick(elt).perform();
		}

		// Perform DoubleClick
		public void doubleClick(WebElement elt) {
			Actions ac = new Actions(driver);
			ac.doubleClick(elt).perform();
		}

		// Accept Alerts
		public void acceptAlert() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}

		// Dismiss Alerts
		public void dismissAlert() {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}

		// Type in Alert
		public void typeInAlert(String val) {
			Alert a = driver.switchTo().alert();
			a.sendKeys(val);
			a.accept();
		}

		// Get value
		public String getValue(WebElement elt) {
			String val = elt.getText();
			return val;
		}

		// ScreenShot
//		public void ScreenShot(String name) throws Throwable {
//			TakesScreenshot tk = (TakesScreenshot) driver;
//			File s = tk.getScreenshotAs(OutputType.FILE);
//			File d = new File("E:\\Java programs\\BaseClass1\\SS\\" + name + ".png");
//			FileUtils.copyFile(s, d);
//		}

		// Insert by JS
		public void insertValueByJS(WebElement elt, String val) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','val')", elt);
		}

		// Click by JS
		public void clickByJS(WebElement elt) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", elt);
		}

		// GetValue By JS
		public void getValueByJS(WebElement elt) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].getAttribute('value')", elt);
		}

		// ScrollDown
		public void scrollDown(WebElement elt) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", elt);
		}

		// ScrollUp
		public void scrollUp(WebElement elt) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(false)", elt);
		}

		// Select by value
		public void selectValue(WebElement elt, String val) {
			Select s = new Select(elt);
			s.selectByValue(val);
		}

		// Select by Visible Text
		public void selectText(WebElement elt, String val) {
			Select s = new Select(elt);
			s.selectByVisibleText(val);
		}

		// Select By Index
		public void selectIndex(WebElement elt, int index) {
			Select s = new Select(elt);
			s.selectByIndex(index);
		}

		// Deselect By value
		public void deselectValue(WebElement elt, String val) {
			Select s = new Select(elt);
			s.deselectByValue(val);
		}

		// Deselect by text
		public void deselectText(WebElement elt, String val) {
			Select s = new Select(elt);
			s.deselectByVisibleText(val);
		}

		// Deselect By Index
		public void deselectIndex(WebElement elt, int index) {
			Select s = new Select(elt);
			s.deselectByIndex(index);
		}

		// Get Options
		public void listOptions(WebElement elt) {
			Select s = new Select(elt);
			List<WebElement> opt = s.getOptions();
			for (WebElement x : opt) {
				String name = x.getAttribute("value");
				System.out.println(name);
			}
		}

		// Is multiple Selected
		public boolean isMultiSelected(WebElement elt) {
			Select s = new Select(elt);
			boolean b = s.isMultiple();
			return b;
		}

		// Switch Frame by value
		public void switchFrame(String val) {
			driver.switchTo().frame(val);
		}

		// Switch Frame by index
		public void switchFrame(int val) {
			driver.switchTo().frame(val);
		}

		// Switch Frame by element
		public void switchFrame(WebElement elt) {
			driver.switchTo().frame(elt);
		}

		// Parent Frame
		public void parentFrame() {
			driver.switchTo().parentFrame();
		}

		// Default frame
		public void defaultContent() {
			driver.switchTo().defaultContent();
		}

		// Frame Count
		public int frameCount() {
			List<WebElement> li = driver.findElements(By.tagName("iframe"));
			int i = li.size();
			return i;
		}

		// Switch To window
		public void windowSwitch(String val) {
			driver.switchTo().window(val);
		}

		// Get Parent Window Id
		public String getParentWindow() {
			String pwd = driver.getWindowHandle();
			return pwd;
		}

		// Window size
		public void noOfWindows() {
			Set<String> s = driver.getWindowHandles();
			s.size();
		}

		// Button Click
		public void btnClick(WebElement elt) {
			elt.click();
		}

		// Clear Text
		public void clearText(WebElement elt) {
			elt.clear();
		}

		// Implicit Wait
		public void implicitWait(int val) {
			driver.manage().timeouts().implicitlyWait(val, TimeUnit.SECONDS);
		}

		// PageLoad Timeout
		public void pageLoadTimeout(int val) {
			driver.manage().timeouts().pageLoadTimeout(val, TimeUnit.SECONDS);
		}

		// delete All cookies
		public void deleteCookies() {
			driver.manage().deleteAllCookies();
		}

		// Explicit Wait
		public void explicitWait(WebElement elt, int val) {
			WebDriverWait w = new WebDriverWait(driver, val);
			WebElement x = w.until(ExpectedConditions.elementToBeClickable(elt));
			x.click();
		}

		// Fluent Wait
		public void fluentWait(WebElement elt, int val, int pol) {
			FluentWait f = new FluentWait(driver).withTimeout(val, TimeUnit.SECONDS).pollingEvery(pol, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			WebElement x = (WebElement) f.until(ExpectedConditions.elementToBeClickable(elt));
			x.click();
		}

		// Click Enter
		public void enter() throws Throwable {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

		// Copy Text
		public void copyText(WebElement elt) throws Throwable {
			Actions ac = new Actions(driver);
			ac.doubleClick(elt);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}

		// Paste Text
		public void pasteText(WebElement elt) throws Throwable {
			Actions ac = new Actions(driver);
			ac.click(elt);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}











	}


