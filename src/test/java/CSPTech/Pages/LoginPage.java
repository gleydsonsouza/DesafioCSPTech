package CSPTech.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    @FindBy(id = "Email")
    WebElement campoEmail;

    @FindBy(id = "Password")
    WebElement campoSenha;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
    WebElement botaoLogar;

    public HomePage fazerLogin(String email, String senha){
        campoEmail.sendKeys(email);
        campoSenha.sendKeys(senha);
        botaoLogar.click();
        return new HomePage(navegador);
    }
}
