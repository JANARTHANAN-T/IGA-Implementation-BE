package com.baeldung.service.workFlowServices;

import java.util.*;
import java.util.stream.Collectors;

import com.baeldung.domain.*;
import com.baeldung.helper.Helper;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import com.baeldung.service.repositaryServices.UserRepToModel;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.ActivityInstanceQueryImpl;
import org.flowable.engine.runtime.ActivityInstance;
import org.flowable.engine.runtime.ActivityInstanceQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleWorkflowService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;

    @Transactional
    public void startProcess(User user) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("userId", user.getUserId());
        variables.put("email", user.getEmail());
        variables.put("role", user.getRole());
        UserRepToModel.createUserFromRep(user);

        runtimeService.createExecutionQuery().onlyProcessInstanceExecutions().list();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(article.getRole(), variables);


        ActivityInstanceQuery a = new ActivityInstanceQueryImpl();
        System.out.println(a.activityId(processInstance.getActivityId()).singleResult().getTaskId());
//        Task task = taskService.createTaskQuery().singleResult();
//        System.out.println(task.getId());
    }

    @Transactional
    public List<Step> getAllTasks() {
        List<Task> tasks = taskService.createTaskQuery().list();
        return tasks.stream()
                .map(task -> {
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new Step(task.getId(), task.getName(), task.getDescription(), task.getPriority(), "Kiran", (String) variables.get("userId"), task.getProcessInstanceId());
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Step> getOpenTasksForUser(String userId) {
        List<Task> tasks = taskService.createTaskQuery().list();
        return tasks.stream()
                .filter(task -> Optional.ofNullable(taskService.getVariable(task.getId(), "userId")).orElse("").equals(userId))
                .map(task -> {
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new Step(task.getId(), task.getName(), task.getDescription(), task.getPriority(), "Kiran", (String) variables.get("userId"), task.getProcessInstanceId());
                })
                .collect(Collectors.toList());

    }

    @Transactional
    public List<Step> getCompletedTasksForUser(String userId) {
        List<HistoricTaskInstance> tasks = historyService.createHistoricTaskInstanceQuery().list();
        return tasks.stream()
                //TODO add filter for userid
                .filter(task -> task.getEndTime() != null)
                .map(task -> {
                    Map<String, Object> variables = taskService.getVariables(task.getId());
                    return new Step(task.getId(), task.getName(), task.getDescription(), task.getPriority(), "Kiran", (String) variables.get("userId"), task.getProcessInstanceId());
                })
                .collect(Collectors.toList());

    }

    @Transactional
    public List<Subtask> getSubtasks(String processInstanceId) {
        List<HistoricActivityInstance> activityInstances = historyService
                .createHistoricActivityInstanceQuery()
                .processInstanceId(processInstanceId)
                .orderByHistoricActivityInstanceStartTime().asc()
                .list();
        List<Subtask> subtasks = activityInstances.stream()
                .filter(activityInstance -> activityInstance.getActivityType().equals("serviceTask") || activityInstance.getActivityType().equals("userTask"))
                .map(activityInstance -> new Subtask(activityInstance.getId(), activityInstance.getProcessInstanceId(), activityInstance.getActivityName(),
                        activityInstance.getStartTime().toString(), activityInstance.getEndTime() != null ? activityInstance.getEndTime().toString() : "", activityInstance.getDurationInMillis(),
                        activityInstance.getEndTime() != null ? "DONE" : "PENDING")).collect(Collectors.toList());

        List<Subtask> uninitiatedSubtasks = Helper.getMissingSubtasks(subtasks).stream()
                .map(subtask -> new Subtask("", "", subtask, "", "", 0L, "NOT_STARTED"))
                .collect(Collectors.toList());
        subtasks.addAll(uninitiatedSubtasks);
        return subtasks;
    }

    @Transactional
    public void submitReview(Approval approval) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approval.isStatus());
        taskService.complete(approval.getId(), variables);
    }
}