package abcGruppen;

import base.BaseTest;

public class Login extends BaseTest {
    public static final String INPUT_ID_TEMPLATE = "//input[@id='username']";
    public static final String LINK_FORGOT_ORDER = "//a[@data-target='#lostLoginModal']";


    /**
     * Sets order number
     *
     * @param orderNumber - order number that you want to set
     * @return Login
     */
    public Login setOrderNumber(String orderNumber) {
        typeKeys(INPUT_ID_TEMPLATE, orderNumber);
        return this;
    }


    /**
     * Clicks on forgot order number button
     *
     * @return Forgot Order Number dialog
     */
    public ForgotOrderNumberDialog forgotOrderNumber() {
        click(LINK_FORGOT_ORDER);
        return new ForgotOrderNumberDialog();
    }

}
