package com.jgz.config.server.config.controller;

import com.jgz.config.server.config.mapper.ConfigMapper;
import com.jgz.config.server.config.model.Config;
import com.jgz.config.server.config.model.ConfigExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ConfigController {

    @Resource
    private ConfigMapper configMapper;

    @GetMapping("/getConfig")
    public List<Config> getConfig() {
       return configMapper.selectByExample(new ConfigExample());
    }



}
