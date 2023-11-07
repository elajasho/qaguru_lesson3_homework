package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleWebTest extends TestBase {

    @BeforeEach
    void preconditions() {
        open("https://bertal.ru/");
    }

    @ValueSource(strings = {"qa.guru", "selenide.org", "junit.org"})
    @DisplayName("ValueSourceDataProvider test")
    @ParameterizedTest
    void successfulSearchTestWithValueSourceDataProvider(String searchQuery) {
        $("#url").setValue(searchQuery).pressEnter();
        $("body").shouldHave(Condition.text("HTTP/1.1 200 OK"));
    }

    @CsvSource(value = {
            "qa.guru, https://qa.guru/",
            "selenide.org, https://selenide.org/",
            "junit.org, https://junit.org/"
    })
    @DisplayName("CsvSourceDataProvider test")
    @ParameterizedTest
    void successfulSearchTestWithCsvSourceDataProvider(String searchQuery, String expextedResult) {
        $("#url").setValue(searchQuery).pressEnter();
        $("body").shouldHave(Condition.text("Location: " + expextedResult));
    }

    @CsvFileSource(resources = "/testData.csv")
    @DisplayName("CsvFileSourceDataProvider test")
    @ParameterizedTest
    void successfulSearchTestWithCsvFileSourceDataProvider(String searchQuery, String expectedResult) {
        $("#url").setValue(searchQuery).pressEnter();
        $("body").shouldHave(Condition.text("Location: " + expectedResult));
    }

    static Stream<Object> selenideButtonsTest() {
        return Stream.of(
                Arguments.of("qa.guru", List.of("Server","Content-Type","Connection","Set-Cookie","Expires","Cache-Control","Pragma","X-Frame-Options")),
                Arguments.of("selenide.org", List.of("Connection", "Content-Length", "Server", "Content-Type", "Last-Modified", "Access-Control-Allow-Origin", "Strict-Transport-Security")),
                Arguments.of("junit.org", List.of("Date", "Content-Type", "Connection", "last-modified", "vary", "access-control-allow-origin", "expires", "Cache-Control"))
        );
    }

    @ParameterizedTest
    @MethodSource
    void selenideButtonsTest(String Domain, List<String> expectedFields) {
        $("#url").setValue(Domain).pressEnter();
        $$("#otv").shouldHave(CollectionCondition.texts(expectedFields));

    }
}