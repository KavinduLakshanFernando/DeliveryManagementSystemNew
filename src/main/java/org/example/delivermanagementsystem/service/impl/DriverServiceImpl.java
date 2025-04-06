package org.example.delivermanagementsystem.service.impl;

import org.example.delivermanagementsystem.dto.DriverDTO;
import org.example.delivermanagementsystem.entity.Driver;
import org.example.delivermanagementsystem.repo.DriverRepository;
import org.example.delivermanagementsystem.repo.UserRepository;
import org.example.delivermanagementsystem.service.DriverService;
import org.example.delivermanagementsystem.utill.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int saveDriver(DriverDTO driverDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        driverDTO.setPassword(passwordEncoder.encode(driverDTO.getPassword()));
        Driver driver = modelMapper.map(driverDTO, Driver.class);
        Driver savedDriver = driverRepository.save(driver);
        return (savedDriver != null) ? VarList.Created : VarList.Not_Acceptable;
    }
}
