package com.example.funskatebackend.funskate.api;

import com.example.funskatebackend.funskate.dto.skategroup.SkateGroupResponse;
import com.example.funskatebackend.funskate.service.GroupService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SkateGroupResponse> getGroups() {
        return groupService.getGroups();
    }

}
