package com.freightsol.freightsol.repository.auth;

import com.freightsol.freightsol.entity.UserAccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by probal on 11/17/17.
 */
@Repository
public interface UserAccountRepository extends CrudRepository<UserAccountEntity, Long> {

    UserAccountEntity findByEmailAndPassword(String email, String password);

    Page<UserAccountEntity> findAll(Pageable pageReguest);

}
