package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类：

//1.lombok的注解：@Data
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class User_lombok {
    private int id;
    private String name;
    private String password;


}
