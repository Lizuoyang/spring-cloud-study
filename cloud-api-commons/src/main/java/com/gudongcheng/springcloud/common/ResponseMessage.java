package com.gudongcheng.springcloud.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.*;

/**
 * json通用返回类
 * @return
 * @exception 
 * @author Zero_Li
 * @date 2020/5/1 22:10 
 * @param
 **/
@Slf4j
public class ResponseMessage<T> implements Serializable {
    private static final long serialVersionUID = 8282603426818333643L;

    protected String message;

    protected T result;

    protected int status = 500;

    private Long timestamp;

    public ResponseMessage() {
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public static <T> ResponseMessage<T> error(String message) {
        return error(500, message);
    }

    public static <T> ResponseMessage<T> error(int status, String message) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        msg.message = message;
        msg.status(status);
        return msg.putTimeStamp();
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null,null);
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public static <T> ResponseMessage<T> ok(T result,String message) {
        return new ResponseMessage<T>()
                .result(result)
                .message(message)
                .putTimeStamp()
                .status(200);
    }

    public ResponseMessage<T> result(T result) {
        this.result = result;
        return this;
    }

    public ResponseMessage<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * 过滤字段：指定需要序列化的字段
     */
    @JsonIgnore
    private transient Set<String> includes;

    /**
     * 过滤字段：指定不需要序列化的字段
     */
    @JsonIgnore
    private transient Set<String> excludes;


    public ResponseMessage<T> include(String... fields) {
        return include(Arrays.asList(fields));
    }

    public ResponseMessage<T> include(Collection<String> fields) {
        if (Objects.isNull(includes)) {
            includes = new HashSet<>();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        fields.forEach(field -> {
            includes.add(field);
        });
        return this;
    }

    public ResponseMessage<T> exclude(String... fields) {
        return exclude(Arrays.asList(fields));
    }

    public ResponseMessage<T> exclude(Collection<String> fields) {
        if (Objects.isNull(excludes)) {
            excludes = new HashSet<>();
        }
        if (fields == null || fields.isEmpty()) {
            return this;
        }
        fields.forEach(field -> {
            excludes.add(field);
        });
        return this;
    }


    protected Set<String> getStringListFromMap(Map<Class<?>, Set<String>> map, Class type) {
        return map.computeIfAbsent(type, k -> new HashSet<>());
    }


    public ResponseMessage<T> status(int status) {
        this.status = status;
        return this;
    }

    public Set<String> getExcludes() {
        return excludes;
    }

    public Set<String> getIncludes() {
        return includes;
    }
}
