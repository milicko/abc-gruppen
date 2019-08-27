package abcGruppen.designHat;

import base.BaseTest;
import org.openqa.selenium.By;

public class DesignFreelyView extends BaseTest {
    public static final String NEXT = "//button[text()='Fortsätt →']";
    public static final String TEMPLATE_SELECT_TAG = "//li[@class='tag-selector'][text()='%s']";
    public static final String TEMPLATE_ACTIVE_TAG = "//li[@class='tag-selector active'][text()='%s']";
    public static final String CONTINIUE = "//button[text()='Gå vidare →']";
    public static final String CHECKOUT = "//button[text()='Gå till kassan']";
    public static final String INPUT_FIELD = "//input";


    /**
     * This method gets text for selected tag and it converts string to integer
     *
     * @return price that appears for selected tag
     */
    public int getPriceForSelectedTag() {
        return getPriceFromSelector("//span[@class='selection-price']");
    }

    /**
     * This method gets text for selected tag and it converts string to integer
     *
     * @return price that appears for selected tag
     */
    public int getPriceForAddedText() {
        return getPriceForAddedText("//span[@class='price']");
    }

    /**
     * This method gets current price from shopping cart (upper right shopping cart)
     *
     * @return actual price in upper rignt shopping cart
     */
    public int getPriceFromShoppingCart() {
        return getPriceFromSelector("//span[@class='navbar-price ml-1']");
    }

    /**
     * This method gets sum price from checkout page
     *
     * @return - sum chart from checkout page
     */
    public int getSumPrice() {
        return getPriceFromSelector("//dt[@class='total']//span[@class='price']");
    }

    private int getPriceFromSelector(String locator) {
        String price = getDriver().findElement(By.xpath(locator)).getText();
        return Integer.parseInt(price);

    }

    private int getPriceForAddedText(String locator) {
        String price = getDriver().findElement(By.xpath(locator)).getText();
        String split[] = price.split(" ");
        return Integer.parseInt(split[1]);

    }

    /**
     * Sets deserted text in input field
     *
     * @param text - text that you want to add
     * @return DesignFreelyView
     */
    public DesignFreelyView setText(String text) {
        typeKeys(INPUT_FIELD, text);
        pause(500);
        return this;
    }

    /**This method selects tag
     * @param tagName
     * @return
     */
    public DesignFreelyView selectTag(String tagName) {
        waitForVisible(String.format(TEMPLATE_SELECT_TAG, tagName));
        click(String.format(TEMPLATE_SELECT_TAG, tagName));
        waitForVisible(String.format(TEMPLATE_ACTIVE_TAG, tagName));
        return this;
    }

    public DesignFreelyView next() {
        click(NEXT);
        pause(1000);
        return this;
    }

    public DesignFreelyView continuee() {
        click(CONTINIUE);
        return this;
    }

    public DesignFreelyView goToCheckout() {
        click(CHECKOUT);
        return this;
    }


}
