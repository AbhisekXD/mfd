package com.cyfrifpro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.User;
import com.cyfrifpro.model.enums.RoleEnum;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByRoleRoleName(RoleEnum roleEnum);
    
    Optional<User> findByEmail(String username);

    List<User> findByRoleRoleId(Long roleId);

    List<User> findByRoleIn(List<Role> roles);

    List<User> findByCreatedBy_UserId(Long creatorUserId);

    List<User> findByCreatedBy_UserIdAndRoleIsNull(Long creatorUserId);

    List<User> findByCreatedBy_UserIdAndRoleIsNotNull(Long creatorUserId);

    @Query("SELECT u FROM User u JOIN FETCH u.subordinates WHERE u.createdBy = :creator")
    List<User> findSubordinatesWithCreator(@Param("creator") User creator);

    // Recursive query to fetch all users under a specific user
    @Query(value = """
        WITH RECURSIVE UserHierarchy AS (
            SELECT u.* 
            FROM users u 
            WHERE u.created_by_user_id = :loggedInUserId 
            UNION ALL 
            SELECT u.* 
            FROM users u 
            JOIN UserHierarchy uh ON u.created_by_user_id = uh.user_id
        ) 
        SELECT * FROM UserHierarchy
        """, nativeQuery = true)
    List<User> findAllUsersUnder(@Param("loggedInUserId") Long loggedInUserId);

	List<User> findAllByCreatedBy(User user);
	
}
