import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TestPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("могазин")
@Owner("lissamissa")
public class tetst {

    @Test
    @DisplayName("Добавление товара в корзину через быструю корзину")
    public void addToCartTest() {

        step("Открыть страницу магазина", () -> {
            open("http://automationpractice.com/index.php");
        });

        String productName = step("Навести курсор на карточку товара", () -> {
            TestPages.page.productList()
                    .first().hover();
            return TestPages.page.productNameList().first()
                    .getText();
        });

        step("Нажать на появившуюся кнопку 'Add to cart'", () -> {
            TestPages.page.addToCartButton()
                    .click();

            step("Появился попап с информацией об успешном добавлении товара в корзину", () -> {
                TestPages.page.productAddedPopup()
                        .shouldHave(text("Product successfully added to your shopping cart"));
                TestPages.page.closePopupButton()
                        .click();
            });
            step("Товар добавился в корзину", () -> {
                TestPages.page.openCartButton()
                        .click();
                TestPages.page.productNameInCartList().first()
                        .shouldBe(visible)
                        .shouldHave(text(productName));
            });
        });
    }
}
