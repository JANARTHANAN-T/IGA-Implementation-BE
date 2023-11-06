package com.baeldung.service;

import com.sparkpost.Client;
import com.sparkpost.model.responses.Response;
import com.sparkpost.transport.IRestConnection;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class SuccessNotificationService implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        try {
            String apiKey = "a8f9e384cbbf06df3fc22cff4ea2a7a3ee97e3f3";
            String sparkPostRegion = "SparkPost-US";
            String fromEmail = "no-reply@qlikverify.com";


            Client client = new Client(apiKey);
            if (sparkPostRegion != null && sparkPostRegion.equals("SparkPost-EU")) {
                client = new Client(apiKey, IRestConnection.SPC_EU_ENDPOINT);
            }

            Response response = client.sendMessage(fromEmail, (String) execution.getVariable("email"), "Onboarding Success", "You have been onboarded successfully into Grootan Technologies!", "You have been onboarded successfully into Grootan Technologies!");
            if (response.getResponseCode() == 200 || response.getResponseCode() == 201 || response.getResponseCode() == 202) {
                System.out.println("successfully sent email");
            } else {
                System.out.println("failed to send email");
            }
        } catch (Exception ex){
            System.out.println("Exception occured while mailing");
        }
        System.out.println("Successfully onboarded user");
    }
}