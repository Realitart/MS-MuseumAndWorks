package com.realitart.museumsandworks.Service;



import com.realitart.museumsandworks.Domain.Category;
import com.realitart.museumsandworks.share.response.OperationResponse;

import java.util.List;

public interface ICategoryService {
    OperationResponse createCategory(Category request);

    OperationResponse updateCategory(Long assetId, Category request);

    OperationResponse deleteCategory(Long assetId);

    Category getCategory(Long assetId);

    List<Category> getCategories();
}
