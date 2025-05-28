package com.shixin;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomStringUtilsTest {
    @Test
    public void test() {
        System.out.println(RandomStringUtils.secureStrong().next(10));
        System.out.println(RandomStringUtils.secureStrong().nextAlphabetic(10));
        System.out.println(RandomStringUtils.secureStrong().nextNumeric(10));
        System.out.println(RandomStringUtils.secureStrong().nextAlphanumeric(10));
        // 生成指定范围随机字符
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        System.out.println(RandomStringUtils.secure().next(8, allowedChars.toCharArray()));
        String randomCapitalLetter = RandomStringUtils.secureStrong().next(1, 'A', 'Z', false, false);
        String randomUnCapitalLetter = RandomStringUtils.secureStrong().next(1, 'a', 'z', false, false);
        String randomNumeric = RandomStringUtils.secureStrong().nextNumeric(1);
        String randomSymbol = RandomStringUtils.secureStrong().next(1, "!@#$%^&*");
        String remainRandom = RandomStringUtils.secure().next(8, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*");
        String random = StringUtils.join(randomCapitalLetter, randomUnCapitalLetter, randomNumeric, randomSymbol, remainRandom);
        System.out.println(random);
        List<Character> chars = random.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(chars);
        System.out.println(StringUtils.join(chars, ""));
    }
}
