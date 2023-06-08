package cn.ct.dao;

import cn.ct.model.dto.ScheduleDto;
import cn.ct.model.pojo.Schedule;
import cn.ct.model.req.ScheduleReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ct.team
 * @Description 医生排期
 */
public interface ScheduleMapper {
	/**
	 * 同一个诊室同一时间段只能有一个出诊信息
	 * @param schedule
	 * @return
	 */
	Schedule checkScheduleRoomAndTime(ScheduleReq schedule);

	/**
	 * 同一个医师同一时间段只能有一个出诊信息
	 * @param schedule
	 * @return
	 */
	Schedule checkScheduleDoctorAndTime(ScheduleReq schedule);

	/**
	 * 新增医生排期
	 * @param schedule
	 * @return
	 */
	Integer addSchedule(ScheduleReq schedule);

	/**
	 * 查询医生就诊信息列表
	 * @param schedule
	 * @return
	 */
	List<ScheduleDto> getScheduleList(ScheduleReq schedule);
	/**
	 * 查询医生就诊信息列表数量
	 * @param schedule
	 * @return
	 */
	Integer getScheduleListCount(ScheduleReq schedule);
	/**
	 * 根据就诊科室ID和值班时间段查询就诊医生列表
	 * @param param
	 * @return
	 */
	List<ScheduleDto> getSchedule(Map<String, Object> param);
	/**
	 * 根据主键ID更新医生排期信息
	 * @param schedule
	 * @return
	 */
	Integer updateSchedule(Schedule schedule);
	/**
	 * 根据主键ID查询医生排期信息
	 * @param id
	 * @return
	 */
	Schedule getScheduleById(@Param(value = "id") Long id);
}
