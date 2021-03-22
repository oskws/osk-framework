package com.oskworks.modules.region.dto;


import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.oskworks.modules.detectunit.domain.DetectUnit;
import com.oskworks.modules.region.domain.Region;
import lombok.Data;
import org.osgl.util.S;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class RegionNodeResult {

    private String id;

    private String name;

    private String parentId;

    /* 区域层级：1省，2市，3区，4检测站 */
    private int level;

    public static class Level {
        public static final int PROVINCE = 1;
        public static final int CITY = 2;
        public static final int COUNTY =3;
        public static final int DETECT_UNIT =4;
    }

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private LocalDateTime updatedAt;

    public RegionNodeResult(Region region) {
        if (Objects.nonNull(region)) {
            this.id = region.getId();
            this.name = region.getName();
            this.parentId = region.getParentId();
            if (S.len(this.id) == 2) this.level = Level.PROVINCE;
            if (S.len(this.id) == 4) this.level = Level.CITY;
            if (S.len(this.id) == 6) this.level = Level.COUNTY;

            this.createdAt = region.getCreatedAt();
            this.updatedAt = region.getUpdatedAt();
        }
    }

    public RegionNodeResult(DetectUnit detectUnit) {
        if (Objects.nonNull(detectUnit)) {
            this.id = Long.toString(detectUnit.getId());
            this.name = detectUnit.getUnitName();
            this.parentId = detectUnit.getRegionId();
            this.level = Level.DETECT_UNIT;
            this.createdAt = detectUnit.getCreatedTime();
        }
    }



}

