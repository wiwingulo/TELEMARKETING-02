package com.telemarket.test;

import static org.testng.Assert.assertEquals;

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

import com.telemarket.pom.data.UploadData;
import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;

public class DataUploadTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected UploadData upload;
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
	public void uploadData() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
		delay(5);
		upload.uploadData();

		// asert
		util.verifKolomSource("//div[5]/div[6]/table[1]/tbody[1]/tr[1]/td[2]");
		delay(1);
		util.verifBDName("//div[5]/div[6]/table[1]/tbody[1]/tr[1]/td[3]");
		delay(1);
		util.verifMerchantName("//div[5]/div[6]/table[1]/tbody[1]/tr[1]/td[4]");
		delay(1);
		util.verifSourceOfLead("//div[5]/div[6]/table[1]/tbody[1]/tr[1]/td[5]");
		delay(1);
		util.verifPhone("//div[5]/div[6]/table[1]/tbody[1]/tr[1]/td[6]");
		delay(1);
		util.verifSegment("//div[5]/div[6]/table[1]/tbody[1]/tr[1]/td[7]");
		delay(1);
		// save
		upload.saveData();
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 2)
	public void clickDataMenuIfDataisAnotherFormat() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
		delay(5);
		upload.uploadDataWrongFormat();
		delay(2);

		// assert
		assertEquals(driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[2]/p[1]")).getText(),
				"File tidak dapat dibaca/ jumlah data 0");
		delay(1);
		upload.save();
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@Test(priority = 3)
	public void clickButtonStep() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
		delay(5);
		upload.btnUpload.sendKeys("D:\\Data.xlsx");
		delay(2);
		upload.btnUploadExcel.click();
		delay(5);
		util.testButtonPage();
		delay(2);
		util.viewTable(10);
		delay(1);
		util.viewTable(25);
		delay(1);
		util.viewTable(50);
		delay(1);
		util.viewTable(100);
		delay(2);
		util.viewTable(500);
		delay(2);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

}
