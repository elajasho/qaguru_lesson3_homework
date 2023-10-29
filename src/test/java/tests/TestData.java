package tests;

import com.github.javafaker.Faker;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class TestData {
    static Faker faker = new Faker(new Locale("en"));

    String[] NCR = new String[]{"Delhi", "Gurgaon", "Noida"};
    String[] UttarPradesh = new String[]{"Agra", "Lucknow", "Merrut"};
    String[] Haryana = new String[]{"Karnal", "Panipat"};
    String[] Rajasthan = new String[]{"Jaipur", "Jaiselmer"};

    public static final String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            streetAddress = faker.address().streetAddress(),
            randomEmail = faker.internet().emailAddress(),
            randomPhoneNumber = faker.number().digits(10),
            randomGender = faker.options().option("Male", "Female", "Other"),
            randomSubject = faker.options().option("Arts", "Biology", "Chemistry", "English", "Hindi", "Maths", "Physics"),
            randomSport = faker.options().option("Yes", "No"),
            randomReading = faker.options().option("Yes", "No"),
            randomMusic = faker.options().option("Yes", "No"),
            randomState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public String getRandomCity() {
        String[] selectedList = null;
        String randomValue = "";

        switch (randomState) {
            case "NCR":
                selectedList = NCR;
                break;
            case "Uttar Pradesh":
                selectedList = UttarPradesh;
                break;
            case "Haryana":
                selectedList = Haryana;
                break;
            case "Rajasthan":
                selectedList = Rajasthan;
                break;
            default:
                break;
        }

        if (selectedList != null) {
            int randomIndex = faker.number().numberBetween(0, selectedList.length - 1);
            randomValue = selectedList[randomIndex];
        }
        return randomValue;
    }

    // Рандомная дата из календаря исключает все некорректные значения типа 31 февраля
    public static final Date
            randomDate = faker.date().birthday();

    // Создаем рандомный файл с изображением для теста
    public static String imageName = faker.lorem().word() + ".jpg",
            imagePath = "src/test/resources/" + imageName;
    int imageWidth = 800;
    int imageHeight = 600;
    BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
    File outputFile = new File(imagePath);

    {
        try {
            ImageIO.write(image, "jpg", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
