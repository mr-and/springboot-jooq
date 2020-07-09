package com.tej.JooQDemo.service;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefDict;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefFdo;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefRgn;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.RefSzn;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для вызова справочников
 */

@Service
public class DictionaryService {

  private final DSLContext dslContext;

  @Autowired
  public DictionaryService(DSLContext dslContext) {
    this.dslContext = dslContext;
  }

  // Справочник региона
  public List<RefRgn> getRngInfo(){
    return dslContext.select().from(Tables.REF_RGN).fetchInto(RefRgn.class);
  }

  // Справочник федеральных округов
  public List<RefFdo> getRefFdo(){
    return dslContext.select().from(Tables.REF_FDO).fetchInto(RefFdo.class);
  }

  // Справочник СЗН
  public List<RefSzn> getRefSzn(){
    return dslContext.select().from(Tables.REF_SZN).fetchInto(RefSzn.class);
  }

  // Словарь
  public List<RefDict> getRefDict(){
    return dslContext.select().from(Tables.REF_DICT).fetchInto(RefDict.class);
  }

  // Строка Словаря
  public Result<Record2<String, String>> getDictLine(){
    return dslContext
        .select(
            Tables.REF_DICT_LINE.CODE,
            Tables.REF_DICT.NAME
        )
        .from(Tables.REF_DICT_LINE)
        .join(Tables.REF_DICT).on(Tables.REF_DICT_LINE.DICT_ID.eq(Tables.REF_DICT.ID))
        .limit(5)
        .fetch();
  }
}
