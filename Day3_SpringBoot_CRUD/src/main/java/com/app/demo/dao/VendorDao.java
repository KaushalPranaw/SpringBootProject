package com.app.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.demo.pojo.Vendor;

public interface VendorDao extends CrudRepository<Vendor, Integer> {

}
