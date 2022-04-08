package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTablePage extends BasePage {

    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    WebElement addUSerBtn;

    @FindBy(xpath = "//input[@name='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='UserName']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='Password']")
    WebElement password;

    @FindBy(xpath = "//label[text()='Company AAA']")
    WebElement customerA;

    @FindBy(xpath = "//select[@name='RoleId']")
    WebElement roleDropdown;

    @FindBy(xpath = "//input[@name='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    WebElement cellPhone;

    @FindBy(xpath = "//button[@ng-click='save(user)']")
    WebElement saveBtn;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']/tbody")
    WebElement table;

    List<WebElement> rowList;
    List<WebElement> columnList;

    public void clickAddUserBtn() {
        addUSerBtn.click();
        fillUserDetails();
    }

    public void fillUserDetails() {
        firstName.sendKeys("Elon");
        lastName.sendKeys("Mask");
        userName.sendKeys("tesla");
        password.sendKeys("abc123");
        customerA.click();
        Select dropdownSelect = new Select(roleDropdown);
        dropdownSelect.selectByValue("1");
        email.sendKeys("elonmusk@gmail.com");
        cellPhone.sendKeys("111222333");
        saveBtn.click();
    }

    public void verifyUserAdded() {
        rowList = table.findElements(By.tagName("tr"));
        columnList = rowList.get(0).findElements(By.tagName("td"));
        Assert.assertTrue(columnList.get(0).getText().contains("Elon"));
    }

    public void openWebTable() {
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
    }

    public void deleteUserFromWebTable() {
        List<WebElement> deleteBtnList = table.findElements(By.xpath("//td/button[@ng-click='delUser()']/i"));
        deleteBtnList.get(2).click();
        WebElement modalWindow = driver.findElement(By.xpath("//div[@class='modal-footer']/button[2]"));
        modalWindow.click();
    }

    public void verifyUserDeletedFromWebTable() {
        rowList = table.findElements(By.tagName("tr"));
        columnList = rowList.get(2).findElements(By.tagName("td"));
//        System.out.println(columnList.get(2).getText());
        Assert.assertFalse(columnList.get(2).getText().equals("novak"));
    }
}
