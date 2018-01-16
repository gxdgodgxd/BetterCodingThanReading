package com.gxd.test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gxdgodgxd on 17/11/6.
 */
public class CalendarTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, 10);
        System.out.println(date.toString());

    }

}
