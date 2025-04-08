package carrent.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> registrationDataProvider() {
        return Stream.of(
                Arguments.of("John", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1@"),
                Arguments.of("Arya", "Stark", "t.433" + System.currentTimeMillis() + "@gmail.com", "StrongPass2#"),
                Arguments.of("Tyrion", "Lannister", "user_name1233" + System.currentTimeMillis() + "@gmail.com", "CleverPass3$"),
                Arguments.of("Daenerys", "Targaryen", "test-433" + System.currentTimeMillis() + "@gmail.com", "FirePass4*"),
                Arguments.of("Sansa", "Stark", "test433.plus" + System.currentTimeMillis() + "@gmail.com", "WinterPass5!"),
                Arguments.of("Cersei", "Lannister", "test433@subdomain" + System.currentTimeMillis() + ".gmail.com", "CrownPass6@"),
                Arguments.of("Jon", "Snow", "test433.email" + System.currentTimeMillis() + "@gmail.com", "SnowPass7#"),
                Arguments.of("Ned", "Stark", "test_433" + System.currentTimeMillis() + "@example.co", "WinterIsHere8*"),
                Arguments.of("Robb", "Stark", "test433@googlemail" + System.currentTimeMillis() + ".com", "WarriorPass9@"),
                Arguments.of("Bran", "Stark", "user.test33" + System.currentTimeMillis() + "@gmail.com", "BranPass10!")
        );
    }

    public static Stream<Arguments> registrationNegativeAlreadyExistData() {
        return Stream.of(
                Arguments.of("John", "Snow", "test_1234@gmail.com", "Password1@")
        );
    }

    public static Stream<Arguments> registrationWithInvalidEmailNegativeData() {
        return Stream.of(
                Arguments.of("John", "Snow", "test433@@gmail.com", "Password1@"),
                Arguments.of("Arya", "Stark", "test433@gmail..com", "StrongPass2#"),
                Arguments.of("Tyrion", "Lannister", "test433gmail.com", "CleverPass3$"),
                Arguments.of("Daenerys", "Targaryen", "@gmail.com", "FirePass4*"),
                Arguments.of("Sansa", "Stark", "test433@.com", "WinterPass5!"),
                Arguments.of("Cersei", "Lannister", "test433@com", "CrownPass6@"),
                Arguments.of("Jon", "Snow", "test433@.g@mail.com", "SnowPass7#"),
                Arguments.of("Ned", "Stark", "test433@com.", "WinterIsHere8*"),
                Arguments.of("Robb", "Stark", "test433@gnail,com", "WarriorPass9@"),
                Arguments.of("Bran", "Stark", "test433@gmail.c", "BranPass10!"),
                Arguments.of("Tyrion", "Lannister", "test433@ gmail.com", "Pass123@"),
                Arguments.of("Arya", "Stark", "test433@gmail com", "AryaPass12#")
        );
    }

    public static Stream<Arguments> registrationWithInvalidPasswordData() {
        return Stream.of(
                Arguments.of("John", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1"),
                Arguments.of("Arya", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "Password@"),
                Arguments.of("Tyrion", "Lannister", "test433" + System.currentTimeMillis() + "@gmail.com", "Password"),
                Arguments.of("Daenerys", "Targaryen", "test433" + System.currentTimeMillis() + "@gmail.com", "password1@"),
                Arguments.of("Sansa", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "PASSWORD1@"),
                Arguments.of("Cersei", "Lannister", "test433" + System.currentTimeMillis() + "@gmail.com", "Pass1@"),
                Arguments.of("Jon", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1@Password1@Password1@Password1@Password1@"),
                Arguments.of("Ned", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "@@@@@@@@"),
                Arguments.of("Robb", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "12345678"),
                Arguments.of("Bran", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "password"),
                Arguments.of("Tyrion", "Lannister", "test433" + System.currentTimeMillis() + "@gmail.com", "Password 1@"),
                Arguments.of("Arya", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1@"),
                Arguments.of("Jon", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1@ "),
                Arguments.of("Jon", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", "Pass@1")
        );
    }

    public static Stream<Arguments> registrationNegativeInvalidFirstNameData(){
        return Stream.of(
                Arguments.of("", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1"),
                Arguments.of("", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", "Password@"),
                Arguments.of("", "Lannister", "test433" + System.currentTimeMillis() + "@gmail.com", "Password")
        );
    }

    public static Stream<Arguments> registrationInvalidLastNameData(){
        return Stream.of(
                Arguments.of("John", "", "test433" + System.currentTimeMillis() + "@gmail.com", "Password1"),
                Arguments.of("Arya", "", "test433" + System.currentTimeMillis() + "@gmail.com", "Password@"),
                Arguments.of("Tyrion", "", "test433" + System.currentTimeMillis() + "@gmail.com", "Password")
        );
    }

    public static Stream<Arguments> registrationEmptyEmailData(){
        return Stream.of(
                Arguments.of("John", "Snow", "", "Password1"),
                Arguments.of("Arya", "Stark", "", "Password@"),
                Arguments.of("Tyrion", "Lannister", "", "Password")
        );
    }

    public static Stream<Arguments> registrationEmptyPasswordData(){
        return Stream.of(
                Arguments.of("John", "Snow", "test433" + System.currentTimeMillis() + "@gmail.com", ""),
                Arguments.of("Arya", "Stark", "test433" + System.currentTimeMillis() + "@gmail.com", ""),
                Arguments.of("Tyrion", "Lannister", "test433" + System.currentTimeMillis() + "@gmail.com", "")
        );
    }
}