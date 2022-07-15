package com.telemarket.pom.message;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.telemarket.pom.page.*;

public class User {

	public WebDriver driver;
	public Utilities util;

	@FindBy(xpath = "(//input[@id='tl_user_management--51690_text'])[1]")
	public WebElement inputSearchUser;

	@FindBy(xpath = "(//img[@id='tl_user_management--51690_finder'])[1]")
	public WebElement btnGreenSearch;

	@FindBy(xpath = "(//span[normalize-space()='Search'])[1]")
	public WebElement btnSearchUser;

	@FindBy(xpath = "(//span[normalize-space()='Add'])[1]")
	public WebElement btnAdd;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51730_text'])[1]")
	public WebElement inputFullName;

	@FindBy(xpath = "(//select[@id='tl_agent_editable-14-51731_text'])[1]")
	public WebElement selectPriv;

	@FindBy(xpath = "(//select[@id='tl_agent_editable-14-51733_text'])[1]")
	public WebElement selectSpv;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51736_text'])[1]")
	public WebElement inputTelephone;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51746_text'])[1]")
	public WebElement inputExtension;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51740_text'])[1]")
	public WebElement inputUsername;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51741_text'])[1]")
	public WebElement inputPassword;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-21-51738_text'])[1]")
	public WebElement inputUserActive;

	@FindBy(xpath = "(//span[normalize-space()='Save'])[1]")
	public WebElement btnSave;

	@FindBy(xpath = "(//span[normalize-space()='Yes'])[1]")
	public WebElement btnYes;

	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	public WebElement btnOk;

	@FindBy(xpath = "(//span[normalize-space()='No'])[1]")
	public WebElement btnNo;

	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick'])[1]")
	public WebElement btnCancel;

	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-close'])[1]")
	public WebElement btnClose;

	@FindBy(xpath = "(//span[normalize-space()='Reset Password'])[1]")
	public WebElement btnResetPass;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[1]")
	public WebElement centangUserSpv;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[2]")
	public WebElement centangUser2;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[3]")
	public WebElement centangUserDev;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[4]")
	public WebElement centangUser4;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[5]")
	public WebElement centangUser5;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[6]")
	public WebElement centangUser6;

	@FindBy(xpath = "(//input[@name='tl_user_management--51688_text'])[7]")
	public WebElement centangUser7;

	@FindBy(xpath = "(//span[normalize-space()='DONE'])[1]")
	public WebElement btnDone;

	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[3]/div[1]/button[2]/span[1]")
	public WebElement btnYesPass;

	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[3]/div[1]/button[1]/span[1]")
	public WebElement btnNoPass;

	@FindBy(xpath = "(//span)[62]")
	public WebElement btnCancelPass2;

	// update user
	@FindBy(xpath = "(//img)[16]")
	public WebElement btnEditTesting;

	@FindBy(xpath = "(//span[@class='ui-button-text'][normalize-space()='Update'])[2]")
	public WebElement btnUpdate;

	@FindBy(xpath = "(//input[@id='tl_agent_editable-21-51730_text'])[1]")
	public WebElement updateInputUsername;
	@FindBy(xpath = "(//select[@id='tl_agent_editable-21-51731_text'])[1]")
	public WebElement updatePrivilleges;
	@FindBy(xpath = "(//select[@id='tl_agent_editable-21-51733_text'])[1]")
	public WebElement updateSpv;
	@FindBy(xpath = "(//input[@id='tl_agent_editable-21-51736_text'])[1]")
	public WebElement updatePhone;
	@FindBy(xpath = "(//input[@id='tl_agent_editable-21-51738_text'])[1]")
	public WebElement updateActive;
	@FindBy(xpath = "(//input[@id='tl_agent_editable-21-51746_text'])[1]")
	public WebElement updateExtension;
	@FindBy(xpath = "(//input[@id='tl_agent_editable-21-51740_text'])[1]")
	public WebElement updateUsername;

	// update password
	@FindBy(xpath = "(//span[normalize-space()='Update Password'])[1]")
	public WebElement updatePassword;

	@FindBy(xpath = "(//input[@id='tl_agent_edit_pass-1000-51754_text'])[1]")
	public WebElement inputNewPass;

	@FindBy(xpath = "(//span[@class='ui-button-text'][normalize-space()='Update'])[3]")
	public WebElement updateNewPass;

	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-close'])[1]")
	public WebElement btnCancelPass;

	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[3]/div[1]/button[2]/span[1]")
	public WebElement btnYesNewPass;

	@FindBy(xpath = "(//span[normalize-space()='No'])[1]")
	public WebElement btnNoNewPass;

	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick'])[1]")
	public WebElement btnCancelNewPass;

	// delete user

	@FindBy(xpath = "(//img)[19]")
	private WebElement btnDelete;

	@FindBy(xpath = "(//img)[17]")
	private WebElement btnDelete2;

	@FindBy(xpath = "(//span[normalize-space()='Ya'])[1]")
	private WebElement btnYaDelete;

	@FindBy(xpath = "(//span[normalize-space()='Tidak'])[1]")
	private WebElement btnTidakDelete;

	public User(WebDriver driver) {
		this.driver = driver;
	}

	public void searchDataNew(String inString) {
		inputSearchUser.clear();
		inputSearchUser.sendKeys(inString);
		btnSearchUser.click();
	}

	public void searchDataNewWithGreenBtn(String inString) {
		inputSearchUser.clear();
		inputSearchUser.sendKeys(inString);
		btnGreenSearch.click();
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addAgentFullNameNull(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {

		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Full Name harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);

	}

	public void addAgentPrivillegesNull(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Privilleges harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgentSupervisorNull(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Supervisor harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgentPhoneNull(String fullname, String priv, String spv, String phone, String extension, String user,
			String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Nomor telepon harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgentPhoneSpecialChar(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Nomor telepon harus berisi angka")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgentExtensionNull(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Extension harus diisi dengan angka")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgentUsernameOnlyNumber(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Username harus mengandung huruf")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgentSameUsername(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Duplicate entry")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void addAgent(String fullname, String priv, String spv, String phone, String extension, String user,
			String pass, String xpathIsi) {
		Utilities util = PageFactory.initElements(driver, Utilities.class);

		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);

		util.viewTable(50);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();
			System.out.println(status);
			System.out.println(user);
			if (status.equalsIgnoreCase(user)) {
				checkData = true;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		delay(1);

	}

	public void addAgentPassNumber(String fullname, String priv, String spv, String phone, String extension,
			String user, String pass, String xpathIsi) {
		Utilities util = PageFactory.initElements(driver, Utilities.class);
		btnAdd.click();
		delay(1);
		inputFullName.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(selectPriv);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(selectSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		inputTelephone.sendKeys(phone);
		delay(1);
		inputExtension.sendKeys(extension);
		delay(1);
		inputUsername.clear();
		inputUsername.sendKeys(user);
		delay(1);
		inputPassword.clear();
		inputPassword.sendKeys(pass);
		delay(1);
		btnSave.click();
		delay(1);
		btnYes.click();
		delay(1);
		
		util.viewTable(50);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();
			System.out.println(status);
			System.out.println(user);
			if (status.equalsIgnoreCase(user)) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		delay(1);

	}

	public void resetPassOneUser() {
		centangUserSpv.click();
		delay(1);
		btnResetPass.click();
		delay(1);
		btnYesPass.click();
		delay(1);

	}

	public void resetPassTwoUser() {
		centangUserSpv.click();
		delay(1);
		centangUserDev.click();
		delay(1);
		btnResetPass.click();
		delay(1);
		btnYesPass.click();
		delay(1);

	}

	public void resetNullUser(String xpathIsi) {
		btnResetPass.click();
		delay(2);
		btnYesPass.click();
		delay(2);
		btnDone.click();
		
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();
			System.out.println(status);
		
			if (status.equalsIgnoreCase("Silahkan check user yang ingin direset")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		delay(1);

	}

	public void checkButtonUser() {
		btnResetPass.click();
		delay(1);
		btnNoPass.click();
		delay(1);
		btnResetPass.click();
		delay(1);
		btnCancel.click();
	}

	public void clickBtnDone() {
		btnDone.click();
		delay(1);
	}

	public void resetPassAllUser() {
		centangUserSpv.click();
		delay(1);
		centangUserDev.click();
		delay(1);
		centangUser4.click();
		delay(1);
		centangUser5.click();
		delay(1);
		centangUser6.click();
		delay(1);
		centangUser7.click();
		delay(1);
		btnResetPass.click();
		delay(1);
		btnYesPass.click();
		delay(1);

	}

	public void updateAgentFullNameNull(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Full Name harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);

	}

	public void updateAgentPrivNull(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Privilleges harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void updateAgentSpvNull(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Supervisor harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void updateAgentPhoneNull(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Nomor telepon harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void updateAgentUserActive(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Dropdown")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		delay(1);

	}

	public void updateAgentExtensionNull(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Extension harus diisi dengan angka")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}


	public void updateAgentUsernameNull(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Username harus diisi")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		delay(1);

	}
	
	public void updateAgentUsernameOnlyNumber(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("Username harus diisi huruf dan angka")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		delay(1);

	}


	public void updateAgentSameUsername(String fullname, String priv, String spv, String phone, String useract,
			String extension, String user, String xpathIsi) {
		btnEditTesting.click();
		delay(1);
		updateInputUsername.clear();
		updateInputUsername.sendKeys(fullname);
		delay(1);
		Select selectPrivileges = new Select(updatePrivilleges);
		selectPrivileges.selectByVisibleText(priv);
		delay(1);
		Select selectSupervisor = new Select(updateSpv);
		selectSupervisor.selectByVisibleText(spv);
		delay(1);
		updatePhone.clear();
		updatePhone.sendKeys(phone);
		delay(1);
		updateActive.clear();
		updateActive.sendKeys(useract);
		updateExtension.clear();
		updateExtension.sendKeys(extension);
		delay(1);
		updateUsername.clear();
		updateUsername.sendKeys(user);
		delay(1);
		btnUpdate.click();
		delay(1);
		btnYes.click();
		delay(1);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.contains("Duplicate entry")) {
				checkData = true;

			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		btnOk.click();
		delay(1);
	}

	public void checkButtonUpdate() {
		btnEditTesting.click();
		delay(1);
		btnUpdate.click();
		delay(1);
		btnCancel.click();
		delay(1);
		btnUpdate.click();
		delay(1);
		btnNo.click();
	}

	public void updateNewPassNull(String newPass) {
		btnEditTesting.click();
		delay(1);
		updatePassword.click();
		delay(1);
		inputNewPass.clear();
		inputNewPass.sendKeys(newPass);
		delay(1);
		updateNewPass.click();
		delay(1);

	}

	public void updateNewPass(String newPass) {
		btnEditTesting.click();
		delay(1);
		updatePassword.click();
		delay(1);
		inputNewPass.clear();
		inputNewPass.sendKeys(newPass);
		delay(1);
		updateNewPass.click();
		delay(2);
		btnYesNewPass.click();
		delay(1);
		btnCancelPass.click();

	}

	public void btnSavePassNull() {
		btnOk.click();
		delay(1);
		btnCancelPass.click();
	}

	public void checkUpdateButton(String newPass) {
		btnEditTesting.click();
		delay(1);
		updatePassword.click();
		delay(1);
		inputNewPass.clear();
		inputNewPass.sendKeys(newPass);
		delay(1);
		updateNewPass.click();
		delay(2);
		btnNoNewPass.click();
		delay(1);
		btnCancelPass.click();

	}

	public void deleteUser() {
		btnDelete.click();
		delay(1);
		btnYaDelete.click();
		delay(1);
	}

	public void cancelDeleteUser() {
		btnDelete2.click();
		delay(1);
		btnTidakDelete.click();
		delay(1);
	}

}
