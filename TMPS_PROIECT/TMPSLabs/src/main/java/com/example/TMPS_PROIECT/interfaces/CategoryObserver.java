package com.example.TMPS_PROIECT.interfaces;

import com.example.TMPS_PROIECT.App.Category;

import java.util.List;

public interface CategoryObserver {
    void update(List<Category> categories);
}