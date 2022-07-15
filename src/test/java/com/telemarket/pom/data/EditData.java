package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditData {

	public WebDriver driver;
	
	@FindBy(id = "tl_edit_data--52532_text")
	protected WebElement inputSearchNew;
	
	@FindBy(xpath = "(//option[@value='AGENT03'])[1]")
	protected WebElement agent03;
	
	@FindBy(xpath = "//span[normalize-space()='Search']")
	protected WebElement btnSearchNew;
	
	@FindBy(xpath = "(//img[@id='tl_edit_data--52532_finder'])[1]")
	public WebElement btnGreenSearch;
	
	@FindBy(xpath = "(//input[@id='tl_agree--52770_text'])[1]")
	protected WebElement inputSearchAgree;
	
	@FindBy(xpath = "(//button[@id='52776_query'])[1]")
	protected WebElement btnSearchAgree;
	public EditData(WebDriver driver) {
		this.driver = driver;
	}
	
/////// STATUS ACTIVITY ------------------------------------------------
	@FindBy(xpath = "//option[@value='Call']")
	protected WebElement btnChannel_Call;

	@FindBy(xpath = "(//option[@value='Tersambung'])")
	protected WebElement btnStatus_Tersambung;

	@FindBy(xpath = "//option[@value='Diangkat']")
	protected WebElement btnStatusCall_Diangkat;

	@FindBy(xpath = "//option[@value='Setuju']")
	protected WebElement btnStatusResult_Setuju;

	@FindBy(xpath = "//option[@value='Berhasil Download']")
	protected WebElement btnReason_BerhasilDownload;

	@FindBy(xpath = "//option[@value='Follow Up Download']")//option[@value='Follow Up Download']
	protected WebElement btnReason_FollowUpDownload;

	@FindBy(xpath = "//option[@value='Follow Up']")
	protected WebElement btnStatusResult_FollowUp;

	@FindBy(xpath = "//option[@value='Telpon Kembali Lain Waktu']")
	protected WebElement btnReason_TelponKembali;

	@FindBy(xpath = "//option[@value='Request Kirim Whatsapp Untuk Dipelajari']")
	protected WebElement btnReason_RequestKirim;

	@FindBy(xpath = "//option[@value='Minta Nomer Manager/Pemilik']")
	protected WebElement btnReason_MintaNomer;

	@FindBy(xpath = "//option[@value='Minta Pendapat Partner/Pasangan/Orangtua']")
	protected WebElement btnReason_MintaPendapat;

	@FindBy(xpath = "(//option[@value='Follow Up'][normalize-space()='Follow Up'])[2]")
	protected WebElement btnReason_FollowUp;

	@FindBy(xpath = "//option[@value='Follow Convert']")
	protected WebElement btnReason_FollowConvert;

	@FindBy(xpath = "//option[@value='Tolak']")
	protected WebElement btnStatusResult_Tolak;

	@FindBy(xpath = "//option[@value='Tidak Bersedia Memberikan Kontak Owner']")
	protected WebElement btnReason_TidakBersedia;

	@FindBy(xpath = "//option[@value='Tidak Fokus Online']")
	protected WebElement btnReason_TidakFokus;

	@FindBy(xpath = "//option[@value='Tidak Tertarik, Tidak Memberi Alasan']")
	protected WebElement btnReason_TidakTertarik;

	@FindBy(xpath = "//option[@value='Tidak Mengerti dan Tidak Bersedia Dijelaskan']")
	protected WebElement btnReason_TidakMengerti;

	@FindBy(xpath = "//option[@value='Tidak Mengenal Tokko/Bukukas']")
	protected WebElement btnReason_TidakMengenal;

	@FindBy(xpath = "//option[@value='Rating/Comment Buruk Tokko di Sosial Media']")
	protected WebElement btnReason_RatingComment;

	@FindBy(xpath = "//option[@value='Tidak Mau Dipersulit Menggunakan Tokko']")
	protected WebElement btnReason_TidakMau;

	@FindBy(xpath = "//option[@value='Terlalu Banyak Aplikasi atau Platform']")
	protected WebElement btnReason_TerlaluBanyak;

	@FindBy(xpath = "//option[@value='Memory Handphone Penuh']")
	protected WebElement btnReason_MemoryHandphone;

	@FindBy(xpath = "//option[@value='Tidak Punya Android']")
	protected WebElement btnReason_TidakPunya;

	@FindBy(xpath = "//option[@value='Lebih Nyaman Dengan Platform Selain Tokko']")
	protected WebElement btnReason_LebihNyaman;

	@FindBy(xpath = "//option[@value='Usaha Sudah Tutup/Bangkrut']")
	protected WebElement btnReason_UsahaSudahTutup;

	@FindBy(xpath = "//option[@value='Berhasil']")
	protected WebElement btnStatusResult_Berhasil;

	@FindBy(xpath = "(//option[@value='Berhasil'][normalize-space()='Berhasil'])[2]")
	protected WebElement btnReason_Berhasil;

	@FindBy(xpath = "//option[@value='Tidak Berhasil']")
	protected WebElement btnStatusResult_TidakBerhasil;

	@FindBy(xpath = "(//option[@value='Tidak Berhasil'][normalize-space()='Tidak Berhasil'])[2]")
	protected WebElement btnReason_TidakBerhasil;

	@FindBy(xpath = "//option[@value='Salah Sambung']")
	protected WebElement btnStatusCall_SalahSambung;

	@FindBy(xpath = "(//option[@value='Salah Sambung'][normalize-space()='Salah Sambung'])[2]")
	protected WebElement btnStatusResult_SalahSambung;

	@FindBy(xpath = "(//option[@value='Salah Sambung'][normalize-space()='Salah Sambung'])[3]")
	protected WebElement btnReason_SalahSambung;

	@FindBy(xpath = "//option[@value='Tidak Diangkat']")
	protected WebElement btnStatusCall_TidakDiangkat;

	@FindBy(xpath = "(//option[@value='Tidak Diangkat'][normalize-space()='Tidak Diangkat'])[2]")
	protected WebElement btnStatusResult_TidakDiangkat;

	@FindBy(xpath = "(//option[@value='Tidak Diangkat'][normalize-space()='Tidak Diangkat'])[3]")
	protected WebElement btnReason_TidakDiangkat;

	@FindBy(xpath = "//option[@value='Tidak Tersambung']")
	protected WebElement btnStatus_TidakTersambung;

	@FindBy(xpath = "//option[@value='Nomer Salah']")
	protected WebElement btnStatusCall_NomerSalah;

	@FindBy(xpath = "(//option[@value='Nomer Salah'][normalize-space()='Nomer Salah'])[2]")
	protected WebElement btnStatusResult_NomerSalah;

	@FindBy(xpath = "(//option[@value='Nomer Salah'][normalize-space()='Nomer Salah'])[3]")
	protected WebElement btnReason_NomerSalah;

	@FindBy(xpath = "//option[@value='Mailbox']")
	protected WebElement btnStatusCall_Mailbox;

	@FindBy(xpath = "(//option[@value='Mailbox'][normalize-space()='Mailbox'])[2]")
	protected WebElement btnStatusResult_Mailbox;

	@FindBy(xpath = "(//option[@value='Mailbox'][normalize-space()='Mailbox'])[3]")
	protected WebElement btnReason_Mailbox;

	@FindBy(xpath = "//option[@value='Invalid Number']")
	protected WebElement btnStatusCall_InvalidNumber;

	@FindBy(xpath = "(//option[@value='Tidak Ada Nomor Telepon'][normalize-space()='Tidak Ada Nomor Telepon'])[1]")
	protected WebElement btnStatusResult_TidakAda;

	@FindBy(xpath = "(//option[@value='Tidak Ada Nomor Telepon'][normalize-space()='Tidak Ada Nomor Telepon'])[2]")
	protected WebElement btnReason_TidakAda;

	@FindBy(xpath = "//option[@value='Telepon Not Register ']")
	protected WebElement btnStatusCall_TeleponNot;

	@FindBy(xpath = "(//option[@value='Tidak Terdaftar'][normalize-space()='Tidak Terdaftar'])[1]")
	protected WebElement btnStatusResult_TidakTerdaftar;

	@FindBy(xpath = "(//option[@value='Tidak Terdaftar'][normalize-space()='Tidak Terdaftar'])[2]")
	protected WebElement btnReason_TidakTerdaftar;

	@FindBy(xpath = "//option[@value='Whatsapp']")
	protected WebElement btnChannel_WA;
	
	@FindBy(xpath = "(//tr)[40]")
	protected WebElement topTable;

	public void clickTopTable() {
		topTable.click();
	}
	
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")
	protected WebElement btnCloseNewActivity;

	public void clickCloseActivityNew() {
		btnCloseNewActivity.click();
	}	


	public void clickStatus(String status, String statusCall, String statusResult, String reason) {
		
		switch (status) {
		case "Tersambung":
			btnStatus_Tersambung.click();
			delay(1);
			switch (statusCall) {
			case "Diangkat":
				btnStatusCall_Diangkat.click();
				delay(1);
				switch (statusResult) {
				case "Setuju":
					btnStatusResult_Setuju.click();
					delay(1);
					switch (reason) {
					case "Berhasil Download":
						btnReason_BerhasilDownload.click();
						break;
					case "Follow Up Download":
						btnReason_FollowUpDownload.click();
						break;
					default:
						break;
					}
					break;
				case "Follow Up":
					btnStatusResult_FollowUp.click();
					delay(1);
					switch (reason) {
					case "Telpon Kembali Lain Waktu":
						btnReason_TelponKembali.click();
						break;
					case "Request Kirim Whatsapp Untuk Dipelajari":
						btnReason_RequestKirim.click();
						break;
					case "Minta Nomer Manager/Pemilik":
						btnReason_MintaNomer.click();
						break;
					case "Minta Pendapat Partner/Pasangan/Orangtua":
						btnReason_MintaPendapat.click();
						break;
					case "Follow Up":
						btnReason_FollowUp.click();
						break;
					case "Follow Convert":
						btnReason_FollowConvert.click();
						break;
					default:
						break;
					}
					break;
				case "Tolak":
					btnStatusResult_Tolak.click();
					delay(1);
					switch (reason) {
					case "Tidak Bersedia Memberikan Kontak Owner":
						btnReason_TidakBersedia.click();
						break;
					case "Tidak Fokus Online":
						btnReason_TidakFokus.click();
						break;
					case "Tidak Tertarik, Tidak Memberi Alasan":
						btnReason_TidakTertarik.click();
						break;
					case "Tidak Mengerti dan Tidak Bersedia Dijelaskan":
						btnReason_TidakMengerti.click();
						break;
					case "Tidak Mengenal Tokko/Bukukas":
						btnReason_TidakMengenal.click();
						break;
					case "Rating/Comment Buruk Tokko di Sosial Media":
						btnReason_RatingComment.click();
						break;
					case "Tidak Mau Dipersulit Menggunakan Tokko":
						btnReason_TidakMau.click();
						break;
					case "Terlalu Banyak Aplikasi atau Platform":
						btnReason_TerlaluBanyak.click();
						break;
					case "Memory Handphone Penuh":
						btnReason_MemoryHandphone.click();
						break;
					case "Tidak Punya Android":
						btnReason_TidakPunya.click();
						break;
					case "Lebih Nyaman Dengan Platform Selain Tokko":
						btnReason_LebihNyaman.click();
						break;
					case "Usaha Sudah Tutup/Bangkrut":
						btnReason_UsahaSudahTutup.click();
						break;
					default:
						break;
					}
					break;
				case "Berhasil":
					btnStatusResult_Berhasil.click();
					delay(1);
					if (reason.equals("Berhasil")) {
						btnReason_Berhasil.click();
					}
					break;
				case "Tidak Berhasil":
					btnStatusResult_TidakBerhasil.click();
					delay(1);
					if (reason.equals("Tidak Berhasil")) {
						btnReason_TidakBerhasil.click();
					}
					break;
				default:
					break;
				}
				break;
			case "Salah Sambung":
				btnStatusCall_SalahSambung.click();
				delay(1);
				if (statusResult.equals("Salah Sambung")) {
					btnStatusResult_SalahSambung.click();
					delay(1);
					if (reason.equals("Salah Sambung")) {
						btnReason_SalahSambung.click();
					}
				}
				break;
			case "Tidak Diangkat":
				btnStatusCall_TidakDiangkat.click();
				delay(1);
				if (statusResult.equals("Tidak Diangkat")) {
					btnStatusResult_TidakDiangkat.click();
					delay(1);
					if (reason.equals("Tidak Diangkat")) {
						btnReason_TidakDiangkat.click();
					}
				}
				break;
			default:
				break;
			}
			break;
		case "Tidak Tersambung":
			btnStatus_TidakTersambung.click();
			delay(1);
			switch (statusCall) {
			case "Nomer Salah":
				btnStatusCall_NomerSalah.click();
				delay(1);
				if (statusResult.equals("Nomer Salah")) {
					btnStatusResult_NomerSalah.click();
					delay(1);
					if (reason.equals("Nomer Salah")) {
						btnReason_NomerSalah.click();
					}
				}
				break;
			case "Mailbox":
				btnStatusCall_Mailbox.click();
				delay(1);
				if (statusResult.equals("Mailbox")) {
					btnStatusResult_Mailbox.click();
					delay(1);
					if (reason.equals("Mailbox")) {
						btnReason_Mailbox.click();
					}
				}
				break;
			case "Invalid Number":
				btnStatusCall_InvalidNumber.click();
				delay(1);
				if (statusResult.equals("Tidak Ada Nomor Telepon")) {
					btnStatusResult_TidakAda.click();
					delay(1);
					if (reason.equals("Tidak Ada Nomor Telepon")) {
						btnReason_TidakAda.click();
					}
				}
				break;
			case "Telepon Not Register":
				btnStatusCall_TeleponNot.click();
				delay(1);
				if (statusResult.equals("Tidak Terdaftar")) {
					btnStatusResult_TidakTerdaftar.click();
					delay(1);
					if (reason.equals("Tidak Terdaftar")) {
						btnReason_TidakTerdaftar.click();
					}
				}
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	@FindBy(xpath = "(//span[normalize-space()='UPDATE'])[1]")
	protected WebElement btnSubmit;

	public void clickSubmit() {
		btnSubmit.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	protected WebElement btnOk;

	public void close() {
		btnOk.click();
		delay(2);
	}
	
	@FindBy(xpath = "//p[normalize-space()='Data Berhasil di Update !']")
	protected WebElement checkPemberitahuan;

	public String getTextPemberitahuan() {
		return checkPemberitahuan.getText();
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnPemberitahuanClose;

	public void clickClosePemberitahuan() {
		btnPemberitahuanClose.click();
	}

	@FindBy(xpath = "//span[normalize-space()='NO']")
	protected WebElement btnPemberitahuanNO;

	public void clickNOPemberitahuan() {
		btnPemberitahuanNO.click();
	}

	@FindBy(xpath = "//span[normalize-space()='YES']")
	protected WebElement btnPemberitahuanYES;

	public void clickYESPemberitahuan() {
		btnPemberitahuanYES.click();
	}
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void searchDataNew(String inString) {
		inputSearchNew.clear();
		inputSearchNew.sendKeys(inString);
		btnSearchNew.click();
	}
	
	public void inputSearch(String nama) {
		inputSearchNew.sendKeys(nama);
	}
	
	public void clickBtnGreen(String name) {
		inputSearchNew.clear();
		inputSearchNew.sendKeys(name);
		btnGreenSearch.click();
	}
	
	public void chooseAgent() {
		agent03.click();
		delay(1);
	}
	
	public void searchDataAgree(String inString) {
		inputSearchAgree.clear();
		inputSearchAgree.sendKeys(inString);
		btnSearchAgree.click();
	}

	
}