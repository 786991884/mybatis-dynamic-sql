/*
 *    Copyright 2016-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
@file:Suppress("TooManyFunctions")
package org.mybatis.dynamic.sql.util.kotlin.spring

import org.mybatis.dynamic.sql.BasicColumn
import org.mybatis.dynamic.sql.SqlTable
import org.mybatis.dynamic.sql.insert.BatchInsertDSL
import org.mybatis.dynamic.sql.insert.InsertDSL
import org.mybatis.dynamic.sql.insert.MultiRowInsertDSL
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.mybatis.dynamic.sql.util.kotlin.BatchInsertCompleter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.GeneralInsertCompleter
import org.mybatis.dynamic.sql.util.kotlin.InsertCompleter
import org.mybatis.dynamic.sql.util.kotlin.InsertSelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.MultiRowInsertCompleter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.model.count
import org.mybatis.dynamic.sql.util.kotlin.model.countDistinct
import org.mybatis.dynamic.sql.util.kotlin.model.countFrom
import org.mybatis.dynamic.sql.util.kotlin.model.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.model.insertInto
import org.mybatis.dynamic.sql.util.kotlin.model.insertSelect
import org.mybatis.dynamic.sql.util.kotlin.model.into
import org.mybatis.dynamic.sql.util.kotlin.model.select
import org.mybatis.dynamic.sql.util.kotlin.model.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.model.update

fun count(column: BasicColumn, completer: CountCompleter) =
    count(column, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun countDistinct(column: BasicColumn, completer: CountCompleter) =
    countDistinct(column, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun countFrom(table: SqlTable, completer: CountCompleter) =
    countFrom(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun deleteFrom(table: SqlTable, completer: DeleteCompleter) =
    deleteFrom(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun insertInto(table: SqlTable, completer: GeneralInsertCompleter) =
    insertInto(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun insertSelect(table: SqlTable, completer: InsertSelectCompleter) =
    insertSelect(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun <T> BatchInsertDSL.IntoGatherer<T>.into(table: SqlTable, completer: BatchInsertCompleter<T>) =
    into(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun <T> InsertDSL.IntoGatherer<T>.into(table: SqlTable, completer: InsertCompleter<T>) =
    into(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun <T> MultiRowInsertDSL.IntoGatherer<T>.into(table: SqlTable, completer: MultiRowInsertCompleter<T>) =
    into(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun select(vararg columns: BasicColumn, completer: SelectCompleter) =
    select(columns = columns, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun select(columns: List<BasicColumn>, completer: SelectCompleter) =
    select(columns, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun selectDistinct(vararg columns: BasicColumn, completer: SelectCompleter) =
    selectDistinct(columns = columns, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun selectDistinct(columns: List<BasicColumn>, completer: SelectCompleter) =
    selectDistinct(columns, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)

fun update(table: SqlTable, completer: UpdateCompleter) =
    update(table, completer).render(RenderingStrategies.SPRING_NAMED_PARAMETER)
