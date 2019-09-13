package tomasz.kosacki.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tomasz.kosacki.entities.UserEntity;

@Repository
public interface UserDao extends MongoRepository<UserEntity, String> {

}
