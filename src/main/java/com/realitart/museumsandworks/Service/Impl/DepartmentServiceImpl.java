package com.realitart.museumsandworks.Service.Impl;

import com.realitart.museumsandworks.Domain.Department;
import com.realitart.museumsandworks.Domain.Repositories.IDepartmentRepository;
import com.realitart.museumsandworks.Service.IDepartmentService;
import com.realitart.museumsandworks.share.exceptions.ResourceNotFoundException;
import com.realitart.museumsandworks.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    private static final String ENTITY = "Department";
    @Autowired
    IDepartmentRepository _departmentRepo;

    @Override
    public OperationResponse createDepartment(Department request) {
        try{
            _departmentRepo.save(request);
            return new OperationResponse(true, "Department creado correctamente");
        } catch (Exception e) {
            return new OperationResponse(false, "Error al crear el Department");
        }
    }

    @Override
    public OperationResponse updateDepartment(Long departmentId, Department request) {
        return _departmentRepo.findById(departmentId).map(
                artwork -> {
                    if(request.getName() != null) artwork.setName(request.getName());
                    _departmentRepo.save(artwork);

                    return new OperationResponse(true, "Department actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, departmentId));
    }

    @Override
    public OperationResponse deleteDepartment(Long departmentId) {
        return _departmentRepo.findById(departmentId).map(
                artwork -> {
                    _departmentRepo.delete(artwork);
                    return new OperationResponse(true, "Department eliminado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, departmentId));
    }

    @Override
    public Department getDepartment(Long departmentId) {
        try {
            return _departmentRepo.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, departmentId));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el Department", e);
        }
    }

    @Override
    public List<Department> getDepartments() {
        try {
            return _departmentRepo.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Departments", e);
        }
    }
    
}
