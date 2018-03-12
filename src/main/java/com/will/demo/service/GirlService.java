package com.will.demo.service;

import com.will.demo.dao.GirlDao;
import com.will.demo.mapper.GirlMapper;
import com.will.demo.vo.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class GirlService {
    @Autowired
    private GirlDao girlDao;

    @Autowired
    private GirlMapper girlMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public void insertTwo(){
        Girl a=new Girl();
        a.setName("卜祥杰");
        a.setSchool("北京大学");
        girlMapper.insertGirl(a);

        System.out.println("可调用开始");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("可调用结束");
//        Girl b=new Girl();
//        b.setName("王超");
//        b.setSchool("长春大学22222");
//        girlMapper.insertGirl(a);
//
//       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚事物
//
//        List<Girl> girls=girlDao.getGirlsByName("王超");

        System.out.println("数据保存成功");
    }
}
