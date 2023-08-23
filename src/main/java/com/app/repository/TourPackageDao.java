package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Package;



public interface TourPackageDao extends JpaRepository<Package, Long> {

}