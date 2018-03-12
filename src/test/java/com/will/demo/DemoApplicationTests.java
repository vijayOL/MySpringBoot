package com.will.demo;

import com.will.demo.mapper.UserMapper;
import com.will.demo.service.GirlService;
import com.will.demo.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GirlService girlService;

	@Test
	public void userTest() {
		User user=userMapper.queryUserByName("唐丽娟");
		System.out.println(user.getPhone());
	}
	@Test
	public void insertTest() {
		girlService.insertTwo();
	}

}
