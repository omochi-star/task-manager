package com.example.task_manager.controller.task;

import com.example.task_manager.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public String list(Model model){
        var taskList = taskService.find();
        model.addAttribute("taskList",taskList);
        return "tasks/list";
    }

}
