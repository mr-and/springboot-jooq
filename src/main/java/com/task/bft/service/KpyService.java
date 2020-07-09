package com.task.bft.service;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

/**
 * Сервис персональных личных дел
 */

@Service
public class KpyService {

  private final DSLContext context;

  public KpyService(DSLContext context) {
    this.context = context;
  }

  // Удаление личного дела по id
  public void deleteOneKpy(Long id) {
    context.delete(Tables.PSN_KPY).where(Tables.PSN_KPY.ID.eq(id)).execute();
  }

  // Кол-во личных дел без приказа
  public int countKpyWithoutOrder() {
    return context.selectCount().from(Tables.PSN_KPY)
        .where(Tables.PSN_KPY.ORD_UN_DATE.isNull()).fetchOne(0, int.class);
  }

}
