/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Dell
 */
@Controller
public class DemoController {
    
    @RequestMapping("/")
    public String showHome(){
        return "index";
    }
    
    // addd request mapping for /leaders
    @RequestMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }
    
    // addd request mapping for /systems
    @RequestMapping("/systems")
    public String showsystems(){
        return "systems";
    }
}
