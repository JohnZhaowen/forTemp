package com.springboot.schedule.springbootschedule.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LayuiResponse<T> {

    private int code;

    private String msg;

    private int count;

    private T data;
}
