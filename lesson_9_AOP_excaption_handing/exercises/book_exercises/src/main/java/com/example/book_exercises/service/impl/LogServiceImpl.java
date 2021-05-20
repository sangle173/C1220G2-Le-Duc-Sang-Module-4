package com.example.book_exercises.service.impl;
import com.example.book_exercises.model.Log;
import com.example.book_exercises.repository.LogRepository;
import com.example.book_exercises.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogRepository logRepository;

    @Override
    public long getSize() {
        return logRepository.findAll().size();
    }

    @Override
    public void initialize() {
        if (getSize() == 0) {
            logRepository.save(new Log());
        }
    }

    @Override
    public int getVisitorNumber(Integer id) {
        Log log = logRepository.getOne(id);
        return log.getVisitors();
    }

    @Override
    public void addVisitor(Integer id) {
        Log log = logRepository.getOne(id);
        log.setVisitors(log.getVisitors() + 1);
        logRepository.save(log);
    }
}
