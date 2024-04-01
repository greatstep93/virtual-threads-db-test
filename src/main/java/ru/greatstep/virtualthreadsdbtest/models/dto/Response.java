package ru.greatstep.virtualthreadsdbtest.models.dto;

import java.util.List;

public record Response(String clientName, List<String> orders) {

}
