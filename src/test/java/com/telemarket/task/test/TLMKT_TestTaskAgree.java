package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.task.*;

public class TLMKT_TestTaskAgree{
	
	protected WebDriver driver;
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\selenium-workspace\\TLMKT\\TELEMARKETING\\hasilScreenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}
	
	protected File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	public boolean verifyDataInTable(String xpath, String data1) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			if (isiElement.contains(data1)) {
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
		Object[] myData = { "Toko_Adil_3" };
		return myData;
	}

	@Test(priority = 1, dataProvider = "validData")
	public void testSPVAgree_validSearch(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		assertEquals(agreePage.getTextAgree(),"DATA AGREE");
		delay(1);
		agreePage.searchDataAgree(in);
		delay(2);
		try {
//			verifyDataInTable("(//tbody)[38]", in);
			verifyDataInTable("(//tr)[41]", in);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void testSPVAgree_searchEmptyAndUnusual(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(in);
		delay(2);
		try {
//			verifyDataInTable("(//tbody)[38]", in);
			verifyDataInTable("(//tr)[41]", in);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@Test(priority = 3)
	public void testSPVAgree_exportData() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.clickExportAgree();
		delay(3);
		try {
			String downloadPath = "C:\\Users\\nexsoft\\Downloads";
			File getLatestFile = getLatestFilefromDir(downloadPath);
			String fileName = getLatestFile.getName();
			assertTrue(fileName.contains("exportagree"), "Data tidak ada/tidak sesuai");
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 4)
	public void testSPVAgree_navigateGoToActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
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
		delay(2);
		try {
			assertEquals(agreePage.getTextAgreeActivity(), "Data Detail");
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "dataInvalidLink")
	public Object[][] dataInvalidLink() {
		Object[][] myData = { 
				{"Cafe Riung Panyileukan",""}, 
				{"expres.id","initautan"}, 
				{"ABC SWALAYAN","initautan.com"}
				};
		return myData;
	}
	
	@Test(priority = 5,dataProvider="dataInvalidLink")
	public void testSPVAgree_atActivity_addInvalidLink(String nama, String inLink) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		agreePage.clickTopTable();
		delay(1);
		agreePage.setLinkActivity(inLink);
		delay(1);
		agreePage.clickUpdateLink();
		delay(1);
		agreePage.clickOKInformasiActivity();
		delay(2);
		TaskFinalPage finalPage = agreePage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(3);
		try {
//			verifyDataInTable("(//tbody)[37]", nama);
			verifyDataInTable("(//tr)[40]", nama);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "dataLink")
	public Object[][] dataLink() {
		Object[][] myData = { 
				{"Acang", "www.initautan.com"},
				{"sofii_saja","http://www.initautan.com"}, 
				{"wihh_skincare","https://www.initautan.com"}
				};
		return myData;
	}
	
	@Test(priority = 6, dataProvider = "dataLink")
	public void testSPVAgree_atActivity_addValidLink(String nama, String inLink) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
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
		TaskFinalPage finalPage = agreePage.clickTaskFinal();
		delay(2);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(3);
		try {
//			List<WebElement> lstElement = driver.findElements(By.xpath("(//tbody)[37]"));
			List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[40]"));
			boolean checkData = false;
			for (WebElement webElement : lstElement) {
				String isiElement = webElement.getText();
				System.out.println(isiElement);
				if (isiElement.contains(nama) && isiElement.contains(inLink)) {
					checkData = true;
				} else if (isiElement.isBlank()) {
					break;
				} else {
					checkData = false;
				}
			}
			assertTrue(checkData);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
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
