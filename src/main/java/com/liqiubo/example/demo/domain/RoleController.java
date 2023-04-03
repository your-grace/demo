package com.liqiubo.example.demo.domain;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping(value = "/role", produces = {"application/json;charset=UTF-8"})
    public String getAllRole(){
        List<TSRole> list = roleService.getAllRoles();
        for (TSRole role : list) {
            System.out.println(role);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray.toString());
        return jsonArray.toString();
    }
}
