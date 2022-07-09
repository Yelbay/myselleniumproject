package com.myfirstproject.practice02;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q06 {
    //verify that we have pom.xml
    @Test
    public void test() {
        String homePath = System.getProperty("user.home");
        String filePath = homePath + "/IdeaProjects/myselleniumproject/pom.xml";
        String absoulutePath = "/Users/mujdatyelbay/IdeaProjects/myselleniumproject/pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
/*
package com.practice02;
​
import org.junit.Assert;
import org.junit.Test;
​
import java.nio.file.Files;
import java.nio.file.Paths;
​
public class Q06 {
​
    @Test
    public void test() {
​
        //Verify that we have pom.xml file in our project => please try in 4 min s
​
        String homePath = System.getProperty("user.home");
​
        String filePath = homePath + "\\IdeaProjects\\myseleniumprojectwinter2022\\pom.xml";
​
        String absoultePath = "C:\\Users\\tugba\\IdeaProjects\\myseleniumprojectwinter2022\\pom.xml";
​
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
​
​
    }
​
}
Collapse
 */