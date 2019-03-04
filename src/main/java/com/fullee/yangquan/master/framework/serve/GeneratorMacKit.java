package com.fullee.yangquan.master.framework.serve;

import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class GeneratorMacKit {

    public static String createdMAC(String prefix) {
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        ISystemGeneratorMacService service = context.getBean(ISystemGeneratorMacService.class);
        return service.createdMAC(prefix);
    }

}
