package com.telemarket.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
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

public class UserUpdateDataTest {

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
	public void updateAgentFullNameNull() {
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

		try {
			delay(1);
			user.updateAgentFullNameNull("", "Admin", "ADMIN (ADMIN)", "0923132", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[5]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			// logout
			delay(1);
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 2)
	public void updateAgentPrivillegesNull() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentPrivNull("Testing", "", "ADMIN (ADMIN)", "0923432", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[6]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}
	}

	@Test(priority = 3)
	public void updateAgentSpvNull() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentSpvNull("Testing", "Admin", "", "0923432", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[7]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 4)
	public void updateAgentPhoneNull() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentPhoneNull("Testing", "Admin", "ADMIN (ADMIN)", "", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[8]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 5)
	public void updateAgentPhoneString() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentPhoneNull("Testing", "Admin", "ADMIN (ADMIN)", "hello", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[8]");

		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 6)
	public void updateAgentPhoneSpecialChar() {
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

		try {

			// add agent
			delay(1);
			user.updateAgentPhoneNull("Testing", "Admin", "ADMIN (ADMIN)", "@", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[8]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 7)
	public void updateAgentUserAct() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentUserActive("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[10]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 8)
	public void updateAgentUserNotAct() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentUserActive("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "2322", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[10]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 9)
	public void updateAgentExtensionNull() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentExtensionNull("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}

	}

	@Test(priority = 10)
	public void updateAgentExtensionString() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentExtensionNull("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "hmm", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}


	}

	@Test(priority = 11)
	public void updateAgentExtensionSpecialChar() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentExtensionNull("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "*", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}


	}

	@Test(priority = 12)
	public void updateAgentExtensionSameWithOther() {
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

		try {
			delay(1);
			user.updateAgentExtensionNull("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "4001", "testing",
					"//div[6]/table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}


	}

	@Test(priority = 13)
	public void updateAgentUsernameOnlyNumber() {
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

		try {
			// add agent
			delay(1);
			user.updateAgentUsernameOnlyNumber("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "4231", "32",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}


	}

	@Test(priority = 14)
	public void updateAgentSameUsername() {
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

		try {
			delay(1);
			user.updateAgentSameUsername("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "4231", "ridho",
					"(//p[normalize-space()=\"Duplicate entry 'ridho' for key 'agent.username'\"])[1]");
			delay(1);
		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}
	}
	
	@Test(priority = 15)
	public void updateAgentUsernameSpecialChar() {
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

		try {
			delay(1);
			user.updateAgentUsernameOnlyNumber("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "4231", "ridho",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
			delay(1);
		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}
	}

	@Test(priority = 16)
	public void updateAgentUsernameNull() {
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

		try {
			delay(1);
			user.updateAgentUsernameNull("Testing", "Admin", "ADMIN (ADMIN)", "3247832", "NOT ACTIVE", "4231", "",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
			delay(1);
	

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}
	}

	@Test(priority = 17)
	public void updateAgentCheckButton() {
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

		// add agent
		delay(1);
		user.checkButtonUpdate();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
}
