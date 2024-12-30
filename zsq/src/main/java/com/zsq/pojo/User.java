package com.zsq.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
//lombook小工具，在编译阶段为实体类自动生成setter getter tostring等
//要使用此工具需要在pom文件中引入依赖，在实体类上添加注解
@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore//把当前对象转换成Json字符串的时候忽略password
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
