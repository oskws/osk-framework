package com.fullee.yangquan.master.framework.serve;

import com.fullee.yangquan.master.system.model.SystemGeneratorMac;
import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class GeneratorMAC {

    public String createMac(String prefix) {
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

        ISystemGeneratorMacService service = context.getBean(ISystemGeneratorMacService.class);
        return service.createdMAC(prefix);
    }
}
