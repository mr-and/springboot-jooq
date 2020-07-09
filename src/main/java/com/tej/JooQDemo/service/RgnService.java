package com.tej.JooQDemo.service;

import static org.jooq.impl.DSL.count;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для справочника регионов
 */

@Service
public class RgnService {

  private final DSLContext context;

  @Autowired
  public RgnService(DSLContext context) {
    this.context = context;
  }

  public Result<Record3<String, Integer, String>> getRgnWithCountKpyAndCode() {
    return context
        .select(
            Tables.REF_RGN.NAME.as("region"),
            count(Tables.PSN_KPY.ID),
            Tables.REF_RGN.CODE.as("code")
        )
        .from(Tables.REF_RGN)
        .join(Tables.REF_SZN).on(Tables.REF_SZN.RGN_ID.eq(Tables.REF_RGN.ID))
        .join(Tables.PSN_KPY).on(Tables.PSN_KPY.SZN_DEP_ID.eq(Tables.REF_SZN.ID))
        .groupBy(Tables.REF_RGN.NAME, Tables.REF_RGN.CODE)
        .fetch();
  }

}
