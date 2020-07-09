package com.task.bft.controller;

import com.task.bft.service.PsnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class PsnOrderController {

  final PsnOrderService orderService;

  @Autowired
  public PsnOrderController(PsnOrderService orderService) {
    this.orderService = orderService;
  }

  @DeleteMapping(value = "/delete", params = {"id", "!kpy_id"})
  public void deleteOrderById(@RequestParam Long id) {
    orderService.deleteOrderById(id);
  }

  @DeleteMapping(value = "/delete", params = {"kpy_id", "!id"})
  public void deleteOrderByKpyId(@RequestParam Long kpy_id) {
    orderService.deleteByKpyId(kpy_id);
  }

}
