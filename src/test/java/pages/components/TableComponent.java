package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    static SelenideElement
            modalPageTitle =  $("#example-modal-sizes-title-lg");
    public TableComponent checkTitle() {
        modalPageTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public TableComponent checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
