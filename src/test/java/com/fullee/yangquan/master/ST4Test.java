package com.fullee.yangquan.master;

import org.junit.Test;
import org.stringtemplate.v4.ST;

public class ST4Test {


    @Test
    public void testST(){
        ST hello = new ST("Hello, <name>");
        hello.add("name", "World");
        System.out.println(hello.render());


    }
}
