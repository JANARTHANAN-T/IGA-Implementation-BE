package com.baeldung.helper;

import com.baeldung.domain.Subtask;
import org.flowable.engine.runtime.ActivityInstance;

import java.util.List;
import java.util.stream.Collectors;

import static com.baeldung.Constants.userOnboarding;

public class Helper {
    public static List<String> getMissingSubtasks(List<Subtask> subtasks) {
        List<String> createdSubtasks = subtasks.stream()
                .map(Subtask::getName).collect(Collectors.toList());
        return userOnboarding.stream().filter(subtask -> !createdSubtasks.contains(subtask)).collect(Collectors.toList());
    }
}
