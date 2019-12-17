package com.example.demo.presentation;

import com.example.demo.domain.ListEntity;
import com.example.demo.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListService {
    @Autowired
    private ListRepository listRepository;



}
