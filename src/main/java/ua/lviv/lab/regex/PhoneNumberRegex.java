package ua.lviv.lab.regex;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberRegex {

    public String findAndChangeNumberOnReversed(final String text) {

        Pattern pattern = Pattern
                .compile("(\\d{3}-\\d{2}-\\d{2}|\\d{7}|\\d{2}-\\d{2}-\\d{2}-\\d{1})");
        Matcher matcher = pattern.matcher(text);
        List<String> listWithReversedNumbers = new LinkedList<>();
        List<String> listWithoutReversedNumbers = new LinkedList<>();
        while (matcher.find()) {
            listWithReversedNumbers.add(matcher.group());
            listWithoutReversedNumbers.add(matcher.group());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < listWithReversedNumbers.size(); i++) {

            builder.append(listWithReversedNumbers.get(i)).reverse();
            listWithReversedNumbers.set(i, builder.toString());
            builder.delete(0, builder.length());
        }
        String result = text;
        for (int i = 0; i < listWithReversedNumbers.size(); i++) {

            result = result.replace(listWithoutReversedNumbers.get(i),
                    listWithReversedNumbers.get(i));
        }

        return result;
    }
}
