package com.oskworks.modules.analysis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oskworks.modules.analysis.dto.DetectUnitRank;
import com.oskworks.modules.sampled.domain.SampledData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author osk-generator
 * @since 2020-08-27
 */
@Mapper
public interface AnalysisMapper extends BaseMapper<SampledData> {

    List<DetectUnitRank> detectUnitSampledSizeRank(@Param("deviceNos") List<String> deviceNos,
                                                   @Param("startTime") Date startTime,
                                                   @Param("endTime") Date endTime);

    List<DetectUnitRank> detectUnitAllowSampledSizeRank(@Param("deviceNos") List<String> deviceNos,
                                                        @Param("startTime") Date startTime,
                                                        @Param("endTime") Date endTime);

}
