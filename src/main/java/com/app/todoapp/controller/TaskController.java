package com.app.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todoapp.models.Task;
import com.app.todoapp.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;  // constructor ijection to inject the dependency of Service class in Contoller on runtime.
	}
	
	@GetMapping("/")
	public String getTasks(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks); // to add tasks into UI
		return "tasks"; // would render tasks.html under resouces/ templates
	}
	
	@PostMapping("/")
	public String createTask(@RequestParam String titleFromUi) {
		taskService.createTask(titleFromUi);
		
		return "redirect:/tasks/";  // AFTER THE POST REQUEST IS MADE, THE PAGE IS REDIRECTED TO THE /tasks/ which GET Mapping is listening to.
		
	}

}
