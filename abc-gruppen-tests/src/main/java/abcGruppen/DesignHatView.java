package abcGruppen;

import abcGruppen.designHat.DesignFreelyView;
import base.BaseTest;

public class DesignHatView extends BaseTest {

    public static final String BUTTON_DESIGN_FREELY = "//button[text()='Designa fritt']";


    /**
     * This method clicks on Design Freely button
     *
     * @return DesignFreelyView
     */
    public DesignFreelyView designFreely() {
        waitForVisible(BUTTON_DESIGN_FREELY);
        click(BUTTON_DESIGN_FREELY);
        return new DesignFreelyView();

    }



}
