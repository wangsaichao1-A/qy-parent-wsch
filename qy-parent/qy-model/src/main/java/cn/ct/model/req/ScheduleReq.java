package cn.ct.model.req;
import java.io.Serializable;

/**
 * @author ct.team
 * @Description 医生排期入参包装类
*/
public class ScheduleReq implements Serializable {
    /** 主键ID */
    private Long id;
    /** 用户表主键ID */
    private Long userId;
    /** 就诊科室表主键ID */
    private Long departmentId;
    /** 就诊房间表主键ID */
    private Long roomId;
    /** 值班时间段 1-->上午，2-->下午 */
    private Integer sign;
    /** 诊断病人数量 */
    private Integer quantity;
    /** 剩余诊断病人数量 */
    private Integer remainingQuantity;
    /** 问诊时间 */
    private String inquiryTime;

    /** 医生姓名 */
    private String doctorName;
    /** 就诊房间名称 */
    private String roomName;
    /** 时间段 */
    private Integer[] signs;
    /** 页码 */
    private Integer pageNo;
    /** 页长 */
    private Integer pageSize;
    /** 数据库分页查询开始 */
    private Integer beginPos;

    public Integer[] getSigns() {
        return signs;
    }

    public void setSigns(Integer[] signs) {
        this.signs = signs;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /** get set 方法 */

    public void setId (Long  id){
        this.id=id;
    }
    public  Long getId(){
        return this.id;
    }
    public void setUserId (Long  userId){
        this.userId=userId;
    }
    public  Long getUserId(){
        return this.userId;
    }
    public void setDepartmentId (Long  departmentId){
        this.departmentId=departmentId;
    }
    public  Long getDepartmentId(){
        return this.departmentId;
    }
    public void setRoomId (Long  roomId){
        this.roomId=roomId;
    }
    public  Long getRoomId(){
        return this.roomId;
    }
    public void setSign (Integer  sign){
        this.sign=sign;
    }
    public  Integer getSign(){
        return this.sign;
    }
    public void setQuantity (Integer  quantity){
        this.quantity=quantity;
    }
    public  Integer getQuantity(){
        return this.quantity;
    }
    public void setRemainingQuantity (Integer  remainingQuantity){
        this.remainingQuantity=remainingQuantity;
    }
    public  Integer getRemainingQuantity(){
        return this.remainingQuantity;
    }

    public String getInquiryTime() {
        return inquiryTime;
    }

    public void setInquiryTime(String inquiryTime) {
        this.inquiryTime = inquiryTime;
    }
}
