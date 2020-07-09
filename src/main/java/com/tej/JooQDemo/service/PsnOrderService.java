package com.tej.JooQDemo.service;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

/**
 * Сервис персональных приказов
 */

@Service
public class PsnOrderService {

  private final DSLContext context;

  public PsnOrderService(DSLContext context) {
    this.context = context;
  }

  // Удаление приказа по id
  public void deleteOrderById(Long id) {
    context.delete(Tables.PSN_ORDER).where(Tables.PSN_ORDER.ID.eq(id))
        .execute();
  }

  // Удаление всех приказов по id перс.личного дела
  public void deleteByKpyId(Long id) {
    context.delete(Tables.PSN_ORDER).where(Tables.PSN_KPY.ID.eq(id))
        .execute();
  }

}
