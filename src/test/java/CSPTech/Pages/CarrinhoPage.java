package CSPTech.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CarrinhoPage extends BasePage{
    public CarrinhoPage(WebDriver navegador) {
        super(navegador);
    }

    @FindBy(className = "edit-item")
    WebElement botaoEdit;

    @FindBy(className = "remove-btn")
    WebElement remover;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div/div")
    WebElement mensagemCarrinhoVazio;

    @FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/div[1]")
    WebElement opcoesDoCarrinho;

    public HomePage editarProduto(){
        botaoEdit.click();
        return new HomePage(navegador);
    }

    public String pegarMensagemCarrinhoVazio(){
        String mensagem = mensagemCarrinhoVazio.getText();
        return mensagem;
    }

    public List<String> verificarOpcoesDoCarrinho(){
        String text = opcoesDoCarrinho.getText();
        List<String> opcoesCarrinho = Arrays.asList(text.split("\\n"));
        return opcoesCarrinho;
    }

    public CarrinhoPage excluirItemDoCarrinho(){
        remover.click();
        return new CarrinhoPage(navegador);
    }


}
