package com.will.demo.controller;

import com.will.demo.dao.GirlDao;
import com.will.demo.service.GirlService;
import com.will.demo.vo.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GirlDao girlDao;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/getAllList")
    public List<Girl> getGirlList(){
        logger.info("打出女生所有列表");
        return girlDao.findAll();
    }

    @PostMapping(value = "/addGirl")
    public Girl addGril(){
        Girl girl=new Girl();
        girl.setName("唐小东");
        girl.setSchool("王官营高中");
        return girlDao.save(girl);
    }

    @GetMapping(value = "/getGirl/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlDao.findOne(id);
    }
    @PostMapping(value = "/getGirlsByName/{name}")
    public List<Girl> getGirlsByName(@PathVariable("name")String name){
        return girlDao.getGirlsByName(name);
    }

    @PutMapping(value = "/saveGirl/{id}")
    public Girl saveGirl(@PathVariable("id") Integer id,
                         @RequestParam("name")String name,
                         @RequestParam("school")String school){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setSchool(school);
        return girlDao.save(girl);
    }
    @DeleteMapping(value = "/deleteGirl/{id}")
    public void deleteGirl(@PathVariable("id")Integer id){
        girlDao.delete(id);
    }
    @PostMapping(value = "/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }
    @GetMapping(value = "/getGirlByNameAndSchool")
    public Girl getGirlByNameAndSchool(){
        return girlDao.queryByNameAndSchool1("唐伟健","长春大学");
    }
    @GetMapping(value = "/getGirlLikeName")
    public List<Girl> getGirlLikeName(){
        return girlDao.queryGirlsLikeFirstName("唐");
    }


}
