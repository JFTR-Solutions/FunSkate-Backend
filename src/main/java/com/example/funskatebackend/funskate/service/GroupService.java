package com.example.funskatebackend.funskate.service;

import com.example.funskatebackend.funskate.dto.skategroup.SkateGroupResponse;
import com.example.funskatebackend.funskate.entity.SkateGroup;
import com.example.funskatebackend.funskate.repository.SkateGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    SkateGroupRepository groupRepository;

    public GroupService(SkateGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<SkateGroupResponse> getGroups(){
        List<SkateGroup> skateGroups = groupRepository.findAll();

        return skateGroups.stream().map(SkateGroupResponse::new).toList();

    }
}
