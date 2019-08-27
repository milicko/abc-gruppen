package abcGruppen.designHat;

import base.BaseTest;
import org.openqa.selenium.By;

public class DesignFreelyView extends BaseTest {
    public static final String INPUT_LEFT = "//div[@class='input-container']//input[@class='form-control input-left']";
    public static final String INPUT_RIGHT = "//div[@class='input-container']//input[@class='form-control input-right']";
    public static final String NEXT = "//button[text()='Fortsätt →']";
    public static final String TEMPLATE_SELECT_TAG = "//li[@class='tag-selector'][text()='%s']";
    public static final String TEMPLATE_ACTIVE_TAG = "//li[@class='tag-selector active'][text()='%s']";
    public static final String CONTINIUE = "//button[text()='Gå vidare →']";
    public static final String CHECKOUT = "//button[text()='Gå till kassan']";

    /**
     * This method sets text in left input field
     *
     * @param text - text that you want to type
     * @return DesignFreelyView
     */
    public DesignFreelyView setTextInLeftInput(String text) {
        typeKeys(INPUT_LEFT, text);
        return this;
    }

    /**
     * This method sets text in right input field
     *
     * @param text - text that you want to type
     * @return DesignFreelyView
     */
    public DesignFreelyView setTextInRightInput(String text) {
        typeKeys(INPUT_RIGHT, text);
        return this;
    }

    public int getPriceFromSelector(String locator) {
        String price = getDriver().findElement(By.xpath(locator)).getText();

        return Integer.parseInt(price);

    }

    public DesignFreelyView selectTag(String tagName) {
        waitForVisible(String.format(TEMPLATE_SELECT_TAG, tagName));
        click(String.format(TEMPLATE_SELECT_TAG, tagName));
        waitForVisible(String.format(TEMPLATE_ACTIVE_TAG, tagName));
        return this;
    }

    public DesignFreelyView next() {
        click(NEXT);
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
