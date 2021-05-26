package dragAndDrop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDrop() {

        //Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Убедиться, что прямоугольники на своих позициях, А - на первой, В - на второй
        $$("#columns div header").first().shouldHave(text("A"));
        $$("#columns div header").get(1).shouldHave(text("B"));

        //Перенести прямоугольник А на место В
        $$("#columns div header").first().dragAndDropTo($$("#columns div header").get(1));

        //Убедиться, что прямоугольники на своих позициях, А - на первой, В - на второй
        $$("#columns div header").first().shouldHave(text("B"));
        $$("#columns div header").get(1).shouldHave(text("A"));

    }



}
