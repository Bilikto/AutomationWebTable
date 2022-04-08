package steps;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverUtils;

public class Hooks {
    @Before
    public void setUp() {
        DriverUtils.createDriver();
    }

    @After
    public void cleanUp() {
        DriverUtils.getDriver().quit();
    }
}
