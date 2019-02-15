package com.ljy.sbtemplate.web.temp;

import com.github.pagehelper.PageInfo;
import com.ljy.sbtemplate.model.po.sbt.mbg.Temp;
import com.ljy.sbtemplate.model.request.temp.TempParam;
import com.ljy.sbtemplate.service.temp.TempService;
import com.ljy.sbtemplate.util.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lokiy
 * @date 2019/2/15
 * @description
 */
@RestController
@RequestMapping("/api/temp")
public class TempController {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private TempService tempService;

    @ApiOperation("根据id获取对象")
    @GetMapping("/{id}")
    public JsonResult get(@PathVariable("id") Integer id){
        Temp temp = tempService.get(id);
        return JsonResult.getResult(temp);
    }


    @ApiOperation("分页查询列表")
    @PostMapping("/list")
    public JsonResult list(@RequestBody TempParam tempParam){
        PageInfo<Temp> list = tempService.list(tempParam);
        return JsonResult.getResult(list);
    }

    @ApiOperation("新增")
    @PostMapping
    public JsonResult save(@RequestBody TempParam tempParam){
        int save = tempService.save(tempParam);
        return JsonResult.getResult(save);
    }


    @ApiOperation("更新")
    @PutMapping
    public JsonResult update(@RequestBody TempParam tempParam){
        int update = tempService.update(tempParam);
        return JsonResult.getResult(update);
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable("id") Integer id){
        int delete = tempService.delete(id);
        return JsonResult.getResult(delete);
    }
}
