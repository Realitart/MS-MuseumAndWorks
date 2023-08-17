package com.realitart.museumsandworks.Service;



import com.realitart.museumsandworks.Domain.Department;
import com.realitart.museumsandworks.share.response.OperationResponse;

import java.util.List;

public interface IDepartmentService {
    OperationResponse createDepartment(Department request);

    OperationResponse updateDepartment(Long assetId, Department request);

    OperationResponse deleteDepartment(Long assetId);

    Department getDepartment(Long assetId);

    List<Department> getDepartments();
}
