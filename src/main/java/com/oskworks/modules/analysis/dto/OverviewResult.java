package com.oskworks.modules.analysis.dto;

import lombok.Data;

@Data
public class OverviewResult {

    /**
     * 今日采样量
     */
    int todaySampleSize;

    /**
     * 今日合格率
     */
    double todayPassRate;

    /**
     * 本月采样量
     */
    int monthSampleSize;

    /**
     * 本月合格率
     */
    double monthPassRate;

    private OverviewResult() {

    }

    public static OverviewResult of(int todaySampleSize, double todayPassRate, int monthSampleSize, double monthPassRate) {
        OverviewResult overviewResult = new OverviewResult();
        overviewResult.setTodaySampleSize(todaySampleSize);
        overviewResult.setTodayPassRate(todayPassRate);
        overviewResult.setMonthSampleSize(monthSampleSize);
        overviewResult.setMonthPassRate(monthPassRate);
        return overviewResult;
    }

}
