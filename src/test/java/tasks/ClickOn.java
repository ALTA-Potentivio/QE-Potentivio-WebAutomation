package tasks;

import Potentivio.pageobjects.HireArtistPageObjects;
import Potentivio.pageobjects.PotentivioLoginPageObjects;
import Potentivio.pageobjects.PotentivioRegisterPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOn {
    public static Performable button(String buttonType) throws Exception {
        Target button;

        switch (buttonType) {
            case "Cafe Owner":
                button = PotentivioLoginPageObjects.CAFE_OWNER_BUTTON;
                break;
            case "Login Cafe Owner":
                button = PotentivioLoginPageObjects.LOGIN_CAFE_BUTTON;
                break;
            case "Register Cafe Owner":
                button = PotentivioRegisterPageObjects.REGISTER_CAFE_BUTTON;
                break;
            default:
                throw new Exception("There is no button type: " + buttonType);
        }

        WaitUntil.the(button, isVisible()).forNoMoreThan(25).seconds();
        return Task.where("{0} click " + buttonType + "button",
                Click.on(button));
    }
    public static Performable artistList() {
        return Task.where("{0} click artist",
                Click.on(HireArtistPageObjects.ARTIST_LIST)
        );
    }
}
