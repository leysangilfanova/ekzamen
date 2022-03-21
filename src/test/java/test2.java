import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.TestPages;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;
public class test2 {


    @MethodSource("testMethod")
    @ParameterizedTest(name = "{displayName} используя {0}")
    @DisplayName("Негативные кейсы для поля Newsletter")
    void newsInputTest(String type, String searchData) {

        step("Открыть страницу магазина", () -> {
            open("http://automationpractice.com/index.php");
        });

        step("Ввести в строку подписки на новости " + searchData + " и нажать Enter", () -> {
            TestPages.page.newsLetterInput()
                    .sendKeys(searchData);
            TestPages.page.newsLetterInput()
                    .pressEnter();

            step("Появилось сообщение о том, что почта введена некорректно", () -> {
                TestPages.page.alertMessage()
                        .shouldBe(visible)
                        .shouldHave(text("Newsletter : Invalid email address."));
            });
        });
    }

    static Stream<Arguments> testMethod() {
        return Stream.of(
                arguments("некорректный почтовый адрес", "daily@"),
                arguments("цифры", "1234"),
                arguments("символы", "%:.!№")
        );
    }
}
