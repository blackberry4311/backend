//package com.platform.papafood.service;
//
//import com.platform.papafood.jdbc.pojos.Status;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StatusService {
//
//    @Autowired
//    DAOImplementRepository<Status> daoImplementRepository;
//
//    public List<Status> list() {
//        return daoImplementRepository.select(new Status(), Status.class, 0, 0);
//    }
//
//    public Status get(int id) {
//        List<Status> status = daoImplementRepository.select(new Status(id, null), Status.class, 0, 0);
//        return status.get(0);
//    }
//
//}
