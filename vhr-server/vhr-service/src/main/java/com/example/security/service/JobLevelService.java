package com.example.security.service;

import com.example.security.mapper.JobLevelMapper;
import com.example.security.model.JobLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {
    @Resource
    JobLevelMapper jobLevelMapper;

    public List<JobLevel> getAllJobLevel() {
        return jobLevelMapper.selectAllJobLevel();
    }

    public Integer addJobLevel(JobLevel jobLevel) {
        jobLevel.setEnabled(true);
        jobLevel.setCreateDate(new Date());
        return jobLevelMapper.insertSelective(jobLevel);
    }

    public Integer updateJobLevel(JobLevel jObLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jObLevel);
    }

    public Integer deleteJobLevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }
    public Integer deleteJobLevel(Integer[] ids) {
        return jobLevelMapper.deleteByIds(ids);
    }
}