import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

    @Test
    public void testeTextField(){
        System.setProperty("webdriver.chrome.driver","C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        By textoNome = By.id("elementosForm:nome");

        driver.findElement(textoNome).sendKeys("Diego Gonzales");

        Assert.assertEquals("Diego Gonzales", driver.findElement(textoNome).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void deveIntegrarComTextArea(){
        System.setProperty("webdriver.chrome.driver","C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        By textArea = By.id("elementosForm:sugestoes");

        driver.findElement(textArea).sendKeys("teste\n\n\nteste final");
        Assert.assertEquals("teste", driver.findElement(textArea).getAttribute("value"));

        driver.quit();
    }

    @Test
    public void deveInteragirComRadioButton(){
        System.setProperty("webdriver.chrome.driver","C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        By radioSexo = By.id("elementosForm:sexo:0");

        driver.findElement(radioSexo).click();
        Assert.assertTrue(driver.findElement(radioSexo).isSelected());
        driver.quit();
    }

    @Test
    public void deveInteragirComCheckBox(){
        System.setProperty("webdriver.chrome.driver","C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        for(int i=0; i<4;i++){
            driver.findElement(By.id("elementosForm:comidaFavorita:" + i)).click();
        }

        for(int i=0; i<4;i++){
            Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:" + i)).isSelected());
        }

        driver.quit();
    }
}
