package com.tej.JooQDemo.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DTO для вывода словаря
 */

@Data
@RequiredArgsConstructor
public class DictLineDto implements Serializable {

  private String code;
  private String name;

}
