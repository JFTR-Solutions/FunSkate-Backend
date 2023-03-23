package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.group.GroupResponse;
import com.example.funskatebackend.funskate.entity.SkateGroup;
import com.example.funskatebackend.funskate.service.GroupService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("groups")
public class GroupController {

    GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupResponse> getGroups() {
        return groupService.getGroups();
    }

}
