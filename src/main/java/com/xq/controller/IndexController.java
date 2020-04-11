package com.xq.controller;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/2/3 18:35
 */
@Controller
public class IndexController {
    @RequestMapping({"*.html","*/*.html"})
    public String index(){
        return null;
    }
}
