package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DescontosSteps {
    WebDriver driver = new ChromeDriver();

    @Dado("^que estou no site da qazando$")
    public void acessar_site_qazando() {
        driver.get("https://qazando.com.br/curso.html");

    }

    @Quando("^eu preencho meu e-mail$")
    public void eu_preencho_meu_e_mail() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, 10000)");
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("finotti@qazando.com.br");

    }

    @Quando("^clico em ganhar cupom$")
    public void clico_em_ganhar_cupom() {
        driver.findElement(By.id("button")).click();
    }

    @Então("^eu vejo o código de desconto$")
    public void eu_vejo_o_código_de_desconto() {
        String texto_cupom = driver.findElement(By.cssSelector("#cupom > h2 > span")).getText();
        System.out.println(texto_cupom);

        driver.quit();
    }
}
