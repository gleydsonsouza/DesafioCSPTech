package CSPTech.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CriarUsuarioPage extends BasePage{
    public CriarUsuarioPage(WebDriver navegador) {
        super(navegador);
    }

    @FindBy(id = "gender-male")
    WebElement genderMasculino;

    @FindBy(id = "gender-female")
    WebElement genderFeminino;

    @FindBy(id = "FirstName")
    WebElement campoFirstName;

    @FindBy(id = "LastName")
    WebElement campoLastName;

    @FindBy(id = "Email")
    WebElement campoEmail;

    @FindBy(id = "Password")
    WebElement campoPassword;

    @FindBy(id = "ConfirmPassword")
    WebElement campoConfirmPassword;

    @FindBy(id = "register-button")
    WebElement botaoRegister;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div[2]/a")
    WebElement botaoContinue;

    public HomePage criarUsuario(String gender, String primeiroNome, String sobrenome, String email, String password){
        if(gender.equalsIgnoreCase("masculino")){
            genderMasculino.click();
        }
        else {
            genderFeminino.click();
        }
        campoFirstName.sendKeys(primeiroNome);
        campoLastName.sendKeys(sobrenome);
        campoEmail.sendKeys(email);
        campoPassword.sendKeys(password);
        campoConfirmPassword.sendKeys(password);
        botaoRegister.click();
        botaoContinue.click();
        return new HomePage(navegador);
    }

}
