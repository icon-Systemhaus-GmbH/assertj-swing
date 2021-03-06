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
import static org.assertj.core.util.Strings.concat;
import static org.assertj.swing.edt.GuiActionRunner.execute;

import javax.swing.JTree;

import org.assertj.swing.annotation.RunsInEDT;
import org.assertj.swing.edt.GuiQuery;

/**
 * Base test case in {@link JTreeDriver} related to expanding/collapsing cells in a {@code JTree}.
 * 
 * @author Alex Ruiz
 */
public abstract class JTreeDriver_toggleCell_TestCase extends JTreeDriver_TestCase {
  @RunsInEDT
  final void requireRowExpanded(int row) {
    requireRowExpandedState(row, true);
  }

  @RunsInEDT
  final void requireRowCollapsed(int row) {
    requireRowExpandedState(row, false);
  }

  @RunsInEDT
  private void requireRowExpandedState(int row, final boolean expanded) {
    assertThat(isRowExpanded(tree, row)).as(concat("row ", row)).isEqualTo(expanded);
  }

  @RunsInEDT
  private static boolean isRowExpanded(final JTree tree, final int row) {
    return execute(new GuiQuery<Boolean>() {
      @Override
      protected Boolean executeInEDT() {
        return tree.isExpanded(row);
      }
    });
  }
}
