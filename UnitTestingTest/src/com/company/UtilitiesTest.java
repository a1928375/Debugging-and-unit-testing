package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    Utilities utilities;
    String[] strings;

    @BeforeEach
    void setUp() {

       utilities = new Utilities();
    }

    @Test
    void everyNthChar() {

        assertAll(

                () -> assertArrayEquals(new char[]{'b', 'd', 'f'}, utilities.everyNthChar(new char[]{'a','b','c','d','e','f'}, 2)),
                () -> assertArrayEquals(new char[]{'b', 'd'}, utilities.everyNthChar(new char[]{'a','b','c','d','e'}, 2)),
                () -> assertArrayEquals(new char[]{}, utilities.everyNthChar(new char[]{}, 2)),
                () -> assertArrayEquals(null, utilities.everyNthChar(null, 2)),
                () -> assertArrayEquals(new char[]{'a','b','c','d','e','f'}, utilities.everyNthChar(new char[]{'a','b','c','d','e','f'}, 9))

        );

    }

    @Test
    void removePairs() {

        assertAll(

                () -> assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF")),
                () -> assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF")),
                () -> assertEquals(null, utilities.removePairs(null)),
                () -> assertEquals("A", utilities.removePairs("A"))
        );
    }

    @ParameterizedTest
    @CsvSource({"ABCDEFF,ABCDEF", "AB88EFFG,AB8EFG", "112233445566,123456", "ZYZQQB,ZYZQB", "A,A"})
        void removePairsPT(String input, String expected) {

        assertEquals(expected, utilities.removePairs(input));

    }

    @Test
    void converter() {

        assertAll(

                () -> assertEquals(300, utilities.converter(10, 5)),
                () -> assertThrows(ArithmeticException.class, () -> utilities.converter(10, 0))

        );

    }

    @Test
    void nullIfOddLength() {

        assertAll(

                () -> assertEquals(null, utilities.nullIfOddLength("abcde")),
                () -> assertEquals("abcdef", utilities.nullIfOddLength("abcdef")),
                () -> assertEquals("", utilities.nullIfOddLength("")),
                () -> assertEquals(null, utilities.nullIfOddLength(null))
        );

    }
}