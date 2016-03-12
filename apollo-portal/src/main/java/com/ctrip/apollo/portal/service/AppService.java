package com.ctrip.apollo.portal.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ctrip.apollo.portal.domain.App;
import com.ctrip.apollo.portal.domain.AppRepository;

@Service
public class AppService {

  @Autowired
  private AppRepository appRepository;

  public App detail(String appId) {
    return appRepository.findOne(appId);
  }

  public Page<App> list(Pageable pageable) {
    return appRepository.findAll(pageable);
  }

  public App save(App app) {
    app.setCreateTimestamp(new Date());
    return appRepository.save(app);
  }
}