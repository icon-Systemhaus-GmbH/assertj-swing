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

import org.junit.Test;

/**
 * Tests for {@link JComboBoxDriver#value(javax.swing.JComboBox, int)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JComboBoxDriver_value_Test extends JComboBoxDriver_TestCase {
  @Test
  public void should_Return_Value_As_Text_Of_Item() {
    String value = driver.value(comboBox, 2);
    assertThat(value).isEqualTo("third");
    assertThatCellReaderWasCalled();
  }
}
