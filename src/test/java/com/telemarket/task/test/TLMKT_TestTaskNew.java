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

public class TLMKT_TestTaskNew {

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
			System.out.println(isiElement);
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

	public boolean verifyDataInTable(String xpath, String data1, String data2) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(data1) && isiElement.contains(data2)) {
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

	@Test(priority = 1)
	public void testSPVNew_validSearch() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String in = "Warung kopi";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(in);
		delay(2);
		verifyDataInTable("(//tr)[41]", in);
		delay(3);
	}

	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void testSPVNew_searchEmptyUnusual(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(in);
		delay(2);
		try {
			verifyDataInTable("(//tr)[41]", in);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}

	}

	@Test(priority = 3)
	public void testSPVNew_export() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.clickExportNew();
		delay(3);
		try {
			String downloadPath = "C:\\Users\\nexsoft\\Downloads";
			File getLatestFile = getLatestFilefromDir(downloadPath);
			String fileName = getLatestFile.getName();
			assertTrue(fileName.contains("exportnew"), "Data tidak ada/tidak sesuai");
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}

	}

	@Test(priority = 4)
	public void testSPVNew_goToActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.clickLastPagination();
		delay(1);
		newPage.clickFirstPagination();
		delay(1);
		newPage.clickPage1();
		delay(1);
		newPage.clickPage2();
		delay(1);
		newPage.clickPage3();
		delay(1);
		newPage.clickPage4();
		delay(1);
		newPage.clickPage5();
		delay(1);
		newPage.clickPage6();
		delay(1);
		newPage.clickFirstPagination();
		delay(1);
		newPage.viewTable(10);
		delay(1);
		newPage.viewTable(25);
		delay(1);
		newPage.viewTable(50);
		delay(1);
		newPage.viewTable(100);
		delay(1);
		newPage.viewTable(500);
		delay(2);
		newPage.searchDataNew("lumina");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		try {
			assertEquals(newPage.getTextNewActivity(), "Data Detail");
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@Test(priority = 5)
	public void testSPVNew_phoneSelect_phoneAddCancel() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.setPhone.click();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone("0811");
		delay(1);
		newPage.clickCloseMultiAddPhone();
		delay(3);
	}

	@Test(priority = 6)
	public void testSPVNew_validPhoneAdd() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.setPhone.click();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone("082112345678");
		delay(1);
		newPage.btnSaveMultiAddPhone.click();
		delay(1);
		try {
			assertEquals(newPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
			delay(1);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
//			newPage.btnCloseKonfirmasi.click();
			newPage.btnSaveKonfirmasi.click();
			delay(3);
		}

	}

	@DataProvider(name = "phoneData")
	public Object[] phoneData() {
		Object[] myData = { "0821", "0821123456789011" };
		return myData;
	}

	@Test(priority = 7, dataProvider = "phoneData")
	public void testSPVNew_invalidPhoneAdd(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone(in);
		delay(1);
		newPage.btnSaveMultiAddPhone.click();
		delay(2);
		assertEquals(newPage.txtDataKonfirmasi.getText(), "Data Berhasil Diajukan!");
		delay(1);
		boolean cek = true;
		int length = in.length();
		try {
			if (length != 12) {
				cek = false;
			}
			assertFalse(cek, "Ukuran data tidak sesuai");
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(2);
			newPage.btnSaveKonfirmasi.click();
			delay(3);
		}

	}

	@Test(priority = 8)
	public void testSPVNew_charPhoneAdd() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String in = "@";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.setPhone.click();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone(in);
		delay(1);
		newPage.btnSaveMultiAddPhone.click();
		delay(2);
		try {
			assertEquals(newPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
			delay(1);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(2);
		}
	}

	@DataProvider(name = "WAData")
	public Object[][] WAData() {
		Object[][] myData = { { "", "" }, { "", "ini tanpa nomor" }, { "082121212121", "ini pesan wa" },
				{ "082121212121", "" }, { "0821", "ini empat angka" }, { "0821", "" },
				{ "0812345678901213", "ini enam belas" }, { "0812345678901213", "" } };
		return myData;
	}

	@Test(priority = 9, dataProvider = "WAData")
	public void testSPVNew_sendWA_validPhoneMessage(String phone, String msg) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("Yopi Kopi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.inputDataWA(phone, msg);
		delay(1);
		newPage.clickCloseActivityNew();
		delay(1);
		newPage.clickBtnWA();
		delay(1);
		newPage.clickBtnMessageWA();
		delay(1);
		try {
			assertEquals(newPage.getTextMessageWA(), msg);
			assertEquals(newPage.getTextPhoneWA(), phone);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "statusAct")
	public Object[][] statusAct() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } };
		return myData;
	}

	@Test(priority = 10, dataProvider = "statusAct")
	public void testSPVNew_validStatus(String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("Grand Am");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(2);
		newPage.clickSubmit();
		delay(1);
		try {
			assertEquals(newPage.getTextPemberitahuan(), "Apakah Anda Yakin?");
			delay(2);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
//			newPage.clickClosePemberitahuan();
			newPage.clickNOPemberitahuan();
			delay(1);
		}

	}

	@DataProvider(name = "statusAgree")
	public Object[][] statusAgree() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } };
		return myData;
	}

	@Test(priority = 11, dataProvider = "statusAgree")
	public void testSPVNew_validStatus_saveAgree(String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Grand Am";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(3);
		newPage.clickYESPemberitahuan();
		delay(3);
		TaskAgreePage agreePage = newPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		try {
//			verifyDataInTable("(//tbody)[38]", nama, statusResult);
			verifyDataInTable("(//tr)[41]", nama, statusResult);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "statusFollowUp")
	public Object[][] statusFollowUp() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" },
				{ "Call", "Tersambung", "Diangkat", "Follow Up", "Telpon Kembali Lain Waktu" },
				{ "Call", "Tersambung", "Diangkat", "Follow Up", "Request Kirim Whatsapp Untuk Dipelajari" },
				{ "Call", "Tersambung", "Diangkat", "Follow Up", "Minta Nomer Manager/Pemilik" },
				{ "Call", "Tersambung", "Diangkat", "Follow Up", "Minta Pendapat Partner/Pasangan/Orangtua" },
				{ "Call", "Tersambung", "Diangkat", "Follow Up", "Follow Up" },
				{ "Call", "Tersambung", "Diangkat", "Follow Up", "Follow Convert" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Follow Up", "Telpon Kembali Lain Waktu" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Follow Up", "Request Kirim Whatsapp Untuk Dipelajari" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Follow Up", "Minta Nomer Manager/Pemilik" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Follow Up", "Minta Pendapat Partner/Pasangan/Orangtua" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Follow Up", "Follow Up" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Follow Up", "Follow Convert" } };
		return myData;
	}

	@Test(priority = 12, dataProvider = "statusFollowUp")
	public void testSPVNew_validStatus_saveFollowUp(String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Grand Am";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFollowUpPage followUpPage = newPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		try {
//			verifyDataInTable("(//tbody)[38]", nama, statusResult);
			verifyDataInTable("(//tr)[41]", nama, statusResult);
			delay(3);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@DataProvider(name = "statusTolak")
	public Object[][] statusTolak() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Bersedia Memberikan Kontak Owner" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Fokus Online" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Tertarik, Tidak Memberi Alasan" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Mengenal Tokko/Bukukas" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Rating/Comment Buruk Tokko di Sosial Media" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Mau Dipersulit Menggunakan Tokko" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Terlalu Banyak Aplikasi atau Platform" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Memory Handphone Penuh" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Tidak Punya Android" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Lebih Nyaman Dengan Platform Selain Tokko" },
				{ "Call", "Tersambung", "Diangkat", "Tolak", "Usaha Sudah Tutup/Bangkrut" }, };
		return myData;
	}

	@Test(priority = 13, dataProvider = "statusTolak")
	public void testSPVNew_validStatus_saveTolak(String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Grand Am";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFinalPage finalPage = newPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(2);
		try {
//			verifyDataInTable("(//tbody)[37]", nama, statusResult);
			verifyDataInTable("(//tr)[40]", nama, statusResult);
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
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Bersedia Memberikan Kontak Owner" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Fokus Online" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Tertarik, Tidak Memberi Alasan" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Mengenal Tokko/Bukukas" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Rating/Comment Buruk Tokko di Sosial Media" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Mau Dipersulit Menggunakan Tokko" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Terlalu Banyak Aplikasi atau Platform" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Memory Handphone Penuh" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Tidak Punya Android" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Lebih Nyaman Dengan Platform Selain Tokko" },
				{ "Whatsapp", "Tersambung", "Diangkat", "Tolak", "Usaha Sudah Tutup/Bangkrut" }, };
		return myData;
	}

	@Test(priority = 14, dataProvider = "statusTolakWA")
	public void testSPVNew_validStatusWA_saveTolak(String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Grand Am";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFinalPage finalPage = newPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(2);
		try {
//			verifyDataInTable("(//tbody)[37]", nama, statusResult);
			verifyDataInTable("(//tr)[40]", nama, statusResult);
			delay(10);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
		}
	}

	@Test(priority = 15)
	public void testSPVNew_validStatus_resultReasonBerhasil() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "	Grand Am";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus("Call", "Tersambung", "Diangkat", "Berhasil", "Berhasil");
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFinalPage finalPage = newPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(2);
		try {
//			verifyDataInTable("(//tbody)[37]", nama, "Berhasil");
			verifyDataInTable("(//tr)[40]", nama, "Berhasil");
			delay(5);
		} finally {
			String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);

		}
	}

	@Test(priority = 16)
	public void testSPVNew_validStatusWA_resultReasonBerhasil() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Grand Am";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus("Whatsapp", "Tersambung", "Diangkat", "Berhasil", "Berhasil");
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFinalPage finalPage = newPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(2);
		try {
//			verifyDataInTable("(//tbody)[37]", nama, "Berhasil");
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
		Object[][] myData = { { "Grand Am", "Call", "Tersambung", "Diangkat", "Tidak Berhasil", "Tidak Berhasil" },
				{ "Grand Am", "Call", "Tersambung", "Salah Sambung", "Salah Sambung", "Salah Sambung" },
				{ "Grand Am", "Call", "Tersambung", "Tidak Diangkat", "Tidak Diangkat", "Tidak Diangkat" },
				{ "Grand Am", "Call", "Tidak Tersambung", "Nomer Salah", "Nomer Salah", "Nomer Salah" },
				{ "Grand Am", "Call", "Tidak Tersambung", "Mailbox", "Mailbox", "Mailbox" },
				{ "Grand Am", "Call", "Tidak Tersambung", "Invalid Number", "Tidak Ada Nomor Telepon",
						"Tidak Ada Nomor Telepon" },
				{ "Grand Am", "Call", "Tidak Tersambung", "Telepon Not Register", "Tidak Terdaftar",
						"Tidak Terdaftar" } };
		return myData;
	}

	@Test(priority = 17, dataProvider = "statusInvalid")
	public void testSPVNew_invalidStatus(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskDataAllPage allPage = newPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
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

	@DataProvider(name = "statusInvalidWA")
	public Object[][] statusInvalidWA() {
		Object[][] myData = { { "Grand Am", "Whatsapp", "Tersambung", "Diangkat", "Tidak Berhasil", "Tidak Berhasil" },
				{ "Grand Am", "Whatsapp", "Tersambung", "Salah Sambung", "Salah Sambung", "Salah Sambung" },
				{ "Grand Am", "Whatsapp", "Tersambung", "Tidak Diangkat", "Tidak Diangkat", "Tidak Diangkat" },
				{ "Grand Am", "Whatsapp", "Tidak Tersambung", "Nomer Salah", "Nomer Salah", "Nomer Salah" },
				{ "Grand Am", "Whatsapp", "Tidak Tersambung", "Mailbox", "Mailbox", "Mailbox" },
				{ "Grand Am", "Whatsapp", "Tidak Tersambung", "Invalid Number", "Tidak Ada Nomor Telepon",
						"Tidak Ada Nomor Telepon" },
				{ "Grand Am", "Whatsapp", "Tidak Tersambung", "Telepon Not Register", "Tidak Terdaftar",
						"Tidak Terdaftar" } };
		return myData;
	}

	@Test(priority = 18, dataProvider = "statusInvalidWA")
	public void testSPVNew_invalidStatusWA(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskDataAllPage allPage = newPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
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

	@DataProvider(name = "statusEmpty")
	public Object[][] statusEmpty() {
		Object[][] myData = { { "Grand Am", "Call", "Tersambung", "Diangkat", "", "" },
				{ "Grand Am", "Whatsapp", "Tersambung", "", "", "" }, { "Grand Am", "Call", "", "", "", "" },
				{ "Grand Am", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "" } };
		return myData;
	}

	@Test(priority = 19, dataProvider = "statusEmpty")
	public void testSPVNew_emptyStatus(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(2);
		try {
			assertEquals(newPage.getTextPemberitahuanGagal(), "Pemberitahuan !");
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
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportnew.xls");
		file.delete();
	}
}
