
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

   @Test
    public void Teste() {
        System.setProperty("webdriver.chrome.driver","C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        //Abre no meio da tela
        //driver.manage().window().setPosition(new Point(100, 100));

       //Abre no tamanho 1200, 765
       //driver.manage().window().setSize(new Dimension(1200, 765));

       //Abre o browser maximizado
       driver.manage().window().maximize();

       //Abre na URL do Google
        driver.get("http://www.google.com");

        //Executa o teste
        Assert.assertEquals("Google", driver.getTitle());

        //Fecha somente a aba do browser
        //driver.close();

        //Fecha o browser e encerra o chromedriver
        driver.quit();
    }
}
