package com.tej.JooQDemo.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DTO для вывода общего кол-ва личных дел по регионам с кодом города
 */

@Data
@RequiredArgsConstructor
public class RgnKpyCodeDto implements Serializable {

  private String region;
  private Integer count;
  private String code;

}


