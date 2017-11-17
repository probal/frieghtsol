package com.freightsol.freightsol.service.auth;

import com.freightsol.freightsol.entity.UserAccountEntity;
import com.freightsol.freightsol.exception.ResourceNotFoundException;
import com.freightsol.freightsol.model.auth.UserAccount;
import com.freightsol.freightsol.repository.auth.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by probal on 11/17/17.
 */
@Service
@Qualifier("authService")
public class AuthService {

    @Autowired
    UserAccountRepository authRepository;

    public UserAccount doLogin(UserAccount userAccount) {
        try {
            UserAccountEntity userAccountEntity = authRepository.findByEmailAndPassword(userAccount.getEmail(), userAccount.getPassword());
            if (userAccountEntity == null) {
                throw new ResourceNotFoundException(userAccount.getEmail(), "User not found");
            }
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(userAccountEntity, UserAccount.class);
        } catch(Exception ex) {
            throw new ResourceNotFoundException(userAccount.getEmail(), "User not found");
        }
    }

    public UserAccount createUser(UserAccount userAccount) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserAccountEntity userAccountEntity = modelMapper.map(userAccount, UserAccountEntity.class);
            userAccountEntity = authRepository.save(userAccountEntity);
            userAccount = modelMapper.map(userAccountEntity, UserAccount.class);
            return userAccount;
        } catch (Exception ex) {
            throw new ResourceNotFoundException(userAccount.getEmail(), "User not found");
        }
    }
}
