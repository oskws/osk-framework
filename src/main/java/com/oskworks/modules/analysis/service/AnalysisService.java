package com.oskworks.modules.analysis.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.oskworks.modules.analysis.dto.OverviewResult;
import com.oskworks.modules.sampled.domain.SampledData;
import com.oskworks.modules.sampled.service.ISampledDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class AnalysisService {

    private final ISampledDataService sampledDataService;

    public OverviewResult overviewResult(List<String> deviceNos) {
        int monthAllSampleSize = sampledDataService.lambdaQuery()
                .in(SampledData::getDeviceNo, deviceNos)
                .between(SampledData::getCreatedTime, DateUtil.beginOfMonth(DateUtil.date()), DateUtil.endOfDay(DateUtil.date())).count();

        int monthAllowSampleSize = sampledDataService.lambdaQuery()
                .in(SampledData::getDeviceNo, deviceNos)
                .eq(SampledData::getDetectResult, SampledData.DetectResult.ALLOW)
                .between(SampledData::getCreatedTime, DateUtil.beginOfMonth(DateUtil.date()), DateUtil.endOfDay(DateUtil.date())).count();

        int daySampleSize = sampledDataService.lambdaQuery()
                .in(SampledData::getDeviceNo, deviceNos)
                .between(SampledData::getCreatedTime, DateUtil.beginOfDay(DateUtil.date()), DateUtil.endOfDay(DateUtil.date())).count();

        int dayAllowSampleSize = sampledDataService.lambdaQuery()
                .in(SampledData::getDeviceNo, deviceNos)
                .eq(SampledData::getDetectResult, SampledData.DetectResult.ALLOW)
                .between(SampledData::getCreatedTime, DateUtil.beginOfDay(DateUtil.date()), DateUtil.endOfDay(DateUtil.date())).count();

        double dayPassRate = 0;
        if (daySampleSize != 0) {
            dayPassRate = NumberUtil.div(dayAllowSampleSize, daySampleSize, 4, RoundingMode.HALF_UP);

        }

        double monthPassRate = 0;
        if (monthAllSampleSize != 0) {
            monthPassRate = NumberUtil.div(monthAllowSampleSize, monthAllSampleSize, 4, RoundingMode.HALF_UP);

        }

        return OverviewResult.of(daySampleSize, dayPassRate, monthAllSampleSize, monthPassRate);

    }

}
