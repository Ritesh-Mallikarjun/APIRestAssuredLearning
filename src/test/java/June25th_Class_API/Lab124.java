package June25th_Class_API;

import io.qameta.allure.AllureId;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class Lab124 {

    @Issue("Issue1234")
    @Severity(SeverityLevel.CRITICAL)
    @AllureId("#TC1")
    @Test(groups = {"smoke", "sanity"})
    public void SmokeTest() {
        System.out.println("smoke testing");
    }

    @AllureId("#TC2")
    @Test(groups = {"sanity"})
    public void SanityTest() {
        System.out.println("sanity testing");
    }

    @AllureId("#TC3")
    @Test(groups = {"regression"})
    public void RegressionTest() {
        System.out.println("regression testing");
    }

    @AllureId("#TC4")
    @Test(groups = {"qa"},priority = 1)
    public void QATest() {
        System.out.println("qa testing");
    }

    @AllureId("#TC5")
    @Test(groups = {"production"},priority = 2)
    public void ProductionTest() {
        System.out.println("production testing");
    }

    @AllureId("#TC6")
    @Test(groups = {"hypercare","qa"},priority = 3)
    public void HypercareTest() {
        System.out.println("hypercare testing");
    }
}
