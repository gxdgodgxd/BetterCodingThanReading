package com.gxd.test.path;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by gxdgodgxd on 17/10/12.
 */
public class ClassLoaderPathIssue {

    public static void main(String[] args) throws IOException {
//        String file = ClassLoader.getSystemResource("prop.conf").getFile();
        InputStream file = ClassLoader.getSystemResourceAsStream("prop.conf");
//        String file = ClassLoaderPathIssue.class.getResource("/prop.conf").getFile();
//        InputStream file = ClassLoaderPathIssue.class.getResourceAsStream("/prop.conf");
//        String file = ClassLoaderPathIssue.class.getClassLoader().getResource("prop.conf").getFile();
//        InputStream file = ClassLoaderPathIssue.class.getClassLoader().getResourceAsStream("prop.conf");
        Properties props = new Properties();
        props.load(file);
//        props.load(new FileInputStream(file));

        String name = props.getProperty("name");
        String adj = props.getProperty("isHandsome");

        System.out.println(name + " is Handsome ? " + adj);

    }

}
