package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertions() {
        //Открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // Перейти в раздел Wiki проекта
        $("[data-content='Wiki']").click();

        //Раскрыть скрытый раздел
        $x("//*[contains(text(),'Show 1 more pages')]").click();

        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $$("#wiki-pages-box ul li" ).get(15).$("a").shouldHave(text("SoftAssertions"));

        //Открыть страницу SoftAssertions
        $x("//*[contains(text(),'SoftAssertions')]").click();

        //убедиться, что в списке есть упоминание про JUnit 5
        $$("#wiki-content ol li" ).get(2).shouldHave(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));

        //убедиться, что на странице есть текст кода, который уникален для JUnit 5
        $x("//*[contains(text(),'@ExtendWith')]").shouldBe(visible);
    }
}
