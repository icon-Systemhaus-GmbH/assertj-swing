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
package org.assertj.swing.driver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.swing.test.swing.TestTable.createCellValueFrom;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for {@link JTableDriver#selectionValue(javax.swing.JTable)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
@RunWith(Parameterized.class)
public class JTableDriver_selectionValue_withManyCells_Test extends JTableDriver_TestCase {
  private final int row;
  private final int column;

  @Parameters
  public static Collection<Object[]> cells() {
    return newArrayList(tableCells());
  }

  public JTableDriver_selectionValue_withManyCells_Test(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Test
  public void should_Return_Cell_Value() {
    selectCell(row, column);
    String value = driver.selectionValue(table);
    assertThat(value).isEqualTo(createCellValueFrom(row, column));
    assertThatCellReaderWasCalled();
  }
}
