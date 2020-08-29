package com.ybm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by YBM on 2020/8/29 20:47
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//在企业中所有的pojo都会序列化！Springboot
public class User implements Serializable {

    private String name;
    private int age;
}
