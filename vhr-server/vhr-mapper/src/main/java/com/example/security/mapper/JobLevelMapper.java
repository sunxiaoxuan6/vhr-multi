package com.example.security.mapper;

import com.example.security.model.JobLevel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    @Select("select * from joblevel")
    List<JobLevel> selectAllJobLevel();

    Integer deleteByIds(Integer[] ids);
}