package com.baeldung.helper;

import com.baeldung.domain.Subtask;
import org.flowable.variable.api.history.HistoricVariableInstance;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.baeldung.Constants.userOnboarding;

public class Helper {
    public static List<String> getMissingSubtasks(List<Subtask> subtasks) {
        List<String> createdSubtasks = subtasks.stream()
                .map(Subtask::getName).collect(Collectors.toList());
        return userOnboarding.stream().filter(subtask -> !createdSubtasks.contains(subtask)).collect(Collectors.toList());
    }

    public static boolean isSpecificToUser(String processId, List<HistoricVariableInstance> variableInstances, String userId) {
        return (int) variableInstances.stream()
                .filter(historicVariableInstance -> historicVariableInstance.getProcessInstanceId().equals(processId))
                .filter(historicVariableInstance -> historicVariableInstance.getVariableName().equals("userId") && Optional.ofNullable(historicVariableInstance.getValue()).orElse("").equals(userId))
                .count() > 0;
    }
}
