package com.baeldung.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class FailureNotificationService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Sorry, unable to onboard user!!");
    }

}
