package com.oskworks.modules.analysis;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.google.common.collect.Maps;
import com.oskworks.framework.common.bean.JSONResult;
import com.oskworks.modules.analysis.dto.DetectUnitRank;
import com.oskworks.modules.analysis.mapper.AnalysisMapper;
import com.oskworks.modules.analysis.service.AnalysisService;
import com.oskworks.modules.device.domain.Device;
import com.oskworks.modules.device.service.IDeviceService;
import com.oskworks.modules.sampled.domain.SampledData;
import com.oskworks.modules.sampled.service.ISampledDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 检测单位
 * </p>
 *
 * @author fullee
 * @since 2021-01-20
 */
@RestController
@RequestMapping("/analysis")
@AllArgsConstructor
public class AnalysisEndpoint {

    private final AnalysisService analysisService;

    private final IDeviceService deviceService;

    private final ISampledDataService sampledDataService;

    private final AnalysisMapper analysisMapper;

    /**
     * 总览
     */
    @GetMapping("/overview")
    public JSONResult<?> overview() {

        List<Device> devices = deviceService.getDeviceListByCurrentUser();
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }

        return JSONResult.success(analysisService.overviewResult(devices.stream().map(Device::getDeviceNo).collect(Collectors.toList())));
    }

    /**
     * 首页30天采样量柱图
     */
    @GetMapping("/sampled")
    public JSONResult<?> daysPerSampledSize() {
        List<Device> devices = deviceService.getDeviceListByCurrentUser();
        List<String> deviceNos = devices.stream().map(Device::getDeviceNo).collect(Collectors.toList());
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }

        DateTime startTime = DateUtil.offsetDay(DateUtil.date(), -30);
        DateTime endTime = DateUtil.date();
        List<DateTime> dateTimes = DateUtil.rangeToList(startTime, endTime, DateField.DAY_OF_MONTH);
        Map<String, Integer> sampledSize = Maps.newHashMap();
        for (DateTime dateTime : dateTimes) {
            int sampleSize = sampledDataService.lambdaQuery()
                    .in(SampledData::getDeviceNo, deviceNos)
                    .between(SampledData::getCreatedTime, DateUtil.beginOfDay(dateTime), DateUtil.endOfDay(dateTime)).count();

            sampledSize.put(DateUtil.format(dateTime, "MM-dd"), sampleSize);
        }

        return JSONResult.success(sampledSize);
    }

    /**
     * 首页30天合格率柱图
     */
    @GetMapping("/pass-rate")
    public JSONResult<?> daysPerPassRate() {
        List<Device> devices = deviceService.getDeviceListByCurrentUser();
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }

        List<String> deviceNos = devices.stream().map(Device::getDeviceNo).collect(Collectors.toList());

        DateTime startTime = DateUtil.offsetDay(DateUtil.date(), -30);
        DateTime endTime = DateUtil.date();
        List<DateTime> dateTimes = DateUtil.rangeToList(startTime, endTime, DateField.DAY_OF_MONTH);
        Map<String, Double> sampledSize = Maps.newHashMap();
        for (DateTime dateTime : dateTimes) {
            int sampleSize = sampledDataService.lambdaQuery()
                    .in(SampledData::getDeviceNo, deviceNos)
                    .between(SampledData::getCreatedTime, DateUtil.beginOfDay(dateTime), DateUtil.endOfDay(dateTime)).count();

            int allowSampleSize = sampledDataService.lambdaQuery()
                    .in(SampledData::getDeviceNo, deviceNos)
                    .eq(SampledData::getDetectResult, SampledData.DetectResult.ALLOW)
                    .between(SampledData::getCreatedTime, DateUtil.beginOfDay(dateTime), DateUtil.endOfDay(dateTime)).count();
            if (sampleSize != 0) {
                sampledSize.put(DateUtil.format(dateTime, "MM-dd"), NumberUtil.div(allowSampleSize, sampleSize, 4, RoundingMode.HALF_UP));
            } else {
                sampledSize.put(DateUtil.format(dateTime, "MM-dd"), 0D);
            }
        }

        return JSONResult.success(sampledSize);
    }

    /**
     * 首页检测站采样量排行
     */
    @GetMapping("/size-rank")
    public JSONResult<?> detectUnitSampledSizeRank() {
        List<Device> devices = deviceService.getDeviceListByCurrentUser();
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }

        List<String> deviceNos = devices.stream().map(Device::getDeviceNo).collect(Collectors.toList());

        DateTime startTime = DateUtil.offsetDay(DateUtil.date(), -30);
        DateTime endTime = DateUtil.date();

        List<DetectUnitRank> ranks = analysisMapper.detectUnitSampledSizeRank(deviceNos, startTime, endTime);

        return JSONResult.success(ranks);
    }

    /**
     * 首页检测站合格率排行
     */
    @GetMapping("/rate-rank")
    public JSONResult<?> detectUnitPassRateRank() {
        List<Device> devices = deviceService.getDeviceListByCurrentUser();
        if (devices.isEmpty()) {
            return JSONResult.fail("暂无数据");
        }

        List<String> deviceNos = devices.stream().map(Device::getDeviceNo).collect(Collectors.toList());

        DateTime startTime = DateUtil.offsetDay(DateUtil.date(), -30);
        DateTime endTime = DateUtil.date();

        List<DetectUnitRank> ranks = analysisMapper.detectUnitSampledSizeRank(deviceNos, startTime, endTime);

        List<DetectUnitRank> detectUnitRanks = analysisMapper.detectUnitAllowSampledSizeRank(deviceNos, startTime, endTime);

        for (DetectUnitRank rank : ranks) {
            DetectUnitRank detectUnitRank = detectUnitRanks.stream().filter((item) -> item.getId().equals(rank.getId())).findAny().orElse(null);
            if (Objects.nonNull(detectUnitRank) && rank.getCount() != 0) {
                rank.setCount(NumberUtil.div(detectUnitRank.getCount(), rank.getCount(), 4, RoundingMode.HALF_UP));
            } else {
                rank.setCount(0);
            }
        }
        return JSONResult.success(ranks);
    }
}
