package com.baeldung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    private Constants() {}

    public static final List<String> userOnboarding = new ArrayList<>(Arrays.asList("Provide acces to gitlab",
            "Initiate access request to Azure Admin", "Admin approval after successful access grant in Azure",
            "Send notification to user after successful onboarding"));
}
