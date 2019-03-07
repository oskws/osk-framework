package com.fullee.yangquan.master.system.model;

import com.fullee.yangquan.master.framework.common.bean.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "system_dict")
@NoArgsConstructor
public class SystemDict extends BaseModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id",unique = true,nullable = false)
    private Integer pkId;

    @Column(name = "uk_mac",unique = true,nullable = false,length = 32)
    private String ukMac;

    @Column(name = "created_by",length = 64)
    private String createdBy;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_by", length = 64)
    private String updatedBy;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    @Column(name = "table_field")
    private String tableField;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Integer code;

    @Column(name = "remark")
    private String remark;

}
