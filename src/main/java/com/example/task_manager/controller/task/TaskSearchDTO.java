package com.example.task_manager.controller.task;

import java.util.List;
import java.util.Optional;

public record TaskSearchDTO(
        String title,
        List<String> statusList,
        String sort
) {
    public boolean isChecked(String status) {
        return Optional.ofNullable(statusList)
                .map(l -> l.contains(status))
                .orElse(false);
    }
}
