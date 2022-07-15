package com.telemarket.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class UserAddAgentTest {

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
	public void addAgentFullNameNull() {
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
		try {
			delay(1);
			user.addAgentFullNameNull("", "Agent", "SPV01 ()", "0923132", "32132", "agent101", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
			

		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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
	public void addAgentPrivillegesNameNull() {
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
			user.addAgentPrivillegesNull("Wawan", "", "SPV01 ()", "0923132", "32132", "Agent555", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[6]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 3)
	public void addAgentSpvNull() {
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
			user.addAgentSupervisorNull("Wawan", "Agent", "", "322312", "32132", "Agent155", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[7]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 4)
	public void addAgentPhoneNull() {
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
			user.addAgentPhoneNull("Wawan", "Agent", "SPV01 ()", "", "32132", "Agent55215", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[8]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 5)
	public void addAgentPhoneString() {
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
			user.addAgentPhoneSpecialChar("Wawan", "Agent", "SPV01 ()", "haihai", "32132", "Agent255325", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[8]");

		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 6)
	public void addAgentPhoneSpecialChar() {
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
			user.addAgentPhoneSpecialChar("Wawan", "Agent", "SPV01 ()", "@", "32132", "Agent334255", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[8]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 7)
	public void addAgentExtensionNull() {
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
			user.addAgentExtensionNull("Wawan", "Agent", "SPV01 ()", "213212", "", "Agent412155", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 8)
	public void addAgentExtensionString() {
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
			user.addAgentExtensionNull("Wawan", "Agent", "SPV01 ()", "213212", "hei", "Agent612355", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 9)
	public void addAgentExtensionSpecialChar() {
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
			user.addAgentExtensionNull("Wawan", "Agent", "SPV01 ()", "213212", "@", "Agent755", "101",
					"//table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 10)
	public void addAgentUsernameOnlyNumber() {
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
			user.addAgentUsernameOnlyNumber("Wawan", "Agent", "SPV01 ()", "213212", "132878", "21", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 11)
	public void addAgentSameUsername() {
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
			user.addAgentSameUsername("Wawan", "Agent", "SPV01 ()", "213212", "132878", "ridho", "101",
					"(//p[normalize-space()=\"Duplicate entry 'ridho' for key 'agent.username'\"])[1]");
		} catch (Exception e) {
			System.out.println(e);
		} finally {

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
	public void addAgentUsernameSpecialChar() {
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
			user.addAgentUsernameOnlyNumber("Wawan", "Agent", "SPV01 ()", "213212", "132878", "@", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 13)
	public void addAgentUsernameNull() {
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
			user.addAgentUsernameOnlyNumber("Wawan", "Agent", "SPV01 ()", "213212", "132878", "", "101",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 14)
	public void addAgentPassString() {
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
		user.addAgent("Wawan", "Supervisor", "DEVELOPER (DEVELOPER)", "213212", "132878", "wiwin21", "haihai",
					"//div[6]/table[1]/tbody[1]/tr/td[4]");
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
		

	}

	@Test(priority = 15)
	public void addAgentPassNumber() {
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
		user.addAgentPassNumber("Wawan", "Supervisor", "DEVELOPER (DEVELOPER)", "213212", "132878", "wiwin23", "32",
				"//div[6]/table[1]/tbody[1]/tr/td[4]");
		delay(1);

			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
	}

	@Test(priority = 16)
	public void addAgentPassSpecialChar() {
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
		user.addAgent("Wawan", "Supervisor", "DEVELOPER (DEVELOPER)", "213212", "132878", "wiwin223", "%#",
				"//div[6]/table[1]/tbody[1]/tr/td[4]");
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(3);
		driver.close();
	}

	@Test(priority = 17)
	public void addAgentSameExtension() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		User user = PageFactory.initElements(driver, User.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(2);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		dash.gotoUser();

		try {
			// add agent
			delay(1);
			user.addAgentExtensionNull("Wawan", "Agent", "SPV01 ()", "213212", "4001", "Agent1055", "101",
					"//table[1]/tbody[1]/tr/td[11]");
		} finally {
			delay(1);
			util.viewTable(50);
			delay(1);
			util.scroll();
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

	@Test(priority = 18)
	public void addAgentCancelButton() {
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
		user.btnAdd.click();
		delay(1);
		user.btnSave.click();
		delay(1);
		user.btnNo.click();
		delay(1);
		user.btnAdd.click();
		delay(1);
		user.btnClose.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

}
