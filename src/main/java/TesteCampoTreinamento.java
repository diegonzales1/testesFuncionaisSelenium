import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

        driver.findElement(textArea).sendKeys("teste");
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

    @Test
    public void deveIntegrarComComboBox(){
        System.setProperty("webdriver.chrome.driver","C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        By comboBoxEscolariedade = By.id("elementosForm:escolaridade");
        WebElement element = driver.findElement(comboBoxEscolariedade);
        Select combo = new Select(element);

        //Maneiras para selecionar um valor
        //combo.selectByIndex(5);
        //combo.selectByValue("mestrado");
        combo.selectByVisibleText("Superior");

        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
        driver.quit();
    }

    @Test
    public void deveVerificarValoresCombo() {
        System.setProperty("webdriver.chrome.driver", "C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        By comboBoxEscolariedade = By.id("elementosForm:escolaridade");
        WebElement element = driver.findElement(comboBoxEscolariedade);
        Select combo = new Select(element);

        List<WebElement> options = combo.getOptions();

        //Valida o tamanho
        //Assert.assertEquals(8, options.size());

        boolean encontrou = false;

        for(WebElement option : options){
            if(option.getText().equals("Mestrado")){
                encontrou = true;
                break;
            }
        }

        Assert.assertTrue(encontrou);
        driver.quit();
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        System.setProperty("webdriver.chrome.driver", "C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        By comboBoxEscolariedade = By.id("elementosForm:esportes");
        WebElement element = driver.findElement(comboBoxEscolariedade);
        Select combo = new Select(element);

        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        List<WebElement> options = combo.getAllSelectedOptions();
        Assert.assertEquals(3, options.size());

        //combo.deselectByVisibleText("O que eh esporte?");
        //Assert.assertEquals(2, options.size());
        driver.quit();
    }

    @Test
    public void deveInteragirComBotoes() {
        System.setProperty("webdriver.chrome.driver", "C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        By buttonObrigado = By.id("buttonSimple");
        WebElement botao = driver.findElement(buttonObrigado);
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        driver.quit();
    }

    @Test
    @Ignore
    public void deveInteragirComLink() {
        System.setProperty("webdriver.chrome.driver", "C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        By link = By.linkText("Voltar");
        driver.findElement(link).click();

        //Assert.assertTrue(driver.findElement(By.id("resultado")).isDisplayed());
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        driver.quit();
    }

    @Test
    public void deveBuscarTextosNaPagina() {
        System.setProperty("webdriver.chrome.driver", "C:/CURSOAUTOMACAO/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Voltou"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
        driver.quit();
    }
}
