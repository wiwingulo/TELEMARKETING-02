package com.telemarket.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import com.telemarket.pom.message.User;
import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;

public class UserResetPasswordTest {

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
	public void resetPassNullUser() {
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
		delay(1);

		try {
			user.resetNullUser("//div[1]/div[1]/div[3]/div[1]/div[6]/table[1]/tbody[1]/tr/td[1]/input[1]");
			delay(1);
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 2)
	public void resetPassOneUser() {
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
		delay(1);

		user.resetPassOneUser();
		delay(1);
		// assert
		util.verifChangePass("(//p[normalize-space()='PASSWORD BERHASIL DI RESET'])[1]");
		delay(1);

		user.clickBtnDone();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 3)
	public void resetPassTwoUser() {
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
		delay(1);

		user.resetPassTwoUser();
		delay(1);
		// assert
		util.verifChangePass("(//p[normalize-space()='PASSWORD BERHASIL DI RESET'])[1]");
		delay(1);

		user.clickBtnDone();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 4)
	public void resetPassAllUser() {
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
		delay(1);

		user.resetPassAllUser();
		delay(1);

		// assert
		util.verifChangePass("(//p[normalize-space()='PASSWORD BERHASIL DI RESET'])[1]");
		delay(1);

		user.clickBtnDone();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 5)
	public void checkButtonUser() {
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
		delay(2);

		user.checkButtonUser();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();	
	}


}
