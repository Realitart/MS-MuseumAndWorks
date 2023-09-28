package com.realitart.museumsandworks.Service.Impl;

import com.realitart.museumsandworks.Domain.Category;
import com.realitart.museumsandworks.Domain.Repositories.ICategoryRepository;
import com.realitart.museumsandworks.Service.ICategoryService;
import com.realitart.museumsandworks.share.exceptions.ResourceNotFoundException;
import com.realitart.museumsandworks.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private static final String ENTITY = "Category";
    @Autowired
    ICategoryRepository _categoryRepo;

    @Override
    public OperationResponse createCategory(Category request) {
        try{            request.setId(null);

            _categoryRepo.save(request);
            return new OperationResponse(true, "Category creado correctamente");
        } catch (Exception e) {
            return new OperationResponse(false, "Error al crear el Category");
        }
    }

    @Override
    public OperationResponse updateCategory(Long commentId, Category request) {
        return _categoryRepo.findById(commentId).map(
                artwork -> {
                    if(request.getName() != null) artwork.setName(request.getName());
                    if(request.getDescription() != null) artwork.setDescription(request.getDescription());
                    _categoryRepo.save(artwork);

                    return new OperationResponse(true, "Category actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public OperationResponse deleteCategory(Long commentId) {
        return _categoryRepo.findById(commentId).map(
                artwork -> {
                    _categoryRepo.delete(artwork);
                    return new OperationResponse(true, "Category eliminado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Category getCategory(Long commentId) {
        try {
            return _categoryRepo.findByEnableTrueAndId(commentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el Category", e);
        }
    }

    @Override
    public List<Category> getCategories() {
        try {
            return _categoryRepo.findByEnableTrue();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Categorys", e);
        }
    }

}
