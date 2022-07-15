package com.telemarket.test;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.data.EditData;
import com.telemarket.pom.data.UploadData;
import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;

public class EditDataSearchTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected UploadData upload;
	protected EditData edit;
	protected Utilities util;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@DataProvider(name = "validData")
	public Object[] validData() {
		Object[] myData = { "somad2", "300" };
		return myData;
	}

	@DataProvider(name = "DataNotValid")
	public Object[] DataNotValid() {
		Object[] myData = { "%", "_" };
		return myData;
	}


	@Test(priority = 1)
	public void test_show_login_page() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

	}

	@Test(priority = 2, dataProvider = "validData")
	public void test_search_valid(String in) {
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);

		delay(2);
		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);
		edit.searchDataNew(in);
		delay(4);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[40]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(expectedChar)) {
				System.out.println(in);
				check = true;
				delay(3);
				break;
			}
		}

		assertTrue(check);
		delay(3);
		dash.btnData.click();
		delay(1);
	}

	@Test(priority = 3, dataProvider = "DataNotValid")
	public void test_search_not_valid(String in) {
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(2);
		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);
		edit.searchDataNew(in);
		delay(4);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[40]"));
		String expectedChar = in;
		boolean check = false;
		try {

			for (WebElement webElement : lstElement) {
				if (webElement.getText().contains(expectedChar)) {
					System.out.println(in);
					check = true;
					delay(3);
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			delay(1);
			
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			try {
				assertTrue(check);
			} finally {

				delay(3);
				dash.btnData.click();
				delay(1);
			}

		}
	}
	@Test(priority = 4)
	public void test_search_with_GreenButton_andTestButtonPage() {
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(2);
		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);
		edit.searchDataNew("medan");
		delay(4);
		
		util.testButtonPageEdit();
		delay(2);
		util.viewTable(10);
		delay(1);
		util.viewTable(25);
		delay(1);
		util.viewTable(50);
		delay(1);
		util.viewTable(100);
		delay(1);
		util.viewTable(500);
		delay(1);
		
	}
	@AfterTest
	public void logout() {
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
}