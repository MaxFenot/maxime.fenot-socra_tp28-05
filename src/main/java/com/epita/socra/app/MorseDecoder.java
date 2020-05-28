package com.epita.socra.app;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class MorseDecoder {

    public MorseDecoder(){};
    private static HashMap<Integer, String> ToMorse_;
    private static HashMap<String, Integer> ToInt_;
    static {
        ToMorse_ = new HashMap<>();
        ToMorse_.put(1, ".____");
        ToMorse_.put(2, "..___");
        ToMorse_.put(3, "...__");
        ToMorse_.put(4, "...._");
        ToMorse_.put(5, ".....");
        ToMorse_.put(6, "_....");
        ToMorse_.put(7, "__...");
        ToMorse_.put(8, "___..");
        ToMorse_.put(9, "____.");
        ToMorse_.put(0, "_____");

        ToInt_ = new HashMap<>();
        ToInt_.put(".____", 1);
        ToInt_.put("..___", 2);
        ToInt_.put("...__", 3);
        ToInt_.put("...._", 4);
        ToInt_.put(".....", 5);
        ToInt_.put("_....", 6);
        ToInt_.put("__...", 7);
        ToInt_.put("___..", 8);
        ToInt_.put("____.", 9);
        ToInt_.put("_____", 0);
    }

    public String IntToMorse(String input){
        StringBuilder str = new StringBuilder();
        for (char c : input.toCharArray()){
            int digit = c - '0';
            if (digit < 0 || digit > 9)
                throw new InvalidParameterException();
            str.append(ToMorse_.get(digit));
        }

        return str.toString();
    }

    public String MorseToInt(String input) {
        StringBuilder str = new StringBuilder();
        int n = 0;
        while (n < input.length()) {
            String sub;
            try {
                sub = input.substring(n, n + 5);
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidParameterException();
            }
            if (!ToInt_.containsKey(sub))
                throw new InvalidParameterException();
            str.append(ToInt_.get(sub));
            n += 5;
        }

        return str.toString();
    }
}
