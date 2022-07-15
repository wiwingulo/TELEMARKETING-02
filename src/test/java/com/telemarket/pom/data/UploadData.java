package com.telemarket.pom.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadData {

	public WebDriver driver;

	@FindBy(xpath = "//input[@id='tl_upload_new--52043_text']")
	public WebElement btnUpload;

	@FindBy(xpath = "//span[normalize-space()='Upload']")
	public WebElement btnUploadExcel;

	@FindBy(xpath = "//span[normalize-space()='Simpan']")
	public WebElement btnSimpan;

	@FindBy(xpath = "(//span[normalize-space()='SIMPAN'])[1]")
	public WebElement btnSimpan1;

	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[3]/div[1]/button[1]/span[1]")
	public WebElement btnOKUpload;

	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	public WebElement btnOkWrongData;

	
	public UploadData(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uploadData() {
		btnUpload.sendKeys("D:\\Data.xlsx");
		delay(2);
		btnUploadExcel.click();
		delay(5);
	}

	public void saveData() {
		btnSimpan.click();
		delay(2);
		btnSimpan1.click();
		delay(5);
		btnOKUpload.click();
		delay(5);
	}

	public void uploadDataWrongFormat() {
		btnUpload.sendKeys("D:\\testdata.png");
		delay(10);
		btnUploadExcel.click();
		delay(5);
	
	}
	public void save() {
		btnOkWrongData.click();
		delay(1);
	}


}
