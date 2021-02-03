package cn.beichenhpy.unittestdemo.controller;

import cn.beichenhpy.unittestdemo.entity.Person;
import cn.beichenhpy.unittestdemo.entity.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author beichenhpy
 * @version 1.0
 * @description TODO
 * @since 2021/2/3 8:57
 */
@RestController
@RequestMapping("/mock")
public class MockController {
    private static final Integer LEGAL_AGE = 18;

    @GetMapping("/get")
    public String mockGet(@RequestParam(value = "mockParam") String mockParam){
        switch (mockParam){
            case "1":
                return "mock_1";
            case "2":
                return "mock_2";
            default:break;
        }
        return "mockGet";
    }

    @PostMapping("/post")
    public Result mockPost(@RequestBody Person person){
        if (person.getAge() >= LEGAL_AGE){
            return Result.ok("允许进入");
        }else {
            return Result.ok("限制进入");
        }
    }
}
