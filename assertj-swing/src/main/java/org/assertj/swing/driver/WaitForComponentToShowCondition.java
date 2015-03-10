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

import static org.assertj.core.util.Preconditions.checkNotNull;
import static org.assertj.core.util.Strings.concat;
import static org.assertj.swing.format.Formatting.format;
import static org.assertj.swing.query.ComponentShowingQuery.isShowing;

import java.awt.Component;

import javax.annotation.Nonnull;

import org.assertj.swing.timing.Condition;

/**
 * Verifies that an AWT or Swing {@code Component} is showing on the screen.
 * 
 * @author Yvonne Wang
 */
public class WaitForComponentToShowCondition extends Condition {
  private Component c;

  /**
   * Creates a new {@link WaitForComponentToShowCondition}.
   * 
   * @param c the AWT or Swing {@code Component} to verify.
   * @return the created condition.
   * @throws NullPointerException if the {@code Component} is {@code null}.
   */
  public static WaitForComponentToShowCondition untilIsShowing(@Nonnull Component c) {
    return new WaitForComponentToShowCondition(c);
  }

  private WaitForComponentToShowCondition(@Nonnull Component c) {
    super(concat("Component ", format(c), " to show on the screen"));
    this.c = checkNotNull(c);
  }

  /**
   * Indicates whether the AWT or Swing {@code Component} in this condition is showing on the screen.
   * 
   * @return {@code true} if the {@code Component} in this condition is showing on the screen, {@code false} otherwise
   */
  @Override
  public boolean test() {
    return isShowing(c);
  }

  @Override
  protected void done() {
    c = null;
  }
}
