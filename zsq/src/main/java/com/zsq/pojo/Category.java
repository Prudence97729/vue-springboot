package com.zsq.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
    @NotNull(groups = Update.class)
    private Integer id;//主键ID
    @NotEmpty
    private String categoryName;//分类名称
    @NotEmpty
    private String categoryAlias;//分类别名
    private Integer createUser;//创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;//更新时间

    //@Validation分组校验
    //如果上面属性没有指定校验分组，则属于默认分组
    //分组之间可以继承，A extends B ，那么A中有B中所有校验项。
    //即Add中包含有上面没有分组的校验项
    public interface Add extends Default {

    }
    public interface Update extends Default {

    }

}
