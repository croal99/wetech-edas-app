package tech.wetech.edas.demo.service.impl;

import tech.wetech.edas.api.demo.service.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String hello(String name) {
        return "hello," + name + "!";
    }
}
