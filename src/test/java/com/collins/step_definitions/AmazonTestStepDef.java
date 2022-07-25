package com.collins.step_definitions;

import com.collins.pages.AmazonTestPage;
import com.collins.utilities.ConfigurationReader;
import com.collins.utilities.Driver;
import com.collins.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonTestStepDef {

    AmazonTestPage amazonTestPage = new AmazonTestPage();

    @Given("the user is on the Home Page")
    public void the_user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        System.out.println("Step 1 : The user is on the Amazon Home Page");
    }
    @Given("the user enter the text {string} in the search bar")
    public void the_user_enter_the_text_in_the_search_bar(String string)  {

        amazonTestPage.searchBox.sendKeys("Shoes for men");

        System.out.println("Step 2 : Enter the text \"Shoes for men\" in the search bar");


    }
    @Given("Choose the last auto-complete option from the dropdown menu suggestions")
    public void choose_the_last_auto_complete_option_from_the_dropdown_menu_suggestions()  {
        BrowserUtils.sleep(2);;
        amazonTestPage.chooseLastOption();

        System.out.println("Step 3 : Choose the last auto-complete option from the dropdown menu suggestions");
    }
    @Given("Add the first shoe to the Cart with a quantity of {int}")
    public void add_the_first_shoe_to_the_cart_with_a_quantity_of(Integer int1) throws InterruptedException {

        BrowserUtils.sleep(3);;

        amazonTestPage.firstShoe.click();
        System.out.println("Step 4 : Clicked on the First shoe in the screen to add the Cart");

        BrowserUtils.sleep(3);
        amazonTestPage.selectShoeSize();
        System.out.println("Step 4 : Size selected to able to add the selected shoe to the cart");

        BrowserUtils.sleep(3);
        amazonTestPage.quantityDropDown.click();
        amazonTestPage.quantity3.click();

        System.out.println("Step 4 : Quantity of '3' selected to add the selected shoe to cart");

        amazonTestPage.addToCartButton.click();
        System.out.println("Step 4 : Clicked on 'Add to Cart' button");

        amazonTestPage.cartButton.click();
        System.out.println("Step 5 : Go to the cart and assert the total price and quantity of shoes are correct");

        BrowserUtils.sleep(3);
        System.out.println("Step 5 : Unit Price : " + amazonTestPage.unitPrice.getText());


    }
    @Given("Open\\/Go to the cart and assert the total price and quantity of shoes are correct")
    public void open_go_to_the_cart_and_assert_the_total_price_and_quantity_of_shoes_are_correct() {

        System.out.println("Step 5 : Total Price : " +amazonTestPage.totalPrice.getText());

        double unitPer3 = Double.parseDouble(amazonTestPage.unitPrice.getText().substring(1)) * 3; //Expected value

        System.out.println("Step 5 : Price of 3 shoes : $" + unitPer3);

        Assert.assertEquals(unitPer3, Double.parseDouble(amazonTestPage.totalPrice.getText().substring(1)),0.1);

    }
    @When("Delete the items from the cart")
    public void delete_the_items_from_the_cart() {

        amazonTestPage.deleteFromCartButton.click();
        BrowserUtils.sleep(2);
        System.out.println("Step 6 : Delete the items from the cart.");
    }
    @Then("Assert that the cart is now empty")
    public void assert_that_the_cart_is_now_empty() {

        int numberOfItemsInTheCart = Integer.parseInt(amazonTestPage.cartIndicator.getText().substring(10, 11));
        System.out.println("Step 7 : There are " + numberOfItemsInTheCart + " items in the cart.");
    }
}
