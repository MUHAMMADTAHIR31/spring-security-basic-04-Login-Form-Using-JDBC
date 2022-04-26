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
public class LoginController {
    
    @RequestMapping("/showMyLoginPage")
    public String showMyLoginPage(){ 
        
        //return "plain-login";
        return "fancy-login";
    }
    
    // add request for access-denied
     @RequestMapping("/access-denied")
    public String showAccessDenied(){ 
        
        return "access-denied";
    }
    
    
}
