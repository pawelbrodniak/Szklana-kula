package com.example.praca_inzynierska;

import com.example.praca_inzynierska.Classification;
import com.example.praca_inzynierska.ClassificationDao;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationService {
    private ClassificationDao classificationDao = new ClassificationDao();

    public List<Classification> findAllName() {
        return classificationDao.findAll()
                .stream().map(ClassificationMapper::map)
                .collect(Collectors.toList());
    }



    private static class ClassificationMapper {
        static Classification map(Classification c) {
            return new Classification(
                    c.getId(),
                    c.getName(),
                    c.getPoints()
            );
        }
    }


}