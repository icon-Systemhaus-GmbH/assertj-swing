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

import org.assertj.swing.cell.JTableCellWriter;

/**
 * Test case for implementations of {@link JTableCellWriter#startCellEditing(javax.swing.JTable, int, int)}.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class BasicJTableCellWriter_startCellEditing_Test extends JTableCellWriter_startCellEditing_TestCase {
  @Override
  JTableCellWriter createWriter() {
    return new BasicJTableCellWriter(robot);
  }
}
