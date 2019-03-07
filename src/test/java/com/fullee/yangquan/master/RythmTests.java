package com.fullee.yangquan.master;

import org.junit.Test;
import org.rythmengine.Rythm;

import java.util.HashMap;
import java.util.Map;

public class RythmTests {

    @Test
    public void testRythm() {

        Map<String, Object> map = new HashMap<String, Object>();
        // tell rythm where to find the template files
        map.put("home.template", "E:\\gitrepo\\htkj\\htkjrepo\\osk_framework\\src\\test\\resources");
        Rythm.init(map);

//        System.out.println(Rythm.render("index.html", "World"));


        User user = new User();
        user.setName("liwenliang");
        String render = Rythm.render("J.java", "System.out.println(Rythm.render(\"index.html\", \"World\"));", user);

        System.out.println(render);

    }
}
