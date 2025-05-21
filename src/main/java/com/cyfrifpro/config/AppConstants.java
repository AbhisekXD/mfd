																																																																																																																																																																																																																																																																																																																																																																																																																										package com.cyfrifpro.config;

import java.util.Collections;
import java.util.Map;

import com.cyfrifpro.model.enums.RoleEnum;

public class AppConstants {

	public static final String SORT_USERS_BY = "userId";
	public static final String SORT_DIR = "asc";

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	public static final String[] PUBLIC_URLS = { "/**","/api/users/filter/**", "/v3/api-docs/**", "/swagger-ui/**",
			"/api/register/**", "/actuator/**", "/api/**", "/api/admin/users", "/api/admin/roles/**", "api/roles/**",
			"/csv/upload/**" };

	public static final Map<RoleEnum, String[]> ROLE_URLS = Collections.unmodifiableMap(Map.of(RoleEnum.MASTER_ADMIN,
			new String[] {}, RoleEnum.CONTROL_PANEL, new String[] {}, RoleEnum.DISTRIBUTOR, new String[] {},
			RoleEnum.RELATIONSHIP_MANAGER, new String[] {}, RoleEnum.CLIENT, new String[] {}));
}
