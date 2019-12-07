package com.capusule.fse.taskmanager.service;

import static com.capusule.fse.taskmanager.common.ApplicationConstants.DATE_DDMMYYYY;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.capusule.fse.taskmanager.entity.ParentTaskEntity;
import com.capusule.fse.taskmanager.entity.TaskEntity;
import com.capusule.fse.taskmanager.enums.ErrorCodes;
import com.capusule.fse.taskmanager.exception.AppException;
import com.capusule.fse.taskmanager.models.APIResponse;
import com.capusule.fse.taskmanager.models.Task;
import com.capusule.fse.taskmanager.repo.ParentTaskRepository;
import com.capusule.fse.taskmanager.repo.TaskRepository;
import com.capusule.fse.taskmanager.response.ViewAllTaskResponse;
import com.capusule.fse.taskmanager.util.DateTimeUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ParentTaskRepository parentTaskRepo;

	public ViewAllTaskResponse getAllTask() {
		log.info("get all task items");
		ViewAllTaskResponse response = new ViewAllTaskResponse();
		List<TaskEntity> allTask = taskRepo.findAll();
		if (!CollectionUtils.isEmpty(allTask)) {
			List<Task> taskList = new ArrayList<>();
			allTask.stream().forEach(taskEntity -> {
				Task task = new Task();
				task.setTask(taskEntity.getTask());
				task.setTaskId(String.valueOf(taskEntity.getTaskId()));
				if (Objects.nonNull(taskEntity.getParentTask())) {
					task.setParentTask(taskEntity.getParentTask().getParentTask());
					task.setParentTaskId(String.valueOf(taskEntity.getParentTask().getParentId()));
				}
				task.setPriority(taskEntity.getPriority());
				task.setStartDate(DateTimeUtil.INSTANCE.convertDateToString(taskEntity.getStartDate(), DATE_DDMMYYYY));
				task.setEndDate(DateTimeUtil.INSTANCE.convertDateToString(taskEntity.getEndDate(), DATE_DDMMYYYY));
				LocalDateTime endDate = taskEntity.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				if(!LocalDate.now().isAfter(endDate.toLocalDate())) {
					task.setEditable(true);
				}
				taskList.add(task);
			});
			response.setTaskList(taskList);
		}
		return response;
	}

	public APIResponse addTask(Task task) {
		log.info("Add task");
		APIResponse response = new APIResponse();
		TaskEntity entity = new TaskEntity();
		entity = enrichTaskEntiry(task, entity);
		if(StringUtils.isNotBlank(task.getParentTask())) {
			ParentTaskEntity parentEntity = enrichParentTaskEntiry(task);
			entity.setParentTask(parentTaskRepo.save(parentEntity));
			log.info("parent task saved successfully");
		}
		try {
			taskRepo.save(entity);
			log.info("task saved successfully");
		} catch(Exception e) {
			log.info("Issue in task addition is {}", e.getMessage());
			throw new AppException(ErrorCodes.SYS_DB_ERROR);
			
		}
		
		return response;
	}

	private TaskEntity enrichTaskEntiry(Task task, TaskEntity entity) {
		entity.setTask(task.getTask());
		entity.setPriority(task.getPriority());
		entity.setStartDate(DateTimeUtil.INSTANCE.convertStringToDate(task.getStartDate(), DATE_DDMMYYYY));
		entity.setEndDate(DateTimeUtil.INSTANCE.convertStringToDate(task.getEndDate(), DATE_DDMMYYYY));
		return entity;
	}

	public APIResponse deleteTask(Task task) {
		log.info("Delete task");
		APIResponse response = new APIResponse();
		if(StringUtils.isBlank(task.getTaskId())) {
			throw new AppException(ErrorCodes.SYS_INVALID_REQUEST);
		}
		Optional<TaskEntity> taskEntiry = taskRepo.findById(Long.parseLong(task.getTaskId()));
		if(!taskEntiry.isPresent()) {
			throw new AppException(ErrorCodes.SYS_INVALID_REQUEST);
		}
		try {
			taskEntiry.ifPresent(entity -> {
				taskRepo.deleteById(entity.getTaskId());
				if(Objects.nonNull(entity.getParentTask())) {
					List<TaskEntity> parentTaskList = taskRepo.findByParentTask(entity.getParentTask());
					if(CollectionUtils.isEmpty(parentTaskList)) {
						log.info("No tasks linked to the parent task");
						parentTaskRepo.deleteById(entity.getParentTask().getParentId());
						log.info("parent task deleted");
					}
				}
			});
			
		} catch(Exception e) {
			throw new AppException(ErrorCodes.SYS_DB_ERROR);
		}
		return response;
	}

	public APIResponse updateTask(Task task) {
		log.info("Update task");
		APIResponse response = new APIResponse();
		Optional<TaskEntity> taskEntiry = taskRepo.findById(Long.parseLong(task.getTaskId()));
		taskEntiry.ifPresent(entity -> {
			entity = enrichTaskEntiry(task, entity);
			if(StringUtils.isNotBlank(task.getParentTask())) {
				if(Objects.nonNull(entity.getParentTask()) && StringUtils.isBlank(task.getParentTaskId())) {
					throw new AppException(ErrorCodes.SYS_INVALID_REQUEST);
				} else if((Objects.nonNull(entity.getParentTask()) 
					&& StringUtils.isNotBlank(entity.getParentTask().getParentTask()) 
					&& !task.getParentTask().equals(entity.getParentTask().getParentTask())) 
						|| Objects.isNull(entity.getParentTask())) {
					ParentTaskEntity parentEntity = enrichParentTaskEntiry(task);
					entity.setParentTask(parentTaskRepo.save(parentEntity));
					log.info("parent task updated successfully");
				}
			} else if (Objects.nonNull(entity.getParentTask())) {
				entity.setParentTask(null);
				
			}
			try {
				taskRepo.save(entity);
				log.info("task updated successfully");
			} catch(Exception e) {
				throw new AppException(ErrorCodes.SYS_DB_ERROR);
			}
		});
		
		return response;
	}

	private ParentTaskEntity enrichParentTaskEntiry(Task task) {
		ParentTaskEntity parentEntity = new ParentTaskEntity();
		parentEntity.setParentTask(task.getParentTask());
		return parentEntity;
	}

}
