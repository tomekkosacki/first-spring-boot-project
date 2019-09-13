package tomasz.kosacki.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import tomasz.kosacki.dto.UserDto;
import tomasz.kosacki.entities.UserEntity;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class Mapper {

    @Autowired
    ModelMapper modelMapper;

    public Mapper() {
    }

    @Bean
    private ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public UserDto userEntityToUserDto(UserEntity from) {

        return modelMapper.map(from, UserDto.class);
    }

    public UserEntity userDtoToUserEntity(UserDto from) {

        return modelMapper.map(from, UserEntity.class);
    }

    public List<UserDto> userEntityListToUserDtoList(List<UserEntity> userEntityList) {

        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        return modelMapper.map(userEntityList, listType);
    }
}
