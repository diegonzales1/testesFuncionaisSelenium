import org.junit.Assert;
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
    }


}
