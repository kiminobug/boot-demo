package com.example.bootdemo.controller;

import com.example.bootdemo.entity.User;
import com.example.bootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class HelloWorldController {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello world";
    }

    @RequestMapping("/dbTest")
    @ResponseBody
    public List<Map<String, Object>> dbTest(){
        String sql = "select * from user";
        List<Map<String,Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }
        return list ;
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public String getUserInfo(@PathVariable("id") Long id){
        return userService.getUserById(id).toString();
    }

    @RequestMapping("/index/{id}")
    public String index(Map<String,Object> paramMap,@PathVariable("id") Long id){
        User user = new User();
        if(id != null) {
            user = userService.getUserById(id);
        }
        paramMap.put("user",user);
        return "index";
    }
}
