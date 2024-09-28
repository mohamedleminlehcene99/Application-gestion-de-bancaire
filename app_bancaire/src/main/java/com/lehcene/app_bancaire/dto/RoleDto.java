package com.lehcene.app_bancaire.dto;

import com.lehcene.app_bancaire.models.Role;
import com.lehcene.app_bancaire.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
    private Integer id;
    private String name;
    private List<UserDto> users;

    public static RoleDto fromEntity(Role role){
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .users(role.getUsers().stream().map(UserDto::fromEntity).collect(Collectors.toList()))
                .build();
    }

    public static Role toEntity(RoleDto roleDto){
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .users(roleDto.getUsers().stream().map(UserDto::toEntity).collect(Collectors.toList()))
                .build();
    }
}
