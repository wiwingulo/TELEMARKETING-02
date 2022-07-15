package com.telemarket.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.telemarket.pom.data.*;
import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;

public class DistributeDataToAgentTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected DistributeData distribute;
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
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void AgentNullWithFieldJumlahAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();

		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifAgentNull("(//p[normalize-space()='Pilih User yang akan didistribusikan'])[1]");
		delay(1);

		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 2)
	public void AgentWithFieldJumlahNullAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifJumlahNull("(//p[normalize-space()='Jumlah tidak boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 3)
	public void OneAgentWithFieldJumlahAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnYa.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 4)
	public void OneAgentWithFieldJumlahStringAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.inputJlhAgent("hello");
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifJumlahNull("(//p[normalize-space()='Jumlah tidak boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 5)
	public void OneAgentWithFieldJumlahSpecialCharAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.inputJlhAgent("@");
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifJumlahNull("(//p[normalize-space()='Jumlah tidak boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 6)
	public void TwoAgentWithFieldJumlahAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose2Agent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnYa.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 7)
	public void AllAgentWithFieldJumlahAndStatusExisting() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.chooseAllAgent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnYa.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	
	@Test(priority = 8)
	public void AgentWithFieldJumlahNullAndStatusNew() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifJumlahNull("(//p[normalize-space()='Jumlah tidak boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 9)
	public void OneAgentWithFieldJumlahAndStatusNew() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnYa.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	
	@Test(priority = 10)
	public void OneAgentWithFieldJumlahStringAndStatusNew() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.inputJlhAgent("hello");
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifJumlahNull("(//p[normalize-space()='Jumlah tidak boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 11)
	public void OneAgentWithFieldJumlahSpecialCharAndStatusNew() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose1Agent();
		delay(1);
		distribute.inputJlhAgent("@");
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifJumlahNull("(//p[normalize-space()='Jumlah tidak boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 12)
	public void TwoAgentWithFieldJumlahAndStatusNew() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.choose2Agent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnYa.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 13)
	public void AllAgentWithFieldJumlahAndStatusNew() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.chooseAllAgent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnYa.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
	@Test(priority = 13)
	public void AllAgentWithFieldJumlahAndStatusNewNotDistribute() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();
		delay(1);

		distribute.chooseAllAgent();
		delay(1);
		distribute.inputJlhAgent("5");
		delay(1);
		distribute.clickStatusNewDistribute();
		delay(1);
		distribute.clickDistribute();
		delay(1);

		// assert
		util.verifDistributeSuccess("(//p[normalize-space()='Apa Yakin Distribusi ?'])[1]");
		delay(1);

		distribute.btnTidak.click();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}
}
