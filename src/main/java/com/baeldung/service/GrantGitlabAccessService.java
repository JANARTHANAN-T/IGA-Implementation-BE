package com.baeldung.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class GrantGitlabAccessService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Gitlab access granted");
    }
}
