package com.pknu26.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu26.food.dto.Food;
import com.pknu26.food.mapper.FoodMapper;

@Service
public class FoodService {

    @Autowired
    private FoodMapper foodMapper;

    public List<Food> getAllFoods(){
        return foodMapper.findAll();
    }

    public Food getFoodById(Long id){
        return foodMapper.findById(id);
    }

    public int addFood(Food food){
        return foodMapper.insert(food);
    }

}
