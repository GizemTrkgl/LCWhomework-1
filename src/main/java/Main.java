import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); //chrome driverı kurar
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //pencereyi maximize yapar
        driver.get("https://www.lcwaikiki.com/tr-TR/TR"); //siteye girer

        WebElement signIn = driver.findElement(By.cssSelector(" [href=\"https://www.lcwaikiki.com/tr-TR/TR/giris\"].header-dropdown-toggle"));
        signIn.click();

        WebElement signUp = driver.findElement(By.cssSelector(".login-form__link[href=\"https://www.lcwaikiki.com/tr-TR/TR/uye-ol\"]"));
        signUp.click();

        WebElement email = driver.findElement(By.cssSelector("#RegisterFormView_RegisterEmail"));
        email.sendKeys("yanlismail"); //yanlış mail gönderir

        WebElement password = driver.findElement(By.id("RegisterFormView_Password"));
        password.sendKeys("1234", Keys.TAB); //yanlış şifre gönderir

        try {
            Thread.sleep(2000); //2 saniye bekler
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String warning =driver.findElement(By.cssSelector("#RegisterFormView_Password-error")).getText();
        System.out.println(warning); //konsola hata mesajı yazar

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();//sekmeyi kapatır

    }
}