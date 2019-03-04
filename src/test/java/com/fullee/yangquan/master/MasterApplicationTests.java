package com.fullee.yangquan.master;

import com.fullee.yangquan.master.system.model.SystemGeneratorMac;
import com.fullee.yangquan.master.system.repository.SystemGeneratorMacRepository;
import com.fullee.yangquan.master.system.service.ISystemGeneratorMacService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasterApplicationTests {

	@Test
	public void contextLoads() {


	}

	@Autowired
	private ISystemGeneratorMacService service;

	@Test
	public void testService() {
		String oskd = service.createdMAC("OSKD");
		System.out.println(oskd);
	}

}
