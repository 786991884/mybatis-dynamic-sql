/*
 *    Copyright 2016-2020 the original author or authors.
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
package org.mybatis.dynamic.sql.select.aggregate;

import java.sql.JDBCType;
import java.util.Optional;

import org.mybatis.dynamic.sql.BindableColumn;
import org.mybatis.dynamic.sql.render.TableAliasCalculator;

/**
 * CountAll seems like the other aggregates, but it is special because there is no column.
 * Rather than dealing with a useless and confusing abstraction, we simply implement
 * BindableColumn directly.
 *  
 * @author Jeff Butler
 */
public class CountAll implements BindableColumn<Long> {
    
    private final String alias;

    public CountAll() {
        alias = null;
    }

    private CountAll(String alias) {
        this.alias = alias;
    }

    @Override
    public String renderWithTableAlias(TableAliasCalculator tableAliasCalculator) {
        return "count(*)"; //$NON-NLS-1$
    }

    @Override
    public Optional<String> alias() {
        return Optional.ofNullable(alias);
    }

    @Override
    public CountAll as(String alias) {
        return new CountAll(alias);
    }

    @Override
    public Optional<JDBCType> jdbcType() {
        return Optional.of(JDBCType.BIGINT);
    }
}
