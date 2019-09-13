package tomasz.kosacki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tomasz.kosacki.dao.UserDao;
import tomasz.kosacki.dto.UserDto;
import tomasz.kosacki.entities.UserEntity;
import tomasz.kosacki.mapper.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserDao userDao;
    private Mapper mapper;

    @Autowired
    public UserService(UserDao userDao, Mapper mapper) {
        this.userDao = userDao;
        this.mapper = mapper;
    }

    public List<UserDto> getAllUsers() {

        List<UserEntity> userEntityList = userDao.findAll();
        return mapper.userEntityListToUserDtoList(userEntityList);
    }

    public UserDto getUserById(String userId) {

        UserEntity userEntity = userDao.findById(userId).get();
        return mapper.userEntityToUserDto(userEntity);
    }

    public void addUser(UserDto userDto) {

        UserEntity userEntity = mapper.userDtoToUserEntity(userDto);
        userEntity.setCreationDate(LocalDateTime.now());
        userEntity.setId(UUID.randomUUID().toString());
        userDao.save(userEntity);
    }

    public void deleteUser(String userId) {

        userDao.deleteById(userId);
    }
}
