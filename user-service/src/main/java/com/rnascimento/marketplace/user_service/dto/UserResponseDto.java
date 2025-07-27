package com.rnascimento.marketplace.user_service.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private boolean active;
    private String role;
    private String createdAt;
    private String updatedAt;

}
