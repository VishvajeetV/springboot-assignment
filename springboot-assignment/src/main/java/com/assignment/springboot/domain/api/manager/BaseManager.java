package com.assignment.springboot.domain.api.manager;


import com.assignment.springboot.domain.api.resource.ResponseDTO;

public interface BaseManager<Resource, ID>{
    
    ResponseDTO<Resource> findById(ID id);
    
    ResponseDTO findAll();
    
    ResponseDTO<Resource> create(Resource resource);

    ResponseDTO<Resource> update(Resource resource);
    
}
