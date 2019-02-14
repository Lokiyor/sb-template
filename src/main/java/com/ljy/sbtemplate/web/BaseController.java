package com.ljy.sbtemplate.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lokiy
 * @date 2019/2/14
 * @description
 */
@RestController
public class BaseController {


    @GetMapping("/first")
    public String first(){
        return "success";
    }
}
