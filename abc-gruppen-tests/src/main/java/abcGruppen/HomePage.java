package abcGruppen;

import base.BaseTest;

public class HomePage extends BaseTest {

    public static final String BUTTON_TEMPLATE_LOCATOR = "//ul[@id='menu-sekundar-meny']//a[normalize-space()='%s']";

    /**
     * Clicks on My Abc button
     *
     * @return Login
     */
    public Login goToMyAbc() {
        click(String.format(BUTTON_TEMPLATE_LOCATOR, "Mitt ABC"));
        switchToNewWindow();
        return new Login();
    }

    /**
     * Clicks on design hat button
     *
     * @return ChooseSchoolDialog
     */
    public ChooseSchoolDialog designHat() {
        click(String.format(BUTTON_TEMPLATE_LOCATOR, "Designa"));
        return new ChooseSchoolDialog();
    }

}
