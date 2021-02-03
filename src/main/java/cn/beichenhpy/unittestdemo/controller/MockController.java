package cn.beichenhpy.unittestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author beichenhpy
 * @version 1.0
 * @description TODO
 * @since 2021/2/3 8:57
 */
@RestController
@RequestMapping("/mock")
public class MockController {

    @GetMapping("/get")
    public String mockGet(String mockParam){
        switch (mockParam){
            case "1":
                return "mock_1";
            case "2":
                return "mock_2";
            default:break;
        }
        return "mockGet";
    }
}
