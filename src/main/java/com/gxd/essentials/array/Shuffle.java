package com.gxd.essentials.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gxdgodgxd on 17/6/16.
 */
public class Shuffle {

    private static final int CHAR_NUMS = 4;

    Character[] arr;

    public void init() {
        this.arr = new Character[Shuffle.CHAR_NUMS];
        for (int i = 0; i < Shuffle.CHAR_NUMS; i++) {
            this.arr[i] = (char) (97 + i);
        }
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        shuffle.init();
        System.out.println(Arrays.toString(shuffle.arr));

        shuffle.shuffleAndPrint();
    }

    public void shuffleAndPrint() {
        long total = 1;
        for (long i = 1; i <= arr.length; i++) {
            total *= i;
        }

        for (int i = 1; i <= total; i++) {
            System.out.println(shuffleChar(i));
        }
    }

    public String shuffleChar(int k) {
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        List<Character> temp = Arrays.asList(arr);
        List chars = new ArrayList<>(temp);

        k--;
        for (int i = arr.length; i > 0; i--) {
            mod = k % i;
            k = k / i;
            sb.append(chars.get(mod));
            chars.remove(mod);
        }
        return sb.toString();
    }


}
