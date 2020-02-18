package com.ljy.sbtemplate.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lokiy
 * @date 2019/2/14
 * @description
 */
@Slf4j
@RestController
public abstract class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
}
