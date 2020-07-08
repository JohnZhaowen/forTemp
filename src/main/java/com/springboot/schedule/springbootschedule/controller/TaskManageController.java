package com.springboot.schedule.springbootschedule.controller;

import com.springboot.schedule.springbootschedule.mapper.ScheduleCronMapper;
import com.springboot.schedule.springbootschedule.models.LayuiResponse;
import com.springboot.schedule.springbootschedule.models.ScheduleCron;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: zhaowen.he
 * date: 2020/7/8
 * ticket:
 * description:
 */
@Controller
@RequestMapping("/mdi/task")
@Slf4j
public class TaskManageController {

    @Autowired
    private ScheduleCronMapper scheduleCronMapper;

    @PostMapping("")
    public String addTask(@RequestBody ScheduleCron scheduleCron){

        //入库
        boolean success = scheduleCronMapper.insertScheduleCron(scheduleCron);

        return "hello";
    }

    @DeleteMapping("")
    public String removeTask(String key){
        boolean success = scheduleCronMapper.delByKey(key);
        return null;
    }

    @PutMapping("/pause")
    public String pause(String key){
        boolean success = scheduleCronMapper.pauseTask(key);

        return null;
    }


    @PutMapping("/restart")
    public String restart(String key){
        boolean success = scheduleCronMapper.restartTask(key);

        return null;
    }


    @PutMapping("")
    public String updateCron(ScheduleCron scheduleCron){
        boolean success = scheduleCronMapper.updateTask(scheduleCron);
        return null;
    }

    @GetMapping("/taskPage")
    public String tasksPage(){
        return "task-list";
    }

    @GetMapping("/allTasks")
    @ResponseBody
    public LayuiResponse<List<ScheduleCron>> allTasks(){
        List<ScheduleCron> scheduleCrons = scheduleCronMapper.findAll();
        LayuiResponse<List<ScheduleCron>> response = new LayuiResponse(0, "查询成功", scheduleCrons.size(), scheduleCrons);
        return response;
    }

    @GetMapping("/allActive")
    public String findAllActive(){

        List<ScheduleCron> all = scheduleCronMapper.findAllActive();


        return null;
    }


    @GetMapping("/byKey")
    public String findByKey(String key){
        ScheduleCron scheduleCron = scheduleCronMapper.findByCronKey(key);
        return null;
    }


}
