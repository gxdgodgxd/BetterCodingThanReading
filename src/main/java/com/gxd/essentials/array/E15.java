package com.gxd.essentials.array;

/**
 * Created by gxdgodgxd on 17/2/16.
 */
public class E15 {
    public int[] plusOne(int[] digits) {
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }

        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        }else{
            return digits;
        }

    }
}
