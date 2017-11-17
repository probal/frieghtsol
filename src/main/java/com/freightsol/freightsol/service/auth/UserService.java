package com.freightsol.freightsol.service.auth;

import com.freightsol.freightsol.entity.UserAccountEntity;
import com.freightsol.freightsol.entity.UserRoleEntity;
import com.freightsol.freightsol.exception.DataBaseException;
import com.freightsol.freightsol.exception.ResourceNotFoundException;
import com.freightsol.freightsol.model.auth.UserAccount;
import com.freightsol.freightsol.model.auth.UserRole;
import com.freightsol.freightsol.repository.auth.UserAccountRepository;
import com.freightsol.freightsol.repository.auth.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by probal on 11/17/17.
 */
@Service
@Qualifier("userService")
public class UserService {

    @Autowired
    UserAccountRepository userRepository;

    @Autowired
    UserRoleRepository roleRepository;



    public UserAccount getUser(Long userId) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserAccountEntity userAccountEntity = userRepository.findOne(userId);

            if (userAccountEntity == null) {
                throw new ResourceNotFoundException("userId: "+userId, "user not found");
            }

            UserAccount userAccount = modelMapper.map(userAccountEntity, UserAccount.class);
            return userAccount;
        } catch (Exception ex) {
            throw new ResourceNotFoundException("userId: "+userId, "user not found");
        }
    }

    public Page<UserAccount> getAllUser(Pageable page) {
        try {
            Page<UserAccountEntity> userAccountEntityPage = userRepository.findAll(page);
            return userAccountEntityPage.map(this::convertToModel);
        } catch (Exception ex) {
            throw new ResourceNotFoundException("UserList", "User list not found");
        }
    }



    public UserRole createRole(UserRole userRole) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserRoleEntity userRoleEntity = roleRepository.save(modelMapper.map(userRole, UserRoleEntity.class));
            return modelMapper.map(userRoleEntity, UserRole.class);
        } catch(Exception ex) {
            throw new DataBaseException("Role", "DB failed to create role");
        }
    }

    public List<UserRole> getAllRoles() {
        try {
            List<UserRole> roles= StreamSupport.stream(roleRepository.findAll().spliterator(), false).map(UserRole::new).collect(Collectors.toList());
            return roles;
        } catch (Exception ex) {
            throw new ResourceNotFoundException("RoleList", "Role list not found");
        }
    }

    public UserAccount assignRoles(Long userId, String roleNames) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserAccountEntity userAccountEntity = userRepository.findOne(userId);
            userAccountEntity.setModules(roleNames);
            userRepository.save(userAccountEntity);
            return modelMapper.map(userAccountEntity, UserAccount.class);
        } catch(Exception ex) {
            throw new DataBaseException("Role", "DB failed to create role");
        }
    }

    private UserAccount convertToModel(final UserAccountEntity userAccountEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userAccountEntity, UserAccount.class);
    }

    private Object convertToDTO(final Object entityObject) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entityObject, Object.class);
    }

}
