package com.task.bft.controller;

import com.task.bft.dto.RgnKpyCodeDto;
import com.task.bft.service.RgnService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/region/stat_kpy")
public class RgnController {

  private final RgnService rgnService;

  @Autowired
  public RgnController(RgnService rgnService) {
    this.rgnService = rgnService;
  }

  @GetMapping
  public List<RgnKpyCodeDto> getCountKpyByRegionAndCode(
      @RequestParam(required = false) String region
  ) {
    if (region != null) {
      return rgnService.getRgnWithCountKpyAndCode().into(RgnKpyCodeDto.class)
          .stream()
          .filter(r -> r.getCode().equals(region))
          .collect(Collectors.toList());
    } else {
      return rgnService.getRgnWithCountKpyAndCode().into(RgnKpyCodeDto.class);
    }
  }

  @GetMapping(value = "/unemp_woman")
  public void criteria(
      @RequestParam(required = false) String region
  ) {
  // недостаточно данных: !psn_person
  }

}
