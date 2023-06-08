package cn.ct.service;

import cn.ct.common.result.Result;
import cn.ct.model.dto.Page;
import cn.ct.model.dto.ScheduleDto;
import cn.ct.model.req.ScheduleReq;

import java.util.List;

/**
 * @author ct.team
 * @Description Version 1.0
 */
public interface ScheduleService {
    /**
     * 新增医生排期
     * @param schedule
     * @return
     * @throws Exception
     */
    Result addSchedule(ScheduleReq schedule) throws Exception;

    /**
     * 根据主键ID删除医生出诊信息
     * @param id
     * @return
     * @throws Exception
     */
    Result deleteScheduleById(Long id) throws Exception;

    /**
     * 查询医生出诊信息列表
     * @param schedule
     * @return
     * @throws Exception
     */
    Page<ScheduleDto> getScheduleList(ScheduleReq schedule) throws Exception;

    /**
     * 根据就诊科室ID和值班时间段查询就诊医生列表
     *
     * @param departmentId
     * @param sign
     * @return
     * @throws Exception
     */
    Result<List<ScheduleDto>> getDoctorList(Long departmentId, Integer sign) throws Exception;

}
