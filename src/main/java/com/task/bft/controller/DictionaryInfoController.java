package com.task.bft.controller;

import com.task.bft.dto.DictLineDto;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefDict;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefFdo;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefRgn;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefSzn;
import com.task.bft.service.DictionaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DictionaryInfoController {

  private final DictionaryService dictionaryService;

  @Autowired
  public DictionaryInfoController(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  @GetMapping(value = "/rgn/info")
  public List<RefRgn> getRgn(){
    return dictionaryService.getRngInfo();
  }

  @GetMapping(value = "/fdo/info")
  public List<RefFdo> getFdo(){
    return dictionaryService.getRefFdo();
  }

  @GetMapping(value = "/szn/info")
  public List<RefSzn> getSzn(){
    return dictionaryService.getRefSzn();
  }

  @GetMapping(value = "/dict/info")
  public List<RefDict> getDict(){
    return dictionaryService.getRefDict();
  }

  @GetMapping(value = "/dict_line/info")
  public List<DictLineDto> getDictLine(){
    return dictionaryService.getDictLine().into(DictLineDto.class);
  }

}
