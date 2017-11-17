package com.freightsol.freightsol.repository.auth;

import com.freightsol.freightsol.entity.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by probal on 11/17/17.
 */
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(String name);

}
