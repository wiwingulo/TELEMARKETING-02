package com.telemarket.test;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.Test;
import com.telemarket.pom.data.*;
import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;

public class DistributeDataTest {
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
	public void clickOneStatusOneAgent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();

		distribute.openDropDownBuket();
		delay(1);
		distribute.click1DropDownAgent();
		delay(1);
		distribute.clickView();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 2)
	public void clickStatusNullOneAgent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNull();
		delay(1);

		distribute.clickView();
		delay(2);

		System.out.println("verif");

		// assert
		util.verifStatusNull("(//p[normalize-space()='Status Tidak Boleh Kosong'])[1]");
		delay(1);

		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 3)
	public void clickStatusNewBuketDataNull() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();

		distribute.openDropDownBuket();
		delay(2);
		distribute.clickBuketDataNull();
		delay(1);
		distribute.clickView();
		delay(2);

		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(3);
	}

	@Test(priority = 4)
	public void clickStatusNewWithTwoBuketData() {
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

		distribute.openDropDownBuket();
		delay(2);
		distribute.click2BuketData();
		delay(1);
		distribute.clickView();
		delay(2);

		try {
			// assert
			String getText = distribute.dropdownStatus.getText();
			String[] namaA = getText.split(" , ");
			util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// logout
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
		}
	}

	@Test(priority = 5)
	public void clickStatusNewWithThreeBuketData() {
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

		distribute.openDropDownBuket();
		delay(2);
		distribute.click3BuketData();
		delay(1);
		distribute.clickView();
		delay(2);

		try {
			// assert
			String getText = distribute.dropdownStatus.getText();
			String[] namaA = getText.split(" , ");
			util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
		}

	}

	@Test(priority = 6)
	public void clickStatusAgreeWithNullBuketData() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		DistributeData distribute = PageFactory.initElements(driver, DistributeData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.gotoDistributeData();

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusAgree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 7)
	public void clickStatusAgreeWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusAgree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 8)
	public void clickStatusAgreeWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusAgree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 9)
	public void clickStatusAgreeWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusAgree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 10)
	public void clickStatusBerhasilWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 11)
	public void clickStatusBerhasilWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 12)
	public void clickStatusBerhasilWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 13)
	public void clickStatusBerhasilWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 14)
	public void clickStatusCallBackWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCallBack();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 15)
	public void clickStatusCallBackWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCallBack();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 16)
	public void clickStatusCallBackWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCallBack();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 17)
	public void clickStatusCallBackWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCallBack();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 18)
	public void clickStatusCustomerNotAvailableWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCustomerNotAvail();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 19)
	public void clickStatusCustomerNotAvailableWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCustomerNotAvail();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 20)
	public void clickStatusCustomerNotAvailableWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCustomerNotAvail();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 21)
	public void clickStatusCustomerNotAvailableWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCustomerNotAvail();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 22)
	public void clickStatusDisagreeWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusDisagree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(3);
	}

	@Test(priority = 23)
	public void clickStatusDisagreeWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusDisagree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 24)
	public void clickStatusDisagreeWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusDisagree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 25)
	public void clickStatusDisagreeWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusDisagree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 26)
	public void clickStatusFollowupWithBuketDataNull() {
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
		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusFollowup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(2);
		distribute.btnOk.click();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 27)
	public void clickStatusFollowupWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusFollowup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 28)
	public void clickStatusFollowupWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusFollowup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 29)
	public void clickStatusFollowupWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusFollowup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 30)
	public void clickStatusInvalidNumberWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusInvalidNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 31)
	public void clickStatusInvalidNumberWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusInvalidNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 32)
	public void clickStatusInvalidNumberWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusInvalidNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 33)
	public void clickStatusInvalidNumberWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusInvalidNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 34)
	public void clickStatusMailboxWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMailbox();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 35)
	public void clickStatusMailboxWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMailbox();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 36)
	public void clickStatusMailboxWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMailbox();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 37)
	public void clickStatusMailboxWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMailbox();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 38)
	public void clickStatusMissCustomerWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMissCustomer();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 39)
	public void clickStatusMissCustomerWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMissCustomer();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 40)
	public void clickStatusMissCustomerWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMissCustomer();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 41)
	public void clickStatusMissCustomerWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMissCustomer();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 42)
	public void clickStatusNoBodyPickupWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNoBodyPickup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 43)
	public void clickStatusNoBodyPickUpWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNoBodyPickup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 44)
	public void clickStatusNoBodyPickUpWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNoBodyPickup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 45)
	public void clickStatusNoBodyPickUpWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNoBodyPickup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 46)
	public void clickStatusNomerSalahWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNomerSalah();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 47)
	public void clickStatusNomerSalahWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNomerSalah();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 48)
	public void clickStatusNomerSalahWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNomerSalah();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 49)
	public void clickStatusNomerSalahWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNomerSalah();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 50)
	public void clickStatusSalahSambungWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSalahSambung();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 51)
	public void clickStatusSalahSambungWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSalahSambung();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 52)
	public void clickStatusSalahSambungWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSalahSambung();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 53)
	public void clickStatusSalahSambungWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSalahSambung();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 54)
	public void clickStatusSetujuWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSetuju();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 55)
	public void clickStatusSetujuWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSetuju();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 56)
	public void clickStatusSetujuWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSetuju();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 57)
	public void clickStatusSetujuWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSetuju();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 58)
	public void clickStatusTelponNotRegisterWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickTelponNotRegister();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 59)
	public void clickStatusTelponNotRegisterWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickTelponNotRegister();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 60)
	public void clickStatusTelponNotRegisterWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickTelponNotRegister();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(3);
	}

	@Test(priority = 61)
	public void clickStatusTelponNotRegisterWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickTelponNotRegister();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(3);
	}

	@Test(priority = 62)
	public void clickStatusThinkingWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusThinking();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 63)
	public void clickStatusThinkingWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusThinking();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 64)
	public void clickStatusThinkingWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusThinking();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 65)
	public void clickStatusThinkingWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusThinking();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 66)
	public void clickStatusTidakAdaNomorTeleponWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakAdaNomorTelepon();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 67)
	public void clickStatusTidakAdaNomorTeleponWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakAdaNomorTelepon();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 68)
	public void clickStatusTidakAdaNomorTeleponWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakAdaNomorTelepon();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 69)
	public void clickStatusTidakAdaNomorTeleponWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakAdaNomorTelepon();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 70)
	public void clickStatusTidakBerhasilWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 71)
	public void clickStatusTidakBerhasilWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 72)
	public void clickStatusTidakBerhasilWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 73)
	public void clickStatusTidakBerhasilWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 74)
	public void clickStatusTidakDiangkatWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakDiangkat();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 75)
	public void clickStatusTidakDiangkatWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakDiangkat();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 76)
	public void clickStatusTidakDiangkatWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakDiangkat();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 77)
	public void clickStatusTidakDiangkatWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakDiangkat();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 78)
	public void clickStatusTidakTerdaftarWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakTerdaftar();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 79)
	public void clickStatusTidakTerdaftarWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakTerdaftar();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 80)
	public void clickStatusTidakTerdaftarWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakTerdaftar();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 81)
	public void clickStatusTidakTerdaftarWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakTerdaftar();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 82)
	public void clickStatusTolakWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTolak();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 83)
	public void clickStatusTolakWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTolak();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 84)
	public void clickStatusTolakWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTolak();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 85)
	public void clickStatusTolakWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTolak();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 86)
	public void clickStatusWrongNumberWithBuketDataNull() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusWrongNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickBuketDataNull();
		delay(1);

		distribute.clickView();
		delay(2);
		// assert
		assertEquals(
				driver.findElement(By.xpath("(//p[normalize-space()='Buket Data Tidak Boleh Kosong'])[1]")).getText(),
				"Buket Data Tidak Boleh Kosong");
		delay(1);
		distribute.btnOk.click();

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 87)
	public void clickStatusWrongNumberWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusWrongNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 88)
	public void clickStatusWrongNumberWithTwoBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusWrongNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click2BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 89)
	public void clickStatusWrongNumberWithThreeBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusWrongNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click3BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 90)
	public void clickStatusNewWithAllBuketData() {
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

		distribute.openDropDownBuket();
		delay(2);
		distribute.clickAllBuketData();
		delay(1);
		distribute.clickView();
		delay(2);

		try {
			// assert
			String getText = distribute.dropdownStatus.getText();
			String[] namaA = getText.split(" , ");
			util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// logout
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
		}
	}

	@Test(priority = 91)
	public void clickStatusAgreeWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusAgree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 92)
	public void clickStatusBerhasilWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 93)
	public void clickStatusCallBackWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCallBack();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 94)
	public void clickStatusCustNotAvailWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusCustomerNotAvail();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 95)
	public void clickStatusDisagreeWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusDisagree();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 96)
	public void clickStatusFollowupWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusFollowup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 97)
	public void clickStatusInvalidNumberWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusInvalidNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 98)
	public void clickStatusMailboxWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMailbox();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 99)
	public void clickStatusMissCustomerWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusMissCustomer();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 100)
	public void clickStatusNoBodyPickupWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNoBodyPickup();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 101)
	public void clickStatusNomerSalahWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNomerSalah();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 102)
	public void clickStatusSalahSambungWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSalahSambung();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 103)
	public void clickStatusSetujuWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusSetuju();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 104)
	public void clickStatusTelponNotRegisterWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickTelponNotRegister();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 105)
	public void clickStatusThinkingWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusThinking();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 106)
	public void clickStatusTidakAdaNomorTeleponWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakAdaNomorTelepon();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 107)
	public void clickStatusTidakBerhasilWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakBerhasil();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 108)
	public void clickStatusTidakTerdaftarWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTidakTerdaftar();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 109)
	public void clickStatusTolakWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusTolak();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 110)
	public void clickStatusWrongNumberWithAllBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusWrongNumber();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.clickAllBuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		// assert
		String getText = distribute.dropdownStatus.getText();
		String[] namaA = getText.split(" , ");
		util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

	@Test(priority = 111)
	public void clickStatusNewWithOneBuketData() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNew();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		try {
			// assert
			String getText = distribute.dropdownStatus.getText();
			String[] namaA = getText.split(" , ");
			util.verifDataArray("//div[4]/div[6]/table[1]/tbody[1]/tr/td[5]", namaA);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// logout
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
		}
	}

	@Test(priority = 112)
	public void testButtonPage() {
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

		distribute.openDropDownStatus();
		delay(1);
		distribute.clickStatusNew();
		delay(1);
		distribute.hover.click();
		delay(1);
		distribute.openDropDownBuket();
		delay(1);
		distribute.click1BuketData();
		delay(1);

		distribute.clickView();
		delay(2);

		util.testButtonPage();
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

		// logout
		util.screenShot();
		delay(1);
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

}
