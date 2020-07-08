package com.springboot.schedule.springbootschedule.mapper;

import com.springboot.schedule.springbootschedule.models.ScheduleCron;

import java.util.List;

public interface ScheduleCronMapper {

    List<ScheduleCron> findAll();

    List<ScheduleCron> findAllActive();

    ScheduleCron findByCronId(Long id);

    ScheduleCron findByCronIdActive(Long id);

    ScheduleCron findByCronKey(String cronKey);

    ScheduleCron findByCronKeyActive(String cronKey);

    boolean insertScheduleCron(ScheduleCron scheduleCron);

    boolean delByKey(String cronKey);

    boolean pauseTask(String cronKey);

    boolean restartTask(String cronKey);

    boolean updateTask(ScheduleCron scheduleCron);
}
