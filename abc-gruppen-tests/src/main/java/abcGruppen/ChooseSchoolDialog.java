package abcGruppen;

import base.BaseTest;
import org.openqa.selenium.By;

public class ChooseSchoolDialog extends BaseTest {

    public static final String TEMPLATE_OPEN_DROP_DOW = "//span[contains(@id, 'select2')][normalize-space()='%s']";
    public static final String TEMPLATE_CHOOSE_DROP_DOWN = "//ul[@class='select2-results__options']//li[normalize-space()='%s']";
    public static final String INPUT_SET_TEXT = "//input[@class='select2-search__field']";
    public static final String BUTTON_DESIGN_HAT = "//a[normalize-space()='Designa med din skolas rabatter']";
    public static final String DIALOG_IFRAME = "//iframe[@class='mfp-iframe']";

    /**
     * This switches to iframe, opens drop down, types name of the school and it chooses school
     *
     * @param schoolName - name of school that you want to select
     * @return ChooseSchoolDialog
     */
    public ChooseSchoolDialog chooseSchoolFromDropDown(String schoolName) {
        chooseItemFromDropDown(schoolName);
        return this;
    }

    private void chooseItemFromDropDown(String itemName) {
        switchToIframe(DIALOG_IFRAME);
        waitForVisible(String.format(TEMPLATE_OPEN_DROP_DOW, "Välj skola..."));
        click(String.format(TEMPLATE_OPEN_DROP_DOW, "Välj skola..."));
        typeKeys(INPUT_SET_TEXT, itemName);
        waitForVisible(String.format(TEMPLATE_CHOOSE_DROP_DOWN, itemName));
        click(String.format(TEMPLATE_CHOOSE_DROP_DOWN, itemName));
        waitForVisible(String.format(TEMPLATE_OPEN_DROP_DOW, itemName));
        switchToDefaultContent();

    }

    /**
     * This method clicks on button that leaves you to Design Hat view
     *
     * @return Design Hat View
     */
    public DesignHatView designHat() {
        switchToIframe(DIALOG_IFRAME);
        click(BUTTON_DESIGN_HAT);
        switchToDefaultContent();
        return new DesignHatView();
    }


}
