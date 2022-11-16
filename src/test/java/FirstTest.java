import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.*;
public class FirstTest {
    WebDriver driver;
    private static String baseUrl = "https://idemo.bspb.ru/";
    private SelenideElement name = $(By.xpath("//input[@name='username']"));
    private SelenideElement pas = $(By.xpath("//input[@name='password']"));
    private SelenideElement logBtn = $(By.xpath("//button[@id='login-button']"));
    private SelenideElement code = $(By.xpath("//input[@id='otp-code']"));
    private SelenideElement codeBtn = $(By.xpath("//button[@id='login-otp-button']"));
    private SelenideElement viewBut = $(By.xpath("//a[@id='bank-overview']"));
    private SelenideElement accountsBut = $(By.xpath("//a[@id='accounts-index']"));
    private SelenideElement paymentsBut = $(By.xpath("//a[@id='payments-form']"));
    private SelenideElement cardsBut = $(By.xpath("//a[@id='cards-overview-index']"));
    private SelenideElement depositsBut = $(By.xpath("//a[@id='deposits-index']"));
    private SelenideElement loansBut = $(By.xpath("//a[@id='loans-index']"));
    private SelenideElement currencyBut = $(By.xpath("//a[@id='externaltraderoom-index']"));
    private SelenideElement insuranceBut = $(By.xpath("//a[@id='insurance-travel']"));
    @BeforeAll
    static void beforeConfig() {
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
    public void before() {
        open(baseUrl);
    }
    @Test
    public void test() {
        step1();  // Авторизация в банке
        step2();  // Подтверждающий код
        step3();  // Проверка значений главного меню
    }
    @Step("1. Authorization in the bank")
    public void step1(){
        name.should(Condition.visible).val("demo");
        pas.should(Condition.visible).val("demo");
        logBtn.should(Condition.visible).click();
    }
    @Step("2. Confirmation code")
    public void step2(){
        code.should(Condition.visible).val("0000");
        codeBtn.should(Condition.visible).click();
    }
    @Step("3. Checking the values of the main menu")
    public void step3(){
        viewBut.should(Condition.text("Обзор")).click();
        accountsBut.should(Condition.text("Счета")).click();
        paymentsBut.should(Condition.text("Платежи и Переводы")).click();
        cardsBut.should(Condition.text("Карты")).click();
        depositsBut.should(Condition.text("Вклады")).click();
        loansBut.should(Condition.text("Кредиты")).click();
        currencyBut.should(Condition.text("Валюта")).click();
        insuranceBut.should(Condition.text("Страхование")).click();
    }
    @AfterEach
    public void after() {}
}