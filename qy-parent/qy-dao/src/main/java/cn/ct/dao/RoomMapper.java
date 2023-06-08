package cn.ct.dao;

import cn.ct.model.dto.RoomDto;

import java.util.List;

/**
 * @author ct.team
 * @Description
 * Version 1.0
 */
public interface RoomMapper {
    /**
     * 根据就诊科室ID查询就诊房间列表
     * @param departmentId 就诊科室ID
     * @return
     */
    List<RoomDto> getRoomList(Long departmentId);
}
