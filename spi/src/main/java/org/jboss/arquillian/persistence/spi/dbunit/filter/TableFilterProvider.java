/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.persistence.spi.dbunit.filter;

import java.sql.SQLException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.filter.ITableFilter;

/**
 * Extension point to define custom implementation of {@link org.dbunit.database.DatabaseSequenceFilter}
 * which is used to seed and clean database by DBUnit.
 * <p>
 * Custom implementation can be bundled with the test class (for example as separated JAR) and should have
 * proper SPI entry in META-INF/services.
 *
 * @author <a href="mailto:bartosz.majsak@gmail.com">Bartosz Majsak</a>
 */
public interface TableFilterProvider {

    ITableFilter provide(IDatabaseConnection connection) throws SQLException, DataSetException;

    ITableFilter provide(IDatabaseConnection connection, String[] tableNames) throws SQLException, DataSetException;

    /**
     * Simple name used in configuration to refer to given implementation of the filter eg. 'default', 'oracle'
     */
    String simpleName();
}
