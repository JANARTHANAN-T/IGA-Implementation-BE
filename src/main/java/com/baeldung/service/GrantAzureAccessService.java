package com.baeldung.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class GrantAzureAccessService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        execution.setVariable("owner", "kirankumar.j@grootan.com");
        execution.setVariable("activityId", execution.getCurrentActivityId());
        execution.setVariable("processId",execution.getProcessInstanceId());
        System.out.println("Initiated request to Devops admin for Azure access");
    }
}
