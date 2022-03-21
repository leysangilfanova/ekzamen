package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class page {
    public ElementsCollection productList() {
        return $$(".product-container .product-image-container");
    }

    public ElementsCollection productNameList() {
        return $$(".product-name");
    }

    public SelenideElement closePopupButton() {
        return $("[title='Close window']").as("кнопка закрытия попапа");
    }

    public SelenideElement addToCartButton() {
        return $("[title='Add to cart']").as("кнопка добавления в корзину");
    }

    public SelenideElement openCartButton() {
        return $(".shopping_cart").as("кнопка 'Cart'");
    }

    public ElementsCollection productNameInCartList() {
        return $$(".cart-info .product-name");
    }

    public SelenideElement productAddedPopup() {
        return $(".layer_cart_product").as("попап об успешном добавлении товара в корзину");
    }

    public SelenideElement newsLetterInput() {
        return $(".newsletter-input").as("поле ввода почты для подписки на рассылку новостей");
    }

    public SelenideElement alertMessage() {
        return $(".alert-danger").as("плашка об ошибке");
    }
}
