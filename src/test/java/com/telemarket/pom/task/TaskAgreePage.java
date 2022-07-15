package com.telemarket.pom.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskAgreePage extends MainPage{
	protected WebDriver driver;

	public TaskAgreePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "tl_agree--52771_text")
	protected WebElement txtDataAgree;

	public String getTextAgree() {
		return txtDataAgree.getAttribute("value");
	}
	
	@FindBy(xpath = "(//input[@id='tl_agree--52770_text'])[1]")
	protected WebElement inputSearchAgree;
	
	@FindBy(xpath = "(//button[@id='52776_query'])[1]")
	protected WebElement btnSearchAgree;
	
	public void searchDataAgree(String inString) {
		inputSearchAgree.clear();
		inputSearchAgree.sendKeys(inString);
		btnSearchAgree.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='Export'])[1]")
	protected WebElement btnExportAgree;
	
	public void clickExportAgree() {
		btnExportAgree.click();
	}
	
	@FindBy(xpath = "(//tr)[41]")
	protected WebElement topTable;

	public void clickTopTable() {
		topTable.click();
	}
	
	//////// ACTIVITY ----------------------------
	@FindBy(id = "tl_user_activity_agree-1212-52861_text")
	protected WebElement txtAgreeActivity;

	public String getTextAgreeActivity() {
		return txtAgreeActivity.getAttribute("value");
	}
	
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")
	protected WebElement btnCloseAgreeActivity;
	
	public void closeAgreeActivity() {
		btnCloseAgreeActivity.click();
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[9]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/input[1]")
	protected WebElement setLink;
	
	public void setLinkActivity(String in) {
		setLink.sendKeys(in);
	}
	
	@FindBy(xpath = "//span[normalize-space()='UPDATE']")
	protected WebElement btnUpdateLinkActivity;
	
	public void clickUpdateLink() {
		btnUpdateLinkActivity.click();
	}
	
	@FindBy(xpath = "(//span[@id='ui-id-21'])[1]")
	protected WebElement txtInformasi;
	
	public String getTextInformasi() {
		return txtInformasi.getText();
	}
	
	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick'])[1]")
	protected WebElement btnCloseInformasiActivity;
	
	public void clickCloseInformasiActivity() {
		btnCloseInformasiActivity.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	protected WebElement btnOKInformasiActivity;
	
	public void clickOKInformasiActivity() {
		btnOKInformasiActivity.click();
	}
	
	/////// PAGINATION ---------------------------
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

	@FindBy(xpath = "(//td[contains(text(),'10')])[3]")
	public WebElement check10;
	
	@FindBy(xpath = "(//td[contains(text(),'25')])[3]")
	public WebElement check25;
	
	@FindBy(xpath = "(//td[contains(text(),'50')])[3]")
	public WebElement check50;
	
	@FindBy(xpath = "(//td[contains(text(),'100')])[3]")
	public WebElement check100;
	
	@FindBy(xpath = "(//td[contains(text(),'500')])[3]")
	public WebElement check500;

	@FindBy(xpath = "(//a[@href='#'][normalize-space()='<<'])[1]")
	protected WebElement btnFirstPagination;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='>>'])[1]")
	protected WebElement btnLastPagination;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='1'])[1]")
	protected WebElement btnPage1;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='2'])[1]")
	protected WebElement btnPage2;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='3'])[1]")
	protected WebElement btnPage3;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='4'])[1]")
	protected WebElement btnPage4;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='5'])[1]")
	protected WebElement btnPage5;
	
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='6'])[1]")
	protected WebElement btnPage6;

	public void clickFirstPagination() {
		btnFirstPagination.click();
	}

	public void clickLastPagination() {
		btnLastPagination.click();
	}

	public void clickPage1() {
		btnPage1.click();
	}

	public void clickPage2() {
		btnPage2.click();
	}

	public void clickPage3() {
		btnPage3.click();
	}

	public void clickPage4() {
		btnPage4.click();
	}

	public void clickPage5() {
		btnPage5.click();
	}

	public void clickPage6() {
		btnPage6.click();
	}
}
