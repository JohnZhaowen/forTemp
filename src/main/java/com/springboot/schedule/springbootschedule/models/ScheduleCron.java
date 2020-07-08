package com.springboot.schedule.springbootschedule.models;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * author: zhaowen.he
 * date: 2020/7/8
 * ticket:
 * description:
 */
@Data
public class ScheduleCron {

    private Long id;

    private String cronKey;

    private String cronExpression;

    private String taskExplain;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
