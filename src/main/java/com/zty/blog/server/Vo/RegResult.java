package com.zty.blog.server.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;

//1010注册成功,2002该邮箱已注册
@Data
public class RegResult {
    private int code=1010;
    private String msg;

}
