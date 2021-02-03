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
    public Result mockGet(@RequestParam(value = "mockParam") String mockParam){
        switch (mockParam){
            case "1":
                return Result.ok("get测试1");
            case "2":
                return Result.ok("get测试2");
            default:break;
        }
        return Result.ok("get测试3");
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
