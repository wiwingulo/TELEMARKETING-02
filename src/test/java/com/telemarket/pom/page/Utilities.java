package com.telemarket.pom.page;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Utilities {

	public WebDriver driver;
	public JavascriptExecutor jse;

	@FindBy(xpath = "(//li)[3]")
	public WebElement btn2;

	@FindBy(xpath = "(//li)[4]")
	public WebElement btn3;

	@FindBy(xpath = "(//li)[5]")
	public WebElement btn4;

	@FindBy(xpath = "(//li)[6]")
	public WebElement btn5;

	@FindBy(xpath = "(//li)[7]")
	public WebElement lastStep;
	
	@FindBy(xpath = "(//li)[8]")
	public WebElement lastStepPageEdit;
	
	@FindBy(xpath = "(//li)[3]")
	public WebElement lastStepPageUser;
	

	@FindBy(xpath = "(//li)[1]")
	public WebElement firstStep;

	@FindBy(xpath = "//option[@value='10']")
	protected WebElement value10;
	@FindBy(xpath = "//option[@value='25']")
	protected WebElement value25;
	@FindBy(xpath = "//option[@value='50']")
	protected WebElement value50;
	@FindBy(xpath = "//option[@value='100']")
	protected WebElement value100;
	@FindBy(xpath = "//option[@value='500']")
	protected WebElement value500;
	@FindBy(xpath = "(//select[@id='tl_upload_new--52045_show_text'])[1]")
	public WebElement showPage;

	public Utilities(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
	}
	
	public void scroll() {
		jse.executeScript("window.scrollBy(0,1000)");
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifKolomSource(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("DIKA")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public boolean verifDataArray(String xpathIsi, String refArray[]) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		boolean finalCheckData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();

			for (String i : refArray) {
				System.out.println(i);
				if (isiElement.equalsIgnoreCase(i)) {
					checkData = true;
				} else if (isiElement.isBlank()) {
					break;
				} else {
					checkData = false;
				}
				if (checkData = true) {
					finalCheckData = true;
				}
			}
		}
		assertTrue(finalCheckData);

		return finalCheckData;
	}

	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "C:\\Users\\Nexsoft\\eclipse-workspace\\Telemarketing02\\hasilScreenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	public boolean verifBDName(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public boolean verifMerchantName(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Grand Am")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public boolean verifSourceOfLead(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Dixie Stitchwort")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public boolean verifPhone(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("815-551-9860")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public boolean verifSegment(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Medium / Small Social Seller")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public void viewTable(int in) {
		switch (in) {
		case 10:
			value10.click();
			break;
		case 25:
			value25.click();
			break;
		case 50:
			value50.click();
			break;
		case 100:
			value100.click();
			break;
		case 500:
			value500.click();
			break;
		default:
			break;
		}
	}

	public void testButtonPage() {
		btn2.click();
		delay(1);
		btn3.click();
		delay(1);
		btn4.click();
		delay(1);
		btn5.click();
		delay(1);
		lastStep.click();
		delay(1);
		firstStep.click();
		delay(1);
	}
	
	public void testButtonPageEdit() {
		btn2.click();
		delay(1);
		btn3.click();
		delay(1);
		btn4.click();
		delay(1);
		btn5.click();
		delay(1);
		lastStepPageEdit.click();
		delay(1);
		firstStep.click();
		delay(1);
	}
	
	public void testButtonPageUser() {
		
		lastStepPageUser.click();
		delay(1);
		firstStep.click();
		delay(1);
	}
	
	public boolean verifAgentNull(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Pilih User yang akan didistribusikan")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	public boolean verifJumlahNull(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Jumlah tidak boleh Kosong")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	public boolean verifDistributeSuccess(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Apa Yakin Distribusi ?")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public boolean verifChangePass(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("PASSWORD BERHASIL DI RESET")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public boolean verifPassNull(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Isi terlebih dahulu")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public boolean verifStatusNull(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Status Tidak Boleh Kosong")) {
				checkData = true;

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
	
}
