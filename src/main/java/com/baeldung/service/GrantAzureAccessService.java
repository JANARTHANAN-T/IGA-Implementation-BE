package com.baeldung.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class GrantAzureAccessService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Initiated request to Devops admin for Azure access");
    }
}
