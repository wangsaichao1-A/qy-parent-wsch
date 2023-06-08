package cn.ct.common.enums;

/**
 * @author ct.team
 * @Description 医生排期相关枚举类
 * Version 1.0
 */
public enum ScheduleEnum {
    SCHEDULE_DELETE_NO(0,"未删除"),
    SCHEDULE_DELETE_YES(1,"已删除");

    private Integer code;
    private String msg;
    private ScheduleEnum(Integer code , String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
