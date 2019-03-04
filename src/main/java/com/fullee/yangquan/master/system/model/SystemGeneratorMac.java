package com.fullee.yangquan.master.system.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "system_generator_mac")
public class SystemGeneratorMac {

    @Id
    @GeneratedValue
    @Column(name = "pk_id",unique = true,nullable = false)
    private Integer pkId;

    @Column(name = "prefix")
    private String prefix;

    /**
     * {yyyy}
     */
    @Column(name = "formatter")
    private String formatter;

    @Column(name = "init_val")
    private String initVal;

    @Column(name = "curr_val")
    private String currVal;

    @Column(name = "step")
    private Integer step;

}
