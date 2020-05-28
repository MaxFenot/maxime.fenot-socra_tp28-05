package com.epita.socra.app;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class MorseDecoder {

    private static HashMap<Integer, String> Book_;
    static {
        Book_ = new HashMap<>();
        Book_.put(1, ".----");
        Book_.put(2, "..---");
        Book_.put(3, "...--");
        Book_.put(4, "....-");
        Book_.put(5, ".....");
        Book_.put(6, "-....");
        Book_.put(7, "--...");
        Book_.put(8, "---..");
        Book_.put(9, "----.");
        Book_.put(0, "-----");
    }

    public String IntToMorse(String input){
        StringBuilder str = new StringBuilder();
        for (char c : input.toCharArray()){
            int digit = c - '0';
            if (digit < 0 || digit > 9)
                throw new InvalidParameterException();
            str.append(Book_.get(digit));
        }

        return str.toString();
    }
}
