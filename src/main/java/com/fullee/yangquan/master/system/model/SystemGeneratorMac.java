package com.fullee.yangquan.master.system.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "system_generator_mac")
public class SystemGeneratorMac implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "pk_id")
    private Integer pkId;

    @Column(name = "create_time")
    private LocalDateTime createdTime;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "formatter")
    private String formatter;

    @Column(name = "init_val")
    private String initVal;

    @Column(name = "curr_val")
    private String currVal;

    @Column(name = "step")
    private Integer step;

}
