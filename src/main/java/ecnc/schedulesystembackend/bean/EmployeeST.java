package ecnc.schedulesystembackend.bean;

import lombok.Data;

import java.util.List;

/**
 * EmployeeST 即为 Employee Schedule Table，表示网管提交的班表数据，该 bean 包含了两个数据对象：
 *      1. String netid 网管标识
 *      2. String free_time 用来存储空闲时间，是一个 json 格式的数据
 *      3. Boolean intention 表示意向岗位，0 表示前台，1 表示后台
 *      4. Boolean acceptAdjust 表示是否愿意被调剂，0 表示不愿意，1 表示原意
 */

@Data
public class EmployeeST {
    private String netid;
    private String free_time;
    private Boolean intention;
    private Boolean accept_adjust;
}
