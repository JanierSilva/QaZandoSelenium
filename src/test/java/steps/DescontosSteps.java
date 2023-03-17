package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import runner.RunCucumberTest;

public class DescontosSteps extends RunCucumberTest {

    HomePage homePage = new HomePage(driver);

    @Dado("^que estou no site da qazando$")
    public void acessar_site_qazando() {
        homePage.acessarAplicacao();

    }

    @Quando("^eu preencho meu e-mail$")
    public void eu_preencho_meu_e_mail() throws InterruptedException {

        driver.findElement(By.id("email")).sendKeys("finotti@qazando.com.br");

    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() {
        driver.findElement(By.id("button")).click();
    }

    @Então("^eu vejo o código de desconto$")
    public void eu_vejo_o_código_de_desconto() {
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();

        Assert.assertEquals("o cupom está errado!", "QAZANDO15OFF", texto_cupom);


    }
}
