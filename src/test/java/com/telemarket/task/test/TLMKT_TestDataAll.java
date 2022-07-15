package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

public class TLMKT_TestDataAll {
	
	protected WebDriver driver;
	
	protected TaskDataAllPage allPage;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*1000);
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
	
	private File getLatestFilefromDir(String dirPath) {
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
	
	public boolean verifyDataInTable(String xpath, String data) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
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
	
	public boolean verifyDataInTable(String xpath, String data, String data2, String data3) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			if (isiElement.contains(data) && isiElement.contains(data2) && isiElement.contains(data3)) {
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
		allPage = new TaskDataAllPage(driver);
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
	public void test_all_search_valid(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		assertEquals(allPage.getTextDataAll(),"DATA ALL");
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tbody)[40]", in);
			delay(2);
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
	public void test_all_search_empty_and_unusual(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(4);
		try {
			verifyDataInTable("(//tbody)[40]", in);
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "dataCust")
	public Object[] dataCust() {
		Object[] myData = {"@"};
		return myData;
	}
//
//	@Test(priority = 3, dataProvider="dataCust")
//	public void test_all_search_unusual(String in) {
//		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//		MainPage mainPage = loginPage.loginToMainPage();
//		delay(1);
//		mainPage.clickOKPopUpAfterLogin();
//		delay(1);
//		mainPage.clickTask();
//		delay(1);
//		TaskDataAllPage allPage = mainPage.clickTaskAll();
//		delay(1);
//		allPage.setSearchAll(in);
//		delay(1);
//		allPage.clickSearchDataAll();
//		delay(1);
//		try {
//			verifyDataInTable("(//tr)[43]", in);
//			delay(1);
//		} finally {
//			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//			Reporter.log(file);
//			delay(1);
//		}
//	}
	
	@Test(priority = 4)
	public void test_all_search_agent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String agen = "AGENT01";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickAgent(agen);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
		try {
			verifyDataInTable("(//tbody)[40]", agen);
//			verifyDataInTable("(//tr)[43]", agen);
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
			
	}
	
	@Test(priority = 5)
	public void test_all_search_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
		try {
			verifyDataInTable("(//tbody)[40]", status);
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 6)
	public void test_all_search_customer_agent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Kopi";
		String agen = "AGENT01";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		allPage.clickAgent(agen);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tbody)[40]", cust, agen);
//			verifyDataInTable("(//tr)[43]", cust, agen);
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 7)
	public void test_all_search_customer_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Kopi";
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tr)[43]", cust, status);
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 8)
	public void test_all_search_agent_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String agen = "AGENT01";
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickAgent(agen);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tr)[43]", status, agen);
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 9)
	public void test_all_search_customer_agent_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Cookies";
		String agen = "AGENT01";
		String status = "Setuju";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		allPage.clickAgent(agen);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tr)[43]", cust, agen, status);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@Test(priority = 10)
	public void test_all_export_data() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("kopi");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickExportDataAll();
		delay(4);
		try {
			String downloadPath = "C:\\Users\\nexsoft\\Downloads";
			File getLatestFile = getLatestFilefromDir(downloadPath);
			String fileName = getLatestFile.getName();
			assertTrue(fileName.contains("exportall"), "Data tidak ada/tidak sesuai");
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 11)
	public void testAll_clickTable_gotoActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickLastPagination();
		delay(1);
		allPage.clickFirstPagination();
		delay(1);
		allPage.clickPage1();
		delay(1);
		allPage.clickPage2();
		delay(1);
		allPage.clickPage3();
		delay(1);
		allPage.clickPage4();
		delay(1);
		allPage.clickPage5();
		delay(1);
		allPage.clickPage6();
		delay(1);
		allPage.clickFirstPagination();
		delay(1);
		allPage.viewTable(10);
		delay(1);
		allPage.viewTable(25);
		delay(1);
		allPage.viewTable(50);
		delay(1);
		allPage.viewTable(100);
		delay(1);
		allPage.viewTable(500);
		delay(3);
		allPage.setSearchAll("kopi");
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		allPage.clickTopTable();
		delay(1);
		try {
			assertEquals(allPage.getTextDataAllActivity(), "Data Detail");
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 12)
	public void test_all_search_clickGreen() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Cookies";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		delay(1);
		allPage.clickGreenSearchAll();
		delay(3);
		try {
			verifyDataInTable("(//tr)[43]", cust);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 13)
	public void testDataAllActivity_phoneSelect_phoneAddCancel() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("makanan4160");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0895330144928']")).click(); //berubah tergantung data
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone("0811");
		delay(1);
		allPage.clickCloseMultiAddPhone();
		delay(1);
		allPage.closeDataAllActivity();
		delay(1);
	}

	@Test(priority = 14)
	public void testDataAllActivity_phoneSelect_phoneAdd_valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("makanan4160");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0895330144928']")).click(); //berubah tergantung data
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone("082112345678");
		delay(1);
		allPage.btnSaveMultiAddPhone.click();
		delay(1);
		try {
			assertEquals(allPage.getTextKonfirmasi(), "Konfirmasi");
			delay(1);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "phoneData")
	public Object[] phoneData() {
		Object[] myData = { "0821", "0821123456789011" };
		return myData;
	}

	@Test(priority = 15, dataProvider = "phoneData")
	public void testDataAllActivity_phoneSelect_phoneAdd_invalid(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("MULIA ABADI");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone(in);
		delay(1);
		allPage.btnSaveMultiAddPhone.click();
		delay(2);
		assertEquals(allPage.getTextKonfirmasi(), "Konfirmasi");
		delay(1);
		boolean cek = true;
		try {
			int length = in.length();
			if (length != 12) {
				cek = false;
			}
			assertFalse(cek, "Ukuran data tidak sesuai");
			delay(1);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "phoneCharData")
	public Object[] phoneCharData() {
		Object[] myData = { "aabb", "@#$%" };
		return myData;
	}

	@Test(priority = 16, dataProvider = "phoneCharData", enabled = false)
	public void testDataAllActivity_phoneSelect_phoneAdd_invalidChar(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("MULIA ABADI");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0226077564']")).click(); //berubah tergantung data
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone(in);
		delay(1);
		assertEquals(allPage.txtMultiAddPhone.getText(), in, "Data tidak sesuai!");
		allPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(allPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
		boolean cek = true;
		try {
			int length = in.length();
			if (length != 12) {
				cek = false;
			}
			assertFalse(cek, "Ukuran data tidak sesuai");
			delay(1);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "WAData")
	public Object[][] WAData() {
		Object[][] myData = { { "", "" }, { "", "ini tanpa nomor" }, { "082121212121", "ini pesan wa" },
				{ "082121212121", "" }, { "0821", "ini empat angka" }, { "0821", "" },
				{ "0812345678901213", "ini enam belas" }, { "0812345678901213", "" } };
		return myData;
	}

	@Test(priority = 17, dataProvider = "WAData")
	public void testDataAllActivity_sendWA_validPhone_validMsg(String phone, String msg) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("MULIA ABADI");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.inputDataWA(phone, msg);
		delay(3);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickMessageWA();
		delay(1);
		allPage.clickWA();
		delay(2);
		try {
			assertEquals(allPage.getTextMessageWA(), msg);
			assertEquals(allPage.getTextPhoneWA(), phone);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "statusAct")
	public Object[][] statusAct() {
		Object[][] myData = { 
				{ "kopi", "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "kopi", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } 
				
		};
		return myData;
	}

	@Test(priority = 18, dataProvider = "statusAct")
	public void testDataAllActivity_status_valid(String nama, String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(2);
		allPage.clickSubmit();
		delay(1);
		try {
			assertEquals(allPage.getTextPemberitahuan(), "Apakah Anda Yakin?");
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			allPage.clickClosePemberitahuan();
//			allPage.clickNOPemberitahuan();
			delay(1);
		}
		
	}

	@DataProvider(name = "statusAgree")
	public Object[][] statusAgree() {
		Object[][] myData = { 
				{ "Dakota Club", "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Dakota Club", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "kopi", "Call", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" },
				{ "kopi", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" } 
				};
		return myData;
	}

	@Test(priority = 19, dataProvider = "statusAgree")
	public void testDataAllActivity_status_saveAgree(String nama, String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		allPage.clickSubmit();
		delay(3);
		allPage.clickYESPemberitahuan();
		delay(3);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
//			verifyDataInTable("(//tbody)[40]", nama, reason);
			verifyDataInTable("(//tr)[43]", nama, reason);
			delay(5);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "statusFollowUp")
	public Object[][] statusFollowUp() {
		Object[][] myData = { 
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Telpon Kembali Lain Waktu" },
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Follow Up"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Follow Convert"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Telpon Kembali Lain Waktu" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Follow Up"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Follow Convert"}
		};
		return myData;
	}

	@Test(priority = 20, dataProvider = "statusFollowUp")
	public void testDataAllActivity_status_saveFollowUp(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
//			verifyDataInTable("(//tbody)[40]", nama, statusResult);
			verifyDataInTable("(//tr)[43]", nama, statusResult);
			delay(6);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "statusTolak")
	public Object[][] statusTolak() {
		Object[][] myData = { 
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Bersedia Memberikan Kontak Owner" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Fokus Online" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Tertarik, Tidak Memberi Alasan" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Mengenal Tokko/Bukukas" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Rating/Comment Buruk Tokko di Sosial Media" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Mau Dipersulit Menggunakan Tokko" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Terlalu Banyak Aplikasi atau Platform" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Memory Handphone Penuh" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Punya Android" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Lebih Nyaman Dengan Platform Selain Tokko" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Usaha Sudah Tutup/Bangkrut" },
		};
		return myData;
	}

	@Test(priority = 21, dataProvider = "statusTolak")
	public void testDataAllActivity_status_saveTolak(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(statusResult);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
//			verifyDataInTable("(//tbody)[40]", nama, statusResult);
			verifyDataInTable("(//tr)[43]", nama, statusResult);
			delay(10);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "statusTolakWA")
	public Object[][] statusTolakWA() {
		Object[][] myData = { 
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Bersedia Memberikan Kontak Owner" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Fokus Online" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Tertarik, Tidak Memberi Alasan" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mengenal Tokko/Bukukas" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Rating/Comment Buruk Tokko di Sosial Media" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mau Dipersulit Menggunakan Tokko" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Terlalu Banyak Aplikasi atau Platform" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Memory Handphone Penuh" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Punya Android" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Lebih Nyaman Dengan Platform Selain Tokko" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Usaha Sudah Tutup/Bangkrut" },
		};
		return myData;
	}

	@Test(priority = 22, dataProvider = "statusTolakWA")
	public void testDataAllActivity_status_saveTolak_whatsapp(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(statusResult);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
//			verifyDataInTable("(//tbody)[40]", nama, statusResult);
			verifyDataInTable("(//tr)[43]", nama, statusResult);
			delay(10);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 23)
	public void testDataAllActivity_status_resultBerhasil_reasonBerhasil() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "tokogitardotid";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus("Call","Tersambung","Diangkat","Berhasil","Berhasil");
		delay(1);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		TaskAgreePage agreePage = allPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		try {
			verifyDataInTable("(//tr)[40]", nama, "Berhasil");
			delay(5);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@Test(priority = 24)
	public void testDataAllActivity_statusWA_resultBerhasil_reasonBerhasil() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "tokogitardotid";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus("Whatsapp","Tersambung","Diangkat","Berhasil","Berhasil");
		delay(1);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tr)[40]", nama, "Berhasil");
			delay(5);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "statusInvalid")
	public Object[][] statusInvalid() {
		Object[][] myData = { 
				{"Ragawi","Call","Tersambung","Diangkat","Tidak Berhasil","Tidak Berhasil" },
				{"Grand Am","Call","Tersambung","Salah Sambung","Salah Sambung","Salah Sambung" },
				{"Grand Am","Call","Tersambung","Tidak Diangkat","Tidak Diangkat","Tidak Diangkat" },
				{"Grand Am","Call","Tidak Tersambung","Nomer Salah","Nomer Salah","Nomer Salah" },
				{"Grand Am","Call","Tidak Tersambung","Mailbox","Mailbox","Mailbox" },
				{"Grand Am","Call","Tidak Tersambung","Invalid Number","Tidak Ada Nomor Telepon","Tidak Ada Nomor Telepon" },
				{"Grand Am","Call","Tidak Tersambung","Telepon Not Register","Tidak Terdaftar","Tidak Terdaftar" }
		};
		return myData;
	}
	
	@Test(priority = 25, dataProvider="statusInvalid")
	public void testDataAllActivity_status_invalid(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		try {
			verifyDataInTable("(//tr)[40]", nama, "Berhasil");
			delay(5);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "statusInvalidWA")
	public Object[][] statusInvalidWA() {
		Object[][] myData = { 
				{"Grand Am","Whatsapp","Tersambung","Diangkat","Tidak Berhasil","Tidak Berhasil" },
				{"Grand Am","Whatsapp","Tersambung","Salah Sambung","Salah Sambung","Salah Sambung" },
				{"Grand Am","Whatsapp","Tersambung","Tidak Diangkat","Tidak Diangkat","Tidak Diangkat" },
				{"Grand Am","Whatsapp","Tidak Tersambung","Nomer Salah","Nomer Salah","Nomer Salah" },
				{"Grand Am","Whatsapp","Tidak Tersambung","Mailbox","Mailbox","Mailbox" },
				{"Grand Am","Whatsapp","Tidak Tersambung","Invalid Number","Tidak Ada Nomor Telepon","Tidak Ada Nomor Telepon" },
				{"hei.boo","Whatsapp","Tidak Tersambung","Telepon Not Register","Tidak Terdaftar","Tidak Terdaftar" }
		};
		return myData;
	}
	
	@Test(priority = 26, dataProvider="statusInvalidWA")
	public void testDataAllActivity_statusWA_invalid(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
			verifyDataInTable("(//tr)[43]", nama, reason);
			delay(5);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}
	
	@DataProvider(name = "statusEmpty")
	public Object[][] statusEmpty() {
		Object[][] myData = { 
				{"Dakota Club","Call","Tersambung","Diangkat","","" },
				{"Dakota Club","Whatsapp","Tersambung","","","" },
				{"Dakota Club","Call","","","","" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Setuju","" }
		};
		return myData;
	}
	
	@Test(priority = 27, dataProvider="statusEmpty")
	public void testDataAllActivity_status_empty(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		allPage.clickSubmit();
		delay(2);
		try {
			assertEquals(allPage.getTextPemberitahuanGagal(), "Status Result Wajib Diisi !");
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
		driver.quit();
	}
	
	@AfterTest
	public void clean() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportall.xls");
		file.delete();
	}
}
