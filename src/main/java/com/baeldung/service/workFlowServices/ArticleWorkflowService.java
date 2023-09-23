package com.baeldung.service.workFlowServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baeldung.service.repositaryServices.UserRepToModel;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.ActivityInstanceQueryImpl;
import org.flowable.engine.runtime.ActivityInstance;
import org.flowable.engine.runtime.ActivityInstanceQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.domain.Approval;
import com.baeldung.domain.Article;

@Service
public class ArticleWorkflowService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private HistoryService historyService;

    @Transactional
    public void startProcess(Article article) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("author", article.getAuthor());
        variables.put("url", article.getUrl());
        variables.put("userId", article.getUserId());
        variables.put("email", article.getEmail());
        variables.put("role", article.getRole());
        UserRepToModel.createUserFromRep(article);

        runtimeService.createExecutionQuery().onlyProcessInstanceExecutions().list();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(article.getRole(), variables);


        ActivityInstanceQuery a = new ActivityInstanceQueryImpl();
        System.out.println(a.activityId(processInstance.getActivityId()).singleResult().getTaskId());
//        Task task = taskService.createTaskQuery().singleResult();
//        System.out.println(task.getId());
    }

    @Transactional
    public List<Article> getTasks(String assignee) {
        List<Task> tasks = taskService.createTaskQuery()
          .taskCandidateGroup(assignee)
          .list();

        return tasks.stream()
          .map(task -> {
              Map<String, Object> variables = taskService.getVariables(task.getId());
              return new Article(
                task.getId(), (String) variables.get("author"), (String) variables.get("url"), (String) variables.get("userId"), (String) variables.get("email"), (String) variables.get("role"));
          })
          .collect(Collectors.toList());
    }

    @Transactional
    public void submitReview(Approval approval) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approval.isStatus());
        taskService.complete(approval.getId(), variables);
    }
}