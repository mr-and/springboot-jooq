package com.task.bft.controller;

import com.task.bft.service.KpyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kpy")
public class KpyController {

  final KpyService kpyService;

  @Autowired
  public KpyController(KpyService kpyService) {
    this.kpyService = kpyService;
  }

  @DeleteMapping(value = "/delete")
  public void getBooks(@RequestParam Long id) {
    kpyService.deleteOneKpy(id);
  }

  @GetMapping(value = "/info/not_order")
  public int countKpyWithoutOrder() {
    return kpyService.countKpyWithoutOrder();
  }
}
