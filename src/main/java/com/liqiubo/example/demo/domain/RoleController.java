package com.liqiubo.example.demo.domain;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/role", produces = {"application/json;charset=UTF-8"})
    public ModelAndView getAllRole(Model model) {
        List<TSRole> list = roleService.getAllRoles();
        for (TSRole role : list) {
            System.out.println(role);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
//        return jsonArray.toString();
        model.addAttribute("roles", list);
        return new ModelAndView("index").addObject("roles", list);
    }

}
