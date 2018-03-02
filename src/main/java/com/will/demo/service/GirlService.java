package com.will.demo.service;

import com.will.demo.dao.GirlDao;
import com.will.demo.vo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlDao girlDao;

    @Transactional
    public void insertTwo(){
        Girl a=new Girl();
        a.setName("唐翠婷");
        a.setSchool("衡水师范");
        girlDao.save(a);

        Girl b=new Girl();
        b.setName("王超");
        b.setSchool("长春大学1111111");
        girlDao.save(b);
    }
}
