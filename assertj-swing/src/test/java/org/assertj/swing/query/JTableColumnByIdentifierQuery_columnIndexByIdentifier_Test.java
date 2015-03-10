/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.query;

import static java.lang.Integer.parseInt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.swing.test.core.MethodInvocations.Args.args;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for {@link JTableColumnByIdentifierQuery#columnIndexByIdentifier(javax.swing.JTable, Object)}.
 * 
 * @author Alex Ruiz
 */
@RunWith(Parameterized.class)
public class JTableColumnByIdentifierQuery_columnIndexByIdentifier_Test extends JTableColumnByIdentifierQuery_TestCase {
  private final String identifier;

  @Parameters
  public static Collection<Object[]> columnNames() {
    return newArrayList(new Object[][] { { "0" }, { "1" }, { "2" }, { "3" } });
  }

  public JTableColumnByIdentifierQuery_columnIndexByIdentifier_Test(String identifier) {
    this.identifier = identifier;
  }

  @Test
  public void should_Return_Column_Index_Given_Identifier() {
    table.startRecording();
    int index = parseInt(identifier);
    assertThat(columnIndexByIdentifier(identifier)).isEqualTo(index);
    table.requireInvoked("getColumn", args(identifier));
  }
}
