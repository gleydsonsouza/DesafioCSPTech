package CSPTech.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver navegador) {
        super(navegador);
    }

    String url = "https://demo.nopcommerce.com/";

    @FindBy(className = "ico-register")
    WebElement botaoRegister;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    WebElement botaoAddAoCarrinhoPc;

    @FindBy(id = "product_attribute_2")
    WebElement botaoSelecionarRam;

    @FindBy(id = "product_attribute_3_6")
    WebElement botaoHd320;

    @FindBy(id = "product_attribute_3_7")
    WebElement botaoHd400;

    @FindBy(id = "product_attribute_4_8")
    WebElement botaoOsVista;

    @FindBy(id = "product_attribute_4_9")
    WebElement botaOsPremium;

    @FindBy(id = "add-to-cart-button-1")
    WebElement botaoAdicionarAoCarrinho;

    @FindBy(className = "content")
    WebElement mensagemSucesso;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
    WebElement botaoFecharMensagem;

    @FindBy(id = "topcartlink")
    WebElement botaoCarrinho;

    @FindBy(className = "ico-login")
    WebElement botaoLogin;

    public HomePage acessarSite(){
        navegador.get(url);
        return new HomePage(navegador);
    }
    public CriarUsuarioPage clicarEmRegister() {
        botaoRegister.click();
        return new CriarUsuarioPage(navegador);
    }

    public HomePage adicionarAoCarrinho(){
        botaoAddAoCarrinhoPc.click();
        return new HomePage(navegador);
    }
    public HomePage selecionarOpcoesPc(String ram, int hd, int os){
        Select select = new Select(botaoSelecionarRam);
        List<WebElement> listaDeOpcoes = select.getOptions();
        select.selectByValue(ram);
        if(hd == 1){
            botaoHd320.click();
        }
        else {
            botaoHd400.click();
        }
        if (os == 1){
            botaoOsVista.click();
        }
        else {
            botaOsPremium.click();
        }
        botaoAdicionarAoCarrinho.click();
        return new HomePage(navegador);
    }

    public HomePage fecharMensagem(){
        botaoFecharMensagem.click();
        return new HomePage(navegador);
    }

    public String validarMensagemSucesso(){
        String mensagem = mensagemSucesso.getText();
        return mensagem;
    }

    public LoginPage clicarNoBotaoLogin(){
        botaoLogin.click();
        return new LoginPage(navegador);
    }

    public CarrinhoPage acessarCarrinho(){
        botaoCarrinho.click();
        return new CarrinhoPage(navegador);
    }
}
