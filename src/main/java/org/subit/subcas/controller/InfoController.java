package org.subit.subcas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.subit.subcas.dto.Result;

@RestController
public class InfoController {
    @RequestMapping("/hello")
    public Result hello() {
        return Result.success("Hello World");
    }
}
