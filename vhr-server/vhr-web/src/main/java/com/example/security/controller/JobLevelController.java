package com.example.security.controller;

import com.example.security.model.JobLevel;
import com.example.security.model.RespBean;
import com.example.security.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/system/basic/job")
public class JobLevelController {
    @Autowired
    JobLevelService jObLevelService;

    @GetMapping("/findAll")
    public RespBean getAllPosition() {
        List<JobLevel> positions = jObLevelService.getAllJobLevel();
        return RespBean.ok("获取成功", positions);
    }

    @PostMapping("/add")
    public RespBean addPosition(@RequestBody JobLevel jObLevel) {
        if(jObLevelService.addJobLevel(jObLevel) == 1 ) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/update")
    public RespBean updatePosition(@RequestBody JobLevel jObLevel) {
        if(jObLevelService.updateJobLevel(jObLevel) == 1 ) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deletePosition(@PathVariable Integer id) {
        if(jObLevelService.deleteJobLevel(id) == 1 ) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/bulk/delete")
    public RespBean deletePosition(Integer[] ids) {
        if(jObLevelService.deleteJobLevel(ids) == ids.length) {
            return RespBean.ok("批量删除成功");
        }
        return RespBean.error("批量删除失败");
    }
}