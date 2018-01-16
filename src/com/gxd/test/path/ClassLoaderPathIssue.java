package com.gxd.test.path;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by gxdgodgxd on 17/10/12.
 */
public class ClassLoaderPathIssue {

    public static void main(String[] args) throws IOException {
        String file = ClassLoader.getSystemResource("prop.conf").getFile();
        Properties props = new Properties();
        props.load(new FileInputStream(file));


        String name = props.getProperty("name");
        String adj = props.getProperty("isHandsome");

        System.out.println(name + "is Handsome ? " + adj);

    }

}
