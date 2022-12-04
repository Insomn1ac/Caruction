package org.intensive.caruction.controller;

import org.intensive.caruction.dto.ReturnId;
import org.intensive.caruction.model.Category;
import org.intensive.caruction.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/new")
    public ReturnId addCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ReturnId(category.getId());
    }

    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable long id) {
        return categoryService.findCategoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuction(@PathVariable long id) {
        categoryService.deleteAuctionById(id);
    }
}
