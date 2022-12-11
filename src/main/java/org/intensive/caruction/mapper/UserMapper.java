package org.intensive.caruction.mapper;

import org.intensive.caruction.dto.UserDTO;
import org.intensive.caruction.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToDto(User user);

}
