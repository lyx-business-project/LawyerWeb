package com.hyg.controller;

import com.hyg.pojo.Lawyer;
import com.hyg.service.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 律师表控制器
 */
@Controller
public class LawyerController {
    @Qualifier("lawyerService")
    @Autowired
    private LawyerService lawyerService;
    @Value("${cbs.projectPath}")
    public String projectPath;
    @ResponseBody
    @RequestMapping("/lawyerList")
    public List<Lawyer> findAllLawyer()
    {
        List<Lawyer> list=lawyerService.findAllLawyer();
        for (Lawyer la:list){
            la.setLawyerImg(projectPath.concat(la.getLawyerImg()));
        }
        return list;
    }

}
