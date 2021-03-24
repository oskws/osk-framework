package com.oskworks.modules.system.dto;

import com.oskworks.modules.region.dto.RegionType;
import com.oskworks.modules.system.domain.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class RegionUserDTO {

    public RegionUserDTO(User user) {
        if (Objects.nonNull(user)) {
            this.id = user.getId();
            this.loginName = user.getLoginName();
            this.nickname = user.getNickname();
            this.details = user.getDetails();
            this.createdTime = user.getCreatedTime();
            this.updatedTime = user.getUpdatedTime();
            this.regionPath = user.getRegionPath();
            this.regionType = user.getRegionPath().split("-").length == 4 ? RegionType.DETECT_UNIT : RegionType.REGION;
        }
    }

    private Long id;

    private String loginName;

    private String nickname;

    private String passwordSlat;

    private String userPassword;

    private User.Details details;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private String regionPath;

    private int regionType;

}
