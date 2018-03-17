package com.huawei.rtn.testtool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NeNavigatorController {

    @RequestMapping(value="/neNavigator/{ip}", method = RequestMethod.GET)
    public String navigator(@PathVariable String ip) {
        return "neNavigator";
    }
}
