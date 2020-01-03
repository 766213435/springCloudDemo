package com.springcloud.discovery.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jiangmh
 * @company GeekPlus
 * @create 2019-11-14 16:47
 **/
@Table(name = "t_user")
@Entity
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private Short age;

}