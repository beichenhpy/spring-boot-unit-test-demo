package cn.beichenhpy.unittestdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author beichenhpy
 * @version 1.0
 * @description TODO
 * @since 2021/2/3 10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private Integer code;
    private Object result;
    public static Result ok(Object result){
        return new Result(200,result);
    }
}
