package com.gudongcheng.springcloud.controller;

import com.gudongcheng.springcloud.common.ResponseMessage;
import com.gudongcheng.springcloud.entities.Payment;
import com.gudongcheng.springcloud.service.PaymentService;
import jdk.nashorn.internal.ir.ReturnNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.gudongcheng.springcloud.controller
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/1 22:15
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/list")
    public ResponseMessage listPayments() {
        log.info("开始查询数据");
        return ResponseMessage.ok(paymentService.list(), "");
    }

    @GetMapping("/payment/get/{id}")
    public ResponseMessage getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (Objects.isNull(payment)) {
            return ResponseMessage.ok(payment, "没有对应记录，查询ID：" + id);
        } else {
            return ResponseMessage.ok(payment, "查询成功，端口：" + serverPort);
        }

    }

    @PostMapping("/payment/create")
    public ResponseMessage createPayment(@RequestBody Payment payment) {
        int rows = paymentService.create(payment);
        if (rows > 0) {
            return ResponseMessage.ok(rows,"创建成功");
        }
        return ResponseMessage.ok(rows,"创建失败");

    }

    @DeleteMapping("/payment/delete/{id}")
    public ResponseMessage deletePaymentById(@PathVariable("id") Long id) {
        int rows = paymentService.deletePaymentById(id);
        if (rows > 0) {
            return ResponseMessage.ok(rows, "删除成功");
        }
        return ResponseMessage.ok(rows, "删除失败");
    }

    @PostMapping("/payment/update")
    public ResponseMessage updatePayment(@RequestBody Payment payment) {
        int rows = paymentService.update(payment);
        if (rows > 0) {
            return ResponseMessage.ok(rows, "修改成功");
        }
        return ResponseMessage.ok(rows, "修改失败");
    }
}
