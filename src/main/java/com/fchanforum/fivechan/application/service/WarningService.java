package com.fchanblog.fivechan.application.service;

import java.util.ArrayList;
import java.util.List;

public class WarningService {
    private List<String> warnings = new ArrayList<>();

    public List<String> getWarnings() {
        return warnings;
    }

    public void addWarning() {
        this.warnings.add("Warning issued at " + System.currentTimeMillis());
    }
}
