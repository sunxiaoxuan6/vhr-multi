package com.example.security.service;

import com.example.security.mapper.PositionMapper;
import com.example.security.model.Position;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PositionService {
    @Resource
    PositionMapper positionMapper;

    public List<Position> getAllPosition() {
        return positionMapper.selectAllPosition();
    }

    public Integer addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insertSelective(position);
    }

    public Integer updatePosition(Position position) {
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePosition(Integer id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePosition(Integer[] ids) {
        return positionMapper.deleteByIds(ids);
    }

//    导入导出
    public PageInfo<Position> getPositionByPage(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Position> positions = positionMapper.selectAllPosition();
        return new PageInfo<>(positions, size);
    }

    public int addPositions(List<Position> positions) {
        return positionMapper.batchInsert(positions);
    }
}