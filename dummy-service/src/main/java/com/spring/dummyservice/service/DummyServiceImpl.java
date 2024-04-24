package com.spring.dummyservice.service;

import com.spring.dummyservice.domain.Dummy;
import com.spring.dummyservice.exception.BadRequestException;
import com.spring.dummyservice.exception.ConflictException;
import com.spring.dummyservice.repository.DummyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DummyServiceImpl implements DummyService {

    private final DummyRepository dummyRepository;

    public DummyServiceImpl(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    @Override
    public void getDummy(int userId) {
        log.info("Get Dummy Service called");
        if (isDummyHasUser(userId)) throw new ConflictException("User Was Already Exist");
            Dummy dummy = new Dummy();
            dummy.setUserId(userId);
            dummyRepository.save(dummy);

    }


    private boolean isDummyHasUser(int userId) {
        log.info("Is Dummy Has User Service called");
        Dummy dummy = dummyRepository.findByUserId(userId);
        return dummy != null;
    }
}
