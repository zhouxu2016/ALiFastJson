package com.zhouxu.example.service.serviceimpl;

import com.zhouxu.example.dao.TutorMapper;
import com.zhouxu.example.pojo.Tutor;
import com.zhouxu.example.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouxu on 2017/9/12 22:43.
 */

@SuppressWarnings("all")
@Service
public class TutorServiceImpl implements TutorService {


    @Autowired
    private TutorMapper tutorMapper;

    @Override
    public Tutor findTutorById(int tutorId) {

        return tutorMapper.findTutorById(tutorId);
    }
}
