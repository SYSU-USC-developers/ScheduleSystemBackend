package ecnc.schedulesystembackend.dao;

import ecnc.schedulesystembackend.bean.EmployeeST;
import org.apache.ibatis.annotations.*;

/**
 * 给普通网管开放的接口应该包含以下几个：
 *      1. 根据自己的 netid 查询自己已经提交的班表
 *      2. 若未提交班表，则可以提交班表
 *      3. 若已经提交了班表，则可以修改自己的班表
 * 故应该包含的数据库接口应该包含以下几个：
 *      1. 根据 netid 查询
 *      2. addST
 *      3. updateST
 */

@Mapper
public interface EmployeeSTDao {
    // 根据 netid 查询班表
    @Select("select * from employeest where netid = #{netid}")
    EmployeeST getSTByNetid(@Param("netid") String netid);

    // 提交班表
    @Insert("insert into employeest(netid, free_time, intention, acceptAdjust) values (#{netid}, #{free_time}, #{intention}, #{acceptAdjust})")
    int insertST(@Param("netid") String netid,
                     @Param("free_time") String free_time,
                     @Param("intention") Boolean intention,
                     @Param("acceptAdjust") Boolean acceptAdjust);


    // 修改班表
    @Update("update employeest set free_time = #{free_time}, intention = #{intention}, acceptAdjust = #{acceptAdjust} where netid = #{netid}")
    int updateST(@Param("netid") String netid,
                     @Param("free_time") String free_time,
                     @Param("intention") Boolean intention,
                     @Param("acceptAdjust") Boolean acceptAdjust);
}
