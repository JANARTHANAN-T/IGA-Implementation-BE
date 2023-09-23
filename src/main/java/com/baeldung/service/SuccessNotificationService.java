package com.baeldung.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SuccessNotificationService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        System.out.println("Successfully onboarded user");
    }
}
