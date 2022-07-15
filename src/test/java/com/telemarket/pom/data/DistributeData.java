package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DistributeData {

	public WebDriver driver;

	@FindBy(xpath = "(//span[@id='ddcl-tl_distribute--52078_select'])[1]")
	public WebElement dropdownBuketData;

	@FindBy(xpath = "(//span[@class='ui-dropdownchecklist-selector ui-state-default1'])[1]")
	public WebElement dropdownStatus;

	@FindBy(xpath = "(//th[normalize-space()='nama_agent'])[1]")
	public WebElement hover;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i1'])[1]")
	public WebElement statusNull;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i0'])[1]")
	public WebElement buketDataNull;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i0'])[1]")
	public WebElement statusNew;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i2'])[1]")
	public WebElement statusAgree;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i3'])[1]")
	public WebElement statusBerhasil;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i4'])[1]")
	public WebElement statusCallBack;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i5'])[1]")
	public WebElement statusCustomerNotAvailable;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i6'])[1]")
	public WebElement statusDisagree;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i7'])[1]")
	public WebElement statusFollowup;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i8'])[1]")
	public WebElement statusInvalidNumber;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i9'])[1]")
	public WebElement statusMailbox;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i10'])[1]")
	public WebElement statusMissCustomer;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i11'])[1]")
	public WebElement statusNoBodyPickup;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i12'])[1]")
	public WebElement statusNomerSalah;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i13'])[1]")
	public WebElement statusSalahSambung;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i14'])[1]")
	public WebElement statusSetuju;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i15'])[1]")
	public WebElement statusTelponNotRegister;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i16'])[1]")
	public WebElement statusThinking;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i17'])[1]")
	public WebElement statusTidakAdaNomorTelepon;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i18'])[1]")
	public WebElement statusTidakBerhasil;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i19'])[1]")
	public WebElement statusTidakDiangkat;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i20'])[1]")
	public WebElement statusTidakTerdaftar;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i21'])[1]")
	public WebElement statusTolak;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52075_select-i22'])[1]")
	public WebElement statusWrongNumber;

	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	public WebElement btnOk;

	@FindBy(xpath = "//span[normalize-space()='View']")
	public WebElement btnView;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i4'])[1]")
	public WebElement agent01;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i7'])[1]")
	public WebElement agent03;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i11'])[1]")
	public WebElement agent07;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i18'])[1]")
	public WebElement agentRidho;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i19'])[1]")
	public WebElement spv01;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52078_select-i2'])[1]")
	public WebElement agentAdmin;

	// Menu Distribute to Agent
	@FindBy(xpath = "(//span[@title='�'])[1]")
	public WebElement dropdownAgent;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i0'])[1]")
	public WebElement agentspv;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i1'])[1]")
	public WebElement agentdev;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i2'])[1]")
	public WebElement agentadm;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i3'])[1]")
	public WebElement agentDian;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i4'])[1]")
	public WebElement agentRiska;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i5'])[1]")
	public WebElement agentKat;

	@FindBy(xpath = "(//input[@id='ddcl-tl_distribute--52066_select-i6'])[1]")
	public WebElement agentRid;

	@FindBy(xpath = "(//input[@id='tl_distribute--52070_text'])[1]")
	public WebElement jlhAgent;

	@FindBy(xpath = "(//select[@id='tl_distribute--52079_text'])[1]")
	public WebElement dropdownExisting;

	@FindBy(xpath = "(//option[@value='NEW'])[1]")
	public WebElement dropdownNew;

	@FindBy(xpath = "(//span[normalize-space()='Distribusi'])[1]")
	public WebElement btnDistribusi;
	
	@FindBy (xpath = "(//span[normalize-space()='Ya'])[1]")
	public WebElement btnYa;
	
	@FindBy (xpath = "(//span[normalize-space()='Tidak'])[1]")
	public WebElement btnTidak;

	public DistributeData(WebDriver driver) {
		this.driver = driver;
	}

	public void openDropDownStatus() {
		dropdownStatus.click();
	}

	public void openDropDownBuket() {
		dropdownBuketData.click();
	}

	public void clickStatusNull() {
		statusNull.click();
		statusNew.click();
	}

	public void click1DropDownAgent() {
		agentAdmin.click();
	}

	public void clickBuketDataNull() {
		buketDataNull.click();
	}

	public void click1BuketData() {
		buketDataNull.click();
		agent01.click();
	}

	public void click2BuketData() {
		buketDataNull.click();
		agentAdmin.click();
		agent01.click();
	}

	public void click3BuketData() {
		buketDataNull.click();
		agentAdmin.click();
		agent01.click();
		agent03.click();
	}

	public void clickView() {
		btnView.click();
	}

	public void clickStatusAgree() {
		statusNull.click();
		statusNew.click();
		statusAgree.click();
	}

	public void clickStatusBerhasil() {
		statusNull.click();
		statusNew.click();
		statusBerhasil.click();
	}

	public void clickStatusCallBack() {
		statusNull.click();
		statusNew.click();
		statusCallBack.click();
	}

	public void clickStatusCustomerNotAvail() {
		statusNull.click();
		statusNew.click();
		statusCustomerNotAvailable.click();
	}

	public void clickStatusDisagree() {
		statusNull.click();
		statusNew.click();
		statusDisagree.click();
	}

	public void clickStatusFollowup() {
		statusNull.click();
		statusNew.click();
		statusFollowup.click();
	}

	public void clickStatusInvalidNumber() {
		statusNull.click();
		statusNew.click();
		statusInvalidNumber.click();
	}

	public void clickStatusMailbox() {
		statusNull.click();
		statusNew.click();
		statusMailbox.click();
	}

	public void clickStatusMissCustomer() {
		statusNull.click();
		statusNew.click();
		statusMissCustomer.click();
	}

	public void clickStatusNoBodyPickup() {
		statusNull.click();
		statusNew.click();
		statusNoBodyPickup.click();
	}

	public void clickStatusNomerSalah() {
		statusNull.click();
		statusNew.click();
		statusNomerSalah.click();
	}

	public void clickStatusSalahSambung() {
		statusNull.click();
		statusNew.click();
		statusSalahSambung.click();
	}

	public void clickTelponNotRegister() {
		statusNull.click();
		statusNew.click();
		statusTelponNotRegister.click();
	}

	public void clickStatusThinking() {
		statusNull.click();
		statusNew.click();
		statusThinking.click();
	}

	public void clickStatusTidakAdaNomorTelepon() {
		statusNull.click();
		statusNew.click();
		statusTidakAdaNomorTelepon.click();
	}

	public void clickStatusSetuju() {
		statusNull.click();
		statusNew.click();
		statusSetuju.click();
	}

	public void clickStatusTidakBerhasil() {
		statusNull.click();
		statusNew.click();
		statusTidakBerhasil.click();
	}

	public void clickStatusTidakDiangkat() {
		statusNull.click();
		statusNew.click();
		statusTidakDiangkat.click();
	}

	public void clickStatusTidakTerdaftar() {
		statusNull.click();
		statusNew.click();
		statusTidakTerdaftar.click();
	}

	public void clickStatusTolak() {
		statusNull.click();
		statusNew.click();
		statusTolak.click();
	}

	public void clickStatusWrongNumber() {
		statusNull.click();
		statusNew.click();
		statusWrongNumber.click();
	}

	public void clickAllBuketData() {
		buketDataNull.click();
		agentAdmin.click();
		agent01.click();
		agent03.click();
		agent07.click();
		agentRidho.click();
		spv01.click();
	}

	public void clickStatusNew() {
		statusNull.click();
	}

	// Menu Distribusi
	public void choose1Agent() {
		dropdownAgent.click();
		agentDian.click();
	}

	public void choose2Agent() {
		dropdownAgent.click();
		agentDian.click();
		agentRiska.click();
	}

	public void chooseAllAgent() {
		dropdownAgent.click();
		agentspv.click();
		agentdev.click();
		agentadm.click();
		agentDian.click();
		agentRiska.click();
		agentKat.click();
		agentRid.click();
	}

	public void inputJlhAgent(String jumlah) {
		jlhAgent.sendKeys(jumlah);
	}
	
	public void clickStatusNewDistribute() {
		
		dropdownNew.click();
		
	}

	public void clickDistribute() {
		btnDistribusi.click();
	}
}
