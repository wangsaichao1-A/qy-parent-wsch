package cn.ct.model.dto;

import java.io.Serializable;

/**
 * @author hys
 * @Description 就诊房间
 */
public class RoomDto implements Serializable {
    /** 主键ID */
    private Long id;
    /** 就诊科室ID */
    private Long departmentId;
    /** 房间名称 */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
