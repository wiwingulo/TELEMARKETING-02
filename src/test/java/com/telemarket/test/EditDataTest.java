package com.telemarket.test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.data.EditData;
import com.telemarket.pom.data.UploadData;
import com.telemarket.pom.page.Dashboard;
import com.telemarket.pom.page.LoginPage;
import com.telemarket.pom.page.MainPage;
import com.telemarket.pom.page.Utilities;
import com.telemarket.pom.task.TaskAgreePage;

public class EditDataTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected EditData edit;
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

	@DataProvider(name = "statusAct")
	public Object[][] statusAct() {
		Object[][] myData = { { "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } };
		return myData;
	}

	@Test(priority = 1, dataProvider = "statusAct")
	public void editDataTersambungBerhasilDownload(String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);

		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);

		edit.searchDataNew("Mustang");
		delay(1);
		edit.clickTopTable();
		delay(2);
		edit.clickStatus(status, statusCall, statusResult, reason);
		delay(2);
		edit.clickSubmit();
		delay(1);

		// assert
		assertEquals(edit.getTextPemberitahuan(), "Data Berhasil di Update !");
		delay(2);

		edit.close();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@DataProvider(name = "statusAct2")
	public Object[][] statusAct2() {
		Object[][] myData = { { "Tersambung", "Diangkat", "Setuju", "Follow Up Download" } };
		return myData;
	}

	@Test(priority = 2, dataProvider = "statusAct2")
	public void editDataTersambungFollowUp(String status, String statusCall, String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);

		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);

		edit.searchDataNew("Space");
		delay(1);
		edit.clickTopTable();
		delay(2);
		edit.clickStatus(status, statusCall, statusResult, reason);
		delay(2);
		edit.clickSubmit();
		delay(1);

		// assert
		assertEquals(edit.getTextPemberitahuan(), "Data Berhasil di Update !");
		delay(2);

		edit.close();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@DataProvider(name = "statusFollowUp")
	public Object[][] statusFollowUp() {
		Object[][] myData = { { "Tersambung", "Diangkat", "Follow Up", "Telpon Kembali Lain Waktu" },
				{ "Tersambung", "Diangkat", "Follow Up", "Request Kirim Whatsapp Untuk Dipelajari" },
				{ "Tersambung", "Diangkat", "Follow Up", "Minta Nomer Manager/Pemilik" },
				{ "Tersambung", "Diangkat", "Follow Up", "Minta Pendapat Partner/Pasangan/Orangtua" },
				{ "Tersambung", "Diangkat", "Follow Up", "Follow Up" },
				{ "Tersambung", "Diangkat", "Follow Up", "Follow Convert" } };
		return myData;
	}

	@Test(priority = 3, dataProvider = "statusFollowUp")
	public void testNewActivity_status_saveFollowUp(String status, String statusCall, String statusResult,
			String reason) {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		String nama = "Dakota Club";
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);

		edit.searchDataNew(nama);
		delay(1);
		edit.clickTopTable();
		delay(1);
		edit.clickStatus(status, statusCall, statusResult, reason);
		delay(3);

		edit.clickSubmit();
		delay(2);
		edit.close();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@DataProvider(name = "statusTolak")
	public Object[][] statusTolak() {
		Object[][] myData = { { "Tersambung", "Diangkat", "Tolak", "Tidak Bersedia Memberikan Kontak Owner" },
				{ "Tersambung", "Diangkat", "Tolak", "Tidak Fokus Online" },
				{ "Tersambung", "Diangkat", "Tolak", "Tidak Tertarik, Tidak Memberi Alasan" },
				{ "Tersambung", "Diangkat", "Tolak", "Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{ "Tersambung", "Diangkat", "Tolak", "Tidak Mengenal Tokko/Bukukas" },
				{ "Tersambung", "Diangkat", "Tolak", "Rating/Comment Buruk Tokko di Sosial Media" },
				{ "Tersambung", "Diangkat", "Tolak", "Tidak Mau Dipersulit Menggunakan Tokko" },
				{ "Tersambung", "Diangkat", "Tolak", "Terlalu Banyak Aplikasi atau Platform" },
				{ "Tersambung", "Diangkat", "Tolak", "Memory Handphone Penuh" },
				{ "Tersambung", "Diangkat", "Tolak", "Tidak Punya Android" },
				{ "Tersambung", "Diangkat", "Tolak", "Lebih Nyaman Dengan Platform Selain Tokko" },
				{ "Tersambung", "Diangkat", "Tolak", "Usaha Sudah Tutup/Bangkrut" }, };
		return myData;
	}

	@Test(priority = 4, dataProvider = "statusTolak")
	public void testNewActivity_status_saveTolak(String status, String statusCall, String statusResult, String reason) {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		String nama = "Grand Am";
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);

		edit.searchDataNew(nama);
		delay(1);
		edit.clickTopTable();
		delay(1);
		edit.clickStatus(status, statusCall, statusResult, reason);
		delay(3);

		edit.clickSubmit();
		delay(2);
		edit.close();
		delay(1);
		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	@DataProvider(name = "statusInvalid")
	public Object[][] statusInvalid() {
		Object[][] myData = { { "Ragawi", "Tersambung", "Diangkat", "Tidak Berhasil", "Tidak Berhasil" },
				{ "Grand Am", "Tersambung", "Salah Sambung", "Salah Sambung", "Salah Sambung" },
				{ "Grand Am", "Tersambung", "Tidak Diangkat", "Tidak Diangkat", "Tidak Diangkat" },
				{ "Grand Am", "Tidak Tersambung", "Nomer Salah", "Nomer Salah", "Nomer Salah" },
				{ "Grand Am", "Tidak Tersambung", "Mailbox", "Mailbox", "Mailbox" },
				{ "Grand Am", "Tidak Tersambung", "Invalid Number", "Tidak Ada Nomor Telepon",
						"Tidak Ada Nomor Telepon" },
				{ "Grand Am", "Tidak Tersambung", "Telepon Not Register", "Tidak Terdaftar", "Tidak Terdaftar" } };
		return myData;
	}

	@Test(priority = 5, dataProvider = "statusInvalid")
	public void testFollowUpActivity_status_invalid(String nama, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);

		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);

		edit.searchDataNew(nama);
		delay(1);
		edit.clickTopTable();
		delay(2);
		edit.clickStatus(status, statusCall, statusResult, reason);
		delay(2);
		edit.clickSubmit();
		delay(2);
		edit.close();
		delay(1);

		// logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
		driver.close();
	}

	// fail
	@Test(priority = 6)
	public void testNewActivity_status_resultBerhasil_reasonBerhasil() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		String nama = "Ascender";
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);

		edit.searchDataNew(nama);
		delay(1);
		edit.clickTopTable();
		delay(1);
		edit.chooseAgent();
		delay(1);
		edit.clickStatus("Tersambung", "Diangkat", "Berhasil", "Berhasil");
		delay(1);
		edit.clickSubmit();
		delay(2);

		edit.close();
		delay(1);
		// assert
		dash.clickDataAgree();
		delay(1);
		edit.searchDataAgree(nama);
		delay(1);
		try {
			util.verifyDataInTable("(//tr)[40]", nama, "Berhasil");
			delay(5);
		} finally {
			delay(1);
			String file = "<img src='file://" + util.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(1);
			delay(1);
			// logout
			dash.clickBtnLogoutAtMain();
			delay(1);
			dash.logout();
			delay(2);
			driver.close();
		}
	}

}
