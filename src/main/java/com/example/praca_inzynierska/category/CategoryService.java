package com.example.praca_inzynierska.category;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<CategoryNameDto> findAllCategoryNames() {
        return categoryDao.findAll()
                .stream().map(CategoryNameMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<CategoryFullInfo> findById(int categoryId) {
        return categoryDao.findById(categoryId)
                .map(CategoryFullInfoMapper::map);
    }

    private static class CategoryNameMapper {
        static CategoryNameDto map(Category c) {
            return new CategoryNameDto(
                    c.getId(),
                    c.getName()
            );
        }
    }

    private static class CategoryFullInfoMapper {
        static CategoryFullInfo map(Category c) {
            return new CategoryFullInfo(
                    c.getId(),
                    c.getName()
            );
        }
    }
}