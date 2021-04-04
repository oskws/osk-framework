package com.oskworks.modules.analysis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DetectUnitRank implements Serializable {

    private Long id;

    private String detectUnitName;

    private double count;

}
