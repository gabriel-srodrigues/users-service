package br.com.dh.usersservice.users.api.assembler;

import br.com.dh.usersservice.users.api.dto.UserResponse;
import br.com.dh.usersservice.users.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);
}
