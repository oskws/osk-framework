package com.oskworks.modules.system.dto;

import lombok.Data;

@Data
public class UserListQuery {

    private String nickname;

    /* 地区ID */
    private String regionPath;

    /* 1全部 2本级 */
    private Integer type = 1;

    public static class Type {
        public static final int ALL = 1;
        public static final int CURRENT = 2;
    }

    private Integer page;

    private Integer size;

}
