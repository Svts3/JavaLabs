package ua.lviv.lab.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberRegex {

    public String findAndChangeNumberOnReversed(final String text) {
        Pattern pattern = Pattern.compile(
                "([\\w\\s]+)?(\\d{3}-\\d{2}-\\d{2}|\\d{7}|\\d{2}-\\d{2}-\\d{2}-\\d{1})(.[\\w\\s]+)?");
        Matcher matcher = pattern.matcher(text);
        StringBuilder builder = new StringBuilder();
        if (matcher.matches()) {
            final int firstRegexGroupIndex = 1;
            final int secondRegexGroupIndex = 2;
            final int thirdGRegexroupIndex = 3;
            builder.append(matcher.group(firstRegexGroupIndex) == null ? ""
                    : matcher.group(firstRegexGroupIndex));
            builder.append(new StringBuilder(matcher.group(secondRegexGroupIndex)).reverse());
            builder.append(matcher.group(thirdGRegexroupIndex) == null ? ""
                    : matcher.group(thirdGRegexroupIndex));

        } else {
            throw new IllegalArgumentException("The text doesn't follow the regular expression");
        }
        return builder.toString();
    }
}
