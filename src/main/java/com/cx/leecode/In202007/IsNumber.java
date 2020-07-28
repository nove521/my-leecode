package com.cx.leecode.In202007;

import java.util.Objects;

public class IsNumber {
    public boolean isNumber(String s) {
        if (Objects.isNull(s))
            return false;
        s = s.trim();
        int len = s.length();
        int state = 0;
        for (int i = 0; i < len; i++) {

            char c = s.charAt(i);
            switch (c){
                case '+':
                case '-':
                    if (state == 0){
                        state = 1;
                    }else if (state == 3){
                        state = 4;
                    }else {
                        return false;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (state == 0 || state == 2 ||state == 1){
                        state = 2;
                    }else if (state == 6 || state == 7 || state == 8){
                        state = 7;
                    }else {
                        state = 5;
                    }
                    break;
                case '.':
                    if (state == 0 || state == 1){
                        state = 6;
                    }else if(state ==  2){
                        state = 8;
                    }else {
                        return false;
                    }
                    break;
                case 'E':
                case 'e':
                     if (state == 2 || state == 7 || state ==8){
                        state = 3;
                    }else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

        }

        return state == 2 || state == 7 || state == 5 || state == 8;
    }

    public static void main(String[] args) {
        test(1, "123", true);
        test(2, " 123 ", true);
        test(3, "0", true);
        test(4, "0123", true);  //Cannot agree
        test(5, "00", true);  //Cannot agree
        test(6, "-10", true);
        test(7, "-0", true);
        test(8, "123.5", true);
        test(9, "123.000000", true);
        test(10, "-500.777", true);
        test(11, "0.0000001", true);
        test(12, "0.00000", true);
        test(13, "0.", true);  //Cannot be more disagree!!!
        test(14, "00.5", true);  //Strongly cannot agree
        test(15, "123e1", true);
        test(16, "1.23e10", true);
        test(17, "0.5e-10", true);
        test(18, "1.0e4.5", false);
        test(19, "0.5e04", true);
        test(20, "12 3", false);
        test(21, "1a3", false);
        test(22, "", false);
        test(23, "     ", false);
        test(24, null, false);
        test(25, ".1", true); //Ok, if you say so
        test(26, ".", false);
        test(27, "2e0", true);  //Really?!
        test(28, "+.8", true);
        test(29, " 005047e+6", true);  //Damn = =|||

    }

    public static void test(int x, String s, boolean res){
        IsNumber isNumber = new IsNumber();
        boolean number = isNumber.isNumber(s);
        assert number == res : x;
    }
}
