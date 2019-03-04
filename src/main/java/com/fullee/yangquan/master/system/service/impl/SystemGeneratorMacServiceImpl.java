package com.fullee.yangquan.master.system.service.impl;

import com.fullee.yangquan.master.system.model.SystemGeneratorMac;
import com.fullee.yangquan.master.system.repository.SystemGeneratorMacRepository;
import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import org.osgl.util.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SystemGeneratorMacServiceImpl implements ISystemGeneratorMacService {

    @Autowired
    private SystemGeneratorMacRepository repository;

    @Override
    public String createdMAC(String prefix) {

        S.Buffer buffer = S.newBuffer(prefix);

        SystemGeneratorMac mac = repository.findByPrefix(prefix);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String format = LocalDateTime.now().format(dateTimeFormatter);
        buffer.append(format);

        // 更新记录
        // String formatter = mac.getFormatter();

        String currVal = mac.getCurrVal();
        //String p = "ABCD1234567891234500045678912345";
        String s = S.last(currVal, 14);


        AtomicLong atomicLong = new AtomicLong(Long.valueOf(s));
        long l = atomicLong.addAndGet(mac.getStep());
        String lpad = S.lpad(String.valueOf(l), '0', 14 - String.valueOf(l).length());

        buffer.append(lpad);

        mac.setCurrVal(buffer.toString());

        repository.saveAndFlush(mac);

//        S.padLeft()


        // 拼接MAC


        return buffer.toString();
    }
}
