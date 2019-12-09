package com.capusule.fse.taskmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capusule.fse.taskmanager.models.APIResponse;
import com.capusule.fse.taskmanager.models.Task;
import com.capusule.fse.taskmanager.response.ViewAllTaskResponse;
import com.capusule.fse.taskmanager.service.TaskService;

@RestController
@RequestMapping("/task")
//@CrossOrigin(origins = "http://localhost:8080")
public class TaskManagerResource {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/view/all")
	public ViewAllTaskResponse viewTask() {
		return taskService.getAllTask();
	}
	
	@PostMapping("/add")
	public APIResponse addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
	@PostMapping("/delete")
	public APIResponse deleteTask(@RequestBody Task task) {
		return taskService.deleteTask(task);
	}
	
	@PostMapping("/update")
	public APIResponse updateTask(@RequestBody Task task) {
		return taskService.updateTask(task);
	}
}
