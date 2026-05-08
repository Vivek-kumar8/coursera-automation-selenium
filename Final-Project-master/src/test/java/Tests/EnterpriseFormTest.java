package Tests;

import Config.BaseTest;
import Pages.EnterprisePage;
import org.testng.annotations.Test;

public class EnterpriseFormTest extends BaseTest {

    @Test
    public void verifyEnterpriseFormValidation() {

        test = extent.createTest("Enterprise Form Validation Test");

        EnterprisePage enterprise = new EnterprisePage(driver, "Vivek" , "Kumar" , "wrongInput");
        enterprise.submitForm();
        test.pass("Validation message verified");

    }
}
