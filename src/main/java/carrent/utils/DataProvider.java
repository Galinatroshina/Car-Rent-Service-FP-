package carrent.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> registrationDataProvider() {
        return Stream.of(
                Arguments.of("John", "Snow", "johnsnow5_test1@gmail.com", "Password1@"),
                Arguments.of("Arya", "Stark", "arya_stark_2023@gmail.com", "StrongPass2#")
        );
    }



}