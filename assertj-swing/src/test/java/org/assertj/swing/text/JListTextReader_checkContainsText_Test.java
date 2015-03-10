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
package org.assertj.swing.text;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.annotation.Nonnull;
import javax.swing.JList;

import org.assertj.swing.cell.JListCellReader;
import org.assertj.swing.test.core.EDTSafeTestCase;
import org.assertj.swing.test.swing.TestListModel;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link JListTextReader#checkContainsText(JList, String)}.
 * 
 * @author Alex Ruiz
 */
public class JListTextReader_checkContainsText_Test extends EDTSafeTestCase {
  private JList list;
  private TestListModel listModel;
  private JListTextReader reader;

  @Before
  public void setUp() {
    list = mock(JList.class);
    listModel = new TestListModel(null, "Yoda", "Luke", "Leia");
    reader = new JListTextReader(new TestJListCellReader());
  }

  @Test
  public void should_Return_False_If_Text_In_JList_Does_Not_Contain_Given_String() {
    when(list.getModel()).thenReturn(listModel);
    assertThat(reader.checkContainsText(list, "Han")).isFalse();
  }

  @Test
  public void should_Return_True_If_Text_In_JList_Contains_Given_String() {
    when(list.getModel()).thenReturn(listModel);
    assertThat(reader.checkContainsText(list, "Yo")).isTrue();
  }

  private static class TestJListCellReader implements JListCellReader {
    @Override
    public String valueAt(@Nonnull JList list, int index) {
      Object element = list.getModel().getElementAt(index);
      return element != null ? element.toString() : null;
    }
  }
}
