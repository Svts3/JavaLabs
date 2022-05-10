package ua.lviv.lab.regex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ua.lviv.lab.regex.PhoneNumberRegex;

class TestPhoneNumberRegex {

    @Test
    void testFindAndChangeNumberOnReversed() {
        PhoneNumberRegex phoneNumberRegex = new PhoneNumberRegex();
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        assertEquals("Number is 21-42-542", phoneNumberRegex.findAndChangeNumberOnReversed(text));
        text = scanner.nextLine();
        assertEquals("Number is 21-42-542, Tom", phoneNumberRegex.findAndChangeNumberOnReversed(text));
        text = scanner.nextLine();
        assertEquals("21-42-542 Tom", phoneNumberRegex.findAndChangeNumberOnReversed(text));
        text = scanner.nextLine();
        assertEquals("Number is 2142542", phoneNumberRegex.findAndChangeNumberOnReversed(text));
        text = scanner.nextLine();
        assertEquals("2-14-25-42", phoneNumberRegex.findAndChangeNumberOnReversed(text));
        text = scanner.nextLine();
        assertEquals("Numbers: 21-42-542, 2142542 Smt 2-14-25-42", phoneNumberRegex.findAndChangeNumberOnReversed(text));
        text = scanner.nextLine();
        assertEquals("", phoneNumberRegex.findAndChangeNumberOnReversed(text));

    }

}
