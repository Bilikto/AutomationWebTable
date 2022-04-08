package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebTablePage;

public class WebTableSteps {

    WebTablePage webTablePage = new WebTablePage();

    @Given("open web table")
    public void open_web_table() {
        webTablePage.openWebTable();
    }

    @Then("add a new user to the web table")
    public void add_a_new_user_to_the_web_table() {
        webTablePage.clickAddUserBtn();
    }

    @Then("verify the user has been added to the web table")
    public void verify_the_user_has_been_added_to_the_web_table() {
        webTablePage.verifyUserAdded();

    }

    @Then("delete user with User Name: novak from the web table")
    public void delete_user_with_user_name_novak_from_the_web_table() {
        webTablePage.deleteUserFromWebTable();
    }

    @Then("verify user has been deleted from the web table")
    public void verify_user_has_been_deleted_from_the_web_table() {
        webTablePage.verifyUserDeletedFromWebTable();
    }

}
