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
package org.assertj.swing.core;

import static org.assertj.core.api.Assertions.assertThat;

import javax.swing.JPopupMenu;

import org.junit.Test;

/**
 * Tests for {@link BasicRobot#findActivePopupMenu()}.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class BasicRobot_findActivePopupMenu_Test extends BasicRobot_TestCase {
  @Test
  public void should_Return_Active_PopupMenu() {
    JPopupMenu popupMenu = addPopupMenuToTextField();
    robot().showPopupMenu(window().textField());
    JPopupMenu found = robot().findActivePopupMenu();
    assertThat(found).isSameAs(popupMenu);
  }

  @Test
  public void should_Return_Null_If_Active_PopupMenu_Not_Found() {
    JPopupMenu found = robot().findActivePopupMenu();
    assertThat(found).isNull();
  }
}
