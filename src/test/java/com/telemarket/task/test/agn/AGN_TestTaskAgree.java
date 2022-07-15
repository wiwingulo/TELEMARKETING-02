package com.telemarket.task.test.agn;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.task.Agent.*;
import com.telemarket.task.test.Utility;

public class AGN_TestTaskAgree extends Utility {
	
	protected WebDriver driver;
	
	public boolean verifyDataInTable(String xpath, String data) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(data)) {
				checkData = true;
			} else if (isiElement.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		return checkData;
	}
	
	public boolean verifyDataInTable(String xpath, String data, String data2) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(data) && isiElement.contains(data2)) {
				checkData = true;
			} else if (isiElement.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		return checkData;
	}
	
	@BeforeMethod
	public void cekSession() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@DataProvider(name = "validData")
	public Object[] validData() {
		Object[] myData = { "kopi", "1", "Toko_Adil_3" };
		return myData;
	}

	@Test(priority = 1, dataProvider = "validData")
	public void testAGNAgree_validSearch(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		assertEquals(agreePage.getTextAgree(),"DATA AGREE");
		delay(1);
		agreePage.searchDataAgree(in);
		delay(2);
		try {
			verifyDataInTable("(//tr)[41]", in);
		} finally {
			delay(3);
		}
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&", "_" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void testAGNAgree_emptyUnusualSearch(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(in);
		delay(2);
		try {
			verifyDataInTable("(//tr)[41]", in);
		} finally {
			delay(3);
		}
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tbody)[38]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if(webElement.getText().isBlank()) {
				break;
			}else if (webElement.getText().contains(expectedChar)) {
				check = true;
				delay(2);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		agreePage.clickBtnLogoutAtMain();
		delay(1);
		agreePage.logout();
		delay(2);
	}

	@Test(priority = 3)
	public void test_agree_export_data() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.clickExportAgree();
		delay(3);
		String downloadPath = "C:\\Users\\nexsoft\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		assertTrue(fileName.contains("exportagree"), "Data tidak ada/tidak sesuai");
		delay(3);
		agreePage.clickBtnLogoutAtMain();
		delay(1);
		agreePage.logout();
	}
	
	@Test(priority = 4)
	public void testAgree_clickTable_gotoActivity() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.clickLastPagination();
		delay(1);
		agreePage.clickFirstPagination();
		delay(1);
		agreePage.clickPage1();
		delay(1);
		agreePage.clickPage2();
		delay(1);
		agreePage.clickPage3();
		delay(1);
		agreePage.clickPage4();
		delay(1);
		agreePage.clickPage5();
		delay(1);
		agreePage.clickPage6();
		delay(1);
		agreePage.clickFirstPagination();
		delay(1);
		agreePage.viewTable(10);
		delay(1);
		agreePage.viewTable(25);
		delay(1);
		agreePage.viewTable(50);
		delay(1);
		agreePage.viewTable(100);
		delay(1);
		agreePage.viewTable(500);
		delay(2);
		agreePage.searchDataAgree("kopi");
		delay(3);
		agreePage.clickTopTable();
		delay(1);
		System.out.println(agreePage.getTextAgreeActivity());
		assertEquals(agreePage.getTextAgreeActivity(),"Data Detail");
		delay(2);
		agreePage.closeAgreeActivity();
		delay(1);
		agreePage.clickBtnLogoutAtMain();
		delay(1);
		agreePage.logout();
	}
	
	@Test(priority = 5)
	public void testAgree_activity_linkEmpty() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "naurashop156";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		agreePage.clickTopTable();
		delay(1);
		agreePage.setLinkActivity("");
		delay(1);
		agreePage.clickUpdateLink();
		delay(1);
		agreePage.clickOKInformasiActivity();
		delay(2);
		AGN_TaskFinalPage finalPage = agreePage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(3);
		try {
			List<WebElement> lstElement = driver.findElements(By.xpath("//tbody"));
			boolean check = false;
			for (WebElement webElement : lstElement) {
				if (webElement.getText().contains(nama)) {
					check = true;
					delay(3);
					break;
				}
			}
			assertTrue(check);
		}finally {
			delay(1);
			agreePage.clickBtnLogoutAtMain();
			delay(1);
			agreePage.logout();
		}
		
		
	}
	
	@DataProvider(name = "dataLink")
	public Object[][] dataLink() {
		Object[][] myData = { 
//				{"","initautan"}, 
//				{"bakedby.tara","initautan.com"}, 
//				{"_rifafashion", "www.initautan.com"},
//				{"shabil.official","http://www.initautan.com"}, 
				{"bakedby.tara","https://www.initautan.com"}
				};
		return myData;
	}
	
	@Test(priority = 6, dataProvider = "dataLink")
	public void testAgree_activity_link(String nama, String inLink) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		agreePage.clickTopTable();
		delay(1);
		agreePage.setLinkActivity(inLink);
		delay(1);
		agreePage.clickUpdateLink();
		delay(3);
		agreePage.clickOKInformasiActivity();
		delay(3);
		AGN_TaskFinalPage finalPage = agreePage.clickTaskFinal();
		delay(2);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(3);
		try {
			verifyDataInTable("(//tr)[25]", nama, inLink);
		}finally {
			delay(1);
			agreePage.clickBtnLogoutAtMain();
			delay(1);
			agreePage.logout();
			delay(2);
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@AfterTest
	public void clean() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportagree.xls");
		file.delete();
	}
}
