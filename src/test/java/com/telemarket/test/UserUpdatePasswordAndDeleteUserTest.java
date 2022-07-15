package com.telemarket.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;
import com.telemarket.pom.data.UploadData;
import com.telemarket.pom.message.User;

public class UserUpdatePasswordAndDeleteUserTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected User user;
	protected Utilities util;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		dash = new Dashboard(driver);
		user = new User(driver);
		util = new Utilities(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));

	}



	@Test(priority = 1)
	public void updatePassAgentNull() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.updateNewPassNull("");

		// assert
		util.verifPassNull("(//p[normalize-space()='Isi terlebih dahulu'])[1]");
		delay(1);
		user.btnSavePassNull();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}

	@Test(priority = 2)
	public void updatePassNumber() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.updateNewPass("23");

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}

	@Test(priority = 3)
	public void updatePassString() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.updateNewPass("hi");

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}
	@Test(priority = 4)
	public void updatePassSpecialChar() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.updateNewPass("@");

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}
	@Test(priority = 5)
	public void checkButtonUpdatePage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.checkUpdateButton("@");

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}
	@Test(priority = 6)
	public void deleteUser() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.deleteUser();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}
	@Test(priority = 7)
	public void cancelDeleteUser() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		// update pass
		delay(1);
		user.cancelDeleteUser();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(1);
		driver.close();
	}
	


}