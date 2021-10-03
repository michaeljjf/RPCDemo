package com.jiangjf.controller;

import com.jiangjf.com.jiangjf.service.PersonService;
import com.jiangjf.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiangjf
 * @date 2021/10/3
 */
@Controller
public class PersonController {

    @Resource
    private PersonService personService;

    @RequestMapping("/show")
    @ResponseBody
    public List<Person> show() {
        return personService.show();
    }
}
