package abcGruppen;

import base.BaseTest;

public class ForgotOrderNumberDialog extends BaseTest {
    public static final String INPUT_EMAIL = "//input[@id='email']";
    public static final String BUTTON_CLOSE = "//div[@id='lostLoginModal']//button[text()='Stäng']";

    /**
     * Sets desired email in email field
     *
     * @param email - email that you want to set
     * @return ForgotOrderNumberDialog
     */
    public ForgotOrderNumberDialog setEmail(String email) {
        waitForVisible(INPUT_EMAIL);
        typeKeys(INPUT_EMAIL, email);
        return this;
    }

    /**
     * Clicks on close button
     *
     * @return Login
     */
    public Login close() {
        click(BUTTON_CLOSE);
        return new Login();
    }


}
