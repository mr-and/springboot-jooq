package com.task.bft.dto;

import java.io.Serializable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * DTO для вывода общего кол-ва личных дел по регионам
 */

@Data
@RequiredArgsConstructor
public class RgnKpyDto implements Serializable {

  private String region;
  private Integer count;

}


