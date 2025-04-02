package CSPTech;

import CSPTech.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Testes {
    WebDriver navegador;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @AfterEach
    public void tearDown(){navegador.quit();}

    @Test
    public void adicionarAoCarrinho() {

        String mensagem = new HomePage(navegador)
                .acessarSite()
                .clicarEmRegister()
                .criarUsuario("masculino", "teste", "testado", "teste3@teste.com", "123456")
                .adicionarAoCarrinho()
                .selecionarOpcoesPc("3", 1, 1)
                .validarMensagemSucesso();

        mensagem.equals("The product has been added to your ");
    }

    @Test
    public void visualizarCarrinho(){
        List<String> expectedAttributes = Arrays.asList(
                "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]",
                "RAM: 2 GB",
                "HDD: 320 GB",
                "OS: Vista Home [+$50.00]",
                "Software: Microsoft Office [+$50.00]"
        );

        List<String> opcoesCarrinho =new HomePage(navegador)
                .acessarSite()
                .clicarNoBotaoLogin()
                .fazerLogin("teste3@teste.com", "123456")
                .acessarCarrinho()
                .verificarOpcoesDoCarrinho();
        opcoesCarrinho.equals(expectedAttributes);
    }

    @Test
    public void editarCarrinho(){
        List<String> expectedAttributes = Arrays.asList(
                "Processor: 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]",
                "RAM: 4GB [+$20.00]",
                "HDD: 400 GB [+$100.00]",
                "OS: Vista Premium [+$60.00]",
                "Software: Microsoft Office [+$50.00]"
        );

        List<String> opcoesDoCarrinho = new HomePage(navegador)
                .acessarSite()
                .clicarNoBotaoLogin()
                .fazerLogin("teste3@teste.com", "123456")
                .acessarCarrinho()
                .editarProduto()
                .selecionarOpcoesPc("4", 2, 2)
                .fecharMensagem()
                .acessarCarrinho()
                .verificarOpcoesDoCarrinho();

                opcoesDoCarrinho.equals(expectedAttributes);
    }

    @Test
    public void excluirItemCarrinho(){
        String mensagem = new HomePage(navegador)
                .acessarSite()
                .clicarNoBotaoLogin()
                .fazerLogin("teste3@teste.com", "123456")
                .acessarCarrinho()
                .excluirItemDoCarrinho()
                .pegarMensagemCarrinhoVazio();

        mensagem.equals("Your Shopping Cart is empty!");
    }
}
