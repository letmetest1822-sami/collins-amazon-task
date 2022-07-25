package com.collins.pages;

import com.collins.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonTestPage {

    public AmazonTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='s-suggestion-container']")
    public List<WebElement> searchOptions;

    public void chooseLastOption() {
        searchOptions.get(searchOptions.size()-1).click();
    }

    /*     ***ProductPage***
    Elements and methods after this part may be in another page class according to POM.
     */

    @FindBy(xpath = "(//div[starts-with(@data-asin, 'B0')])[4]")
    public WebElement firstShoe;


    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public  WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='twister-dropdown-highlight transparentTwisterDropdownBorder']")
    public WebElement sizeDropDown;

    @FindBy(id = "size_name_1")
    public WebElement selectSize1;

    public void selectShoeSize() {
        sizeDropDown.click();
        selectSize1.click();
    }

    /*     ***CartPage***
    Elements and methods after this part may be in another page class according to POM.
     */
    @FindBy(xpath = "//a[@href='/gp/cart/view.html?ref_=nav_cart']")
    public WebElement cartButton;


    @FindBy(xpath = "//span[.='Qty:']")
    public WebElement quantityDropDown;

    @FindBy(xpath = "//li[@aria-labelledby='quantity_2']")
    public WebElement quantity3;

    public void selectQuantity() {
        quantityDropDown.click();
        quantity3.click();
    }

    @FindBy (xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    public WebElement unitPrice;

    @FindBy (xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
    public WebElement totalPrice;

    @FindBy(xpath = "//input[@value='Delete']")
    public WebElement deleteFromCartButton;

    @FindBy(id="sc-subtotal-label-activecart")
    public WebElement cartIndicator;

}
