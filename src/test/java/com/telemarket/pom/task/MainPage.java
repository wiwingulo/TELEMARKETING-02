package com.telemarket.pom.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	protected WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//font[normalize-space()='Tele Marketing']")
	protected WebElement txtMainPage;

	public String getTextMainPage() {
		return txtMainPage.getText();
	}
	
	@FindBy(xpath = "//span[normalize-space()='DEVELOPER']")
	protected WebElement btnLogoutMainPage;
	
	public void clickBtnLogoutAtMain() {
		btnLogoutMainPage.click();
	}
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div[1]/h3[3]")
	protected WebElement btnTask;
	
	public void clickTask() {
		btnTask.click();
	}

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div[1]/div[3]/div[1]/button")
	protected WebElement btnDataNew;

	public TaskNewPage clickDataNew() {
		btnDataNew.click();
		return PageFactory.initElements(driver, TaskNewPage.class);
	}

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div[1]/div[3]/div[2]/button")
	protected WebElement btnDataAgree;

	public TaskAgreePage clickDataAgree() {
		btnDataAgree.click();
		return PageFactory.initElements(driver, TaskAgreePage.class);
	}

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div[1]/div[3]/div[10]/button")
	protected WebElement btnDataFollowUp;

	public TaskFollowUpPage clickDataFollowUp() {
		btnDataFollowUp.click();
		return PageFactory.initElements(driver, TaskFollowUpPage.class);
	}

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div[1]/div[3]/div[11]/button")
	protected WebElement btnDataAll;

	public TaskDataAllPage clickTaskAll() {
		btnDataAll.click();
		return PageFactory.initElements(driver, TaskDataAllPage.class);
	}

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]/div/div[1]/div[3]/div[13]/button")
	protected WebElement btnTaskFinal;
	
	public TaskFinalPage clickTaskFinal() {
		btnTaskFinal.click();
		return PageFactory.initElements(driver, TaskFinalPage.class);
	}

	/////// POPUP AFTER LOGIN --------------------------------------------
	@FindBy(xpath = "/html/body/div[8]/div[1]/span")
	protected WebElement txtPopUpOnMainPage;

	public String getTextPopUp() {
		return txtPopUpOnMainPage.getText();
	}

	@FindBy(xpath = "//span[normalize-space()='OK']")
	protected WebElement btnOKPopUpOnMainPage;

	public void clickOKPopUpAfterLogin() {
		btnOKPopUpOnMainPage.click();
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnClosePopUpOnMainPage;

	public void clickCancelPopUpAfterLogin() {
		btnClosePopUpLogout.click();
	}

	/////// POPUP LOGOUT ----------------------------------------------------
	@FindBy(xpath = "//span[@id='ui-id-21']")
	protected WebElement txtPopUpLogout;
	
	public String getTextPopUpLogout() {
		return txtPopUpLogout.getText();
	}
	
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnClosePopUpLogout;
	
	public void clickClosePopUpLogout() {
		btnClosePopUpLogout.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='TIDAK'])[1]")
	public WebElement btnNoLogout;
	
	public void clickNOPopUpLogout() {
		btnNoLogout.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='YA'])[1]")
	protected WebElement btnYesLogout;

	public LoginPage logout() {
		btnYesLogout.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
