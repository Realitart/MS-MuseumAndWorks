package com.realitart.museumsandworks.Controller;

import com.realitart.museumsandworks.Domain.Category;
import com.realitart.museumsandworks.Dtos.CategoryCreateDTO;
import com.realitart.museumsandworks.Service.ICategoryService;
import com.realitart.museumsandworks.share.mapping.entity.CategoryMapper;
import com.realitart.museumsandworks.share.response.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    private CategoryMapper mapper;
    
    @PostMapping
    @Operation(summary = "Create a new category")
    OperationResponse createCategory(@Valid @RequestBody CategoryCreateDTO request){
        return categoryService.createCategory(mapper.toModel(request));
    }
    
    @PutMapping("/{categoryId}")
    @Operation(summary = "Update a category")
    OperationResponse updateCategory(@PathVariable Long categoryId,@RequestBody CategoryCreateDTO request){
        return categoryService.updateCategory(categoryId,mapper.toModel(request));
    }
    
    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete a category")
    OperationResponse deleteCategory(@PathVariable Long categoryId){

        return categoryService.deleteCategory(categoryId);
    }
    
    @GetMapping("/{categoryId}")
    @Operation(summary = "Get a category by id")
    ResponseEntity<Category> getCategoryData(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }
    
    @GetMapping
    @Operation(summary = "Get all categorys")
    ResponseEntity<Page<Category>> getAllCategorys(Pageable pageable){
            return ResponseEntity.ok(mapper.modelListToPage(categoryService.getCategories(),pageable));

    }
    
    
}
