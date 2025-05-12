package com.Ebrahem.Taskes.Domain.Dto;

public record ErrorResponse(
        int statues,
        String message,
        String details
) {
}
