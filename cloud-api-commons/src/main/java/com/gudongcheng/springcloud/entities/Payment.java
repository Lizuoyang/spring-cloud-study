package com.gudongcheng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 支付模块实体类
 * </p>
 *
 * @package: com.gudongcheng.springcloud.entities
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/1 21:50
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 5063696886568850568L;

    private Long id;
    private String serialNumber;
}
