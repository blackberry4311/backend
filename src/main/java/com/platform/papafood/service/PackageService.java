//package com.platform.papafood.service;
//
//import com.platform.papafood.adapters.PackageAdapter;
//import com.platform.papafood.commons.DEFAULT;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.jdbc.pojos.Package;
//import com.platform.papafood.models.CustomerModel;
//import com.platform.papafood.models.PackageModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PackageService {
//
//    private static final Logger LOG = Logger.getLogger(PackageService.class);
//
//    @Autowired
//    DAOImplementRepository<Package> daoImplementRepository;
//
//    @Autowired
//    CustomerService customerService;
//
//    public List<PackageModel> list(String token) {
//        try {
//            CustomerModel currentCustomer = customerService.get(token);
//            if (Utils.isEmpty(currentCustomer) || currentCustomer.getId() <= 0) {
//                return DEFAULT.emptyList;
//            }
//            List<Package> packages = daoImplementRepository.select(new Package(0, "", false, "", "", "", 0, 0, 0, "", true), Package.class);
//            List<PackageModel> packageModels = new ArrayList<>();
//            for (Package pkg : packages) {
//                packageModels.add(PackageAdapter.adaptPackage(pkg));
//            }
//            return packageModels;
//
//        } catch (Exception e) {
//            LOG.error(e);
//            return new ArrayList<>();
//        }
//
//
//    }
//
//    public PackageModel get(int id) {
//        try {
//            List<Package> packages = daoImplementRepository.select(new Package(id, "", false, "", "", "", 0, 0, 0, "", true), Package.class);
//            if (packages.size() != 1) {
//                LOG.warn("Package is empty !");
//                return new PackageModel();
//            }
//            PackageModel packageModel = PackageAdapter.adaptPackage(packages.get(0));
//            return packageModel;
//
//        } catch (Exception e) {
//            LOG.error(e);
//            return new PackageModel();
//        }
//    }
//}
