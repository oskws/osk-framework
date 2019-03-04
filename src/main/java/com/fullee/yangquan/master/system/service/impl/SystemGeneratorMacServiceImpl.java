package com.fullee.yangquan.master.system.service.impl;

import com.fullee.yangquan.master.system.model.SystemGeneratorMac;
import com.fullee.yangquan.master.system.repository.SystemGeneratorMacRepository;
import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import org.osgl.util.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class SystemGeneratorMacServiceImpl implements ISystemGeneratorMacService {

    @Autowired
    private SystemGeneratorMacRepository repository;

    public String createdMAC(String prefix){
        SystemGeneratorMac systemGeneratorMac = repository.findByPrefix(prefix);

        String formatter = systemGeneratorMac.getFormatter();
        String initVal = systemGeneratorMac.getInitVal();
        String currVal = systemGeneratorMac.getCurrVal();
        Integer step = systemGeneratorMac.getStep();

        AtomicLong atomicLong = new AtomicLong(Long.valueOf(S.last(currVal,14)));
        atomicLong.addAndGet(step);




        repository.saveAndFlush(systemGeneratorMac);

        return systemGeneratorMac.getCurrVal();
    }

//    public enum Pretten{
////        YY("yy"),
//        YYYY("yyyy"),
//        MM("MM"),
//        DD("dd"),
//        HH("HH"),
//        Minute("mm"),
//        SS("ss");
//
//        private String format;
//
//        Pretten(String format) {
//            this.format = format;
//        }
//    }


    public static void main(String[] args) {
        System.out.println(S.last("ASDF2019112311223300000000001234",14));

        Long last = Long.valueOf(S.last("ASDF2019112311223300000000001234", 14));
        AtomicLong atomicLong = new AtomicLong(4);
        long l = atomicLong.addAndGet(last);
        System.out.println(l);
    }
}
