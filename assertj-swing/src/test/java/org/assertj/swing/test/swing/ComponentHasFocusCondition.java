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
package org.assertj.swing.test.swing;

import static org.assertj.core.util.Strings.concat;
import static org.assertj.swing.format.Formatting.format;
import static org.assertj.swing.query.ComponentHasFocusQuery.hasFocus;

import java.awt.Component;

import javax.annotation.Nonnull;

import org.assertj.swing.timing.Condition;

/**
 * Condition that checks that an AWT or Swing {@code Component} has focus.
 * 
 * @author Yvonne Wang
 */
public class ComponentHasFocusCondition extends Condition {
  private Component component;

  public static @Nonnull ComponentHasFocusCondition untilFocused(@Nonnull Component component) {
    return new ComponentHasFocusCondition(component);
  }

  private ComponentHasFocusCondition(@Nonnull Component component) {
    super(concat(format(component), " has focus"));
    this.component = component;
  }

  @Override
  public boolean test() {
    return hasFocus(component);
  }

  @Override
  protected void done() {
    component = null;
  }
}
