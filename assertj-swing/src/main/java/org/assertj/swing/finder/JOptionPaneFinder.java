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
package org.assertj.swing.finder;

import java.awt.Component;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.JOptionPane;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.JOptionPaneFixture;

/**
 * <p>
 * Finder for {@code JOptionPane}s. Lookups are performed till a file chooser is found, or until the given time to
 * perform the lookup is over. The default lookup time is 5 seconds.
 * </p>
 * 
 * <p>
 * This example illustrates finding a {@code JOptionPane} by name, using the default lookup time (5 seconds):
 * 
 * <pre>
 * JOptionPaneFixture optionPane = JOptionPaneFinder.findOptionPane().using(robot);
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * Where {@code robot} is an instance of {@link org.assertj.swing.core.Robot}.
 * </p>
 * 
 * <p>
 * This example shows how to find a {@code JOptionPane} by type using a lookup time of 10 seconds:
 * 
 * <pre>
 * JOptionPaneFixture optionPane = JOptionPaneFinder.findOptionPane().withTimeout(10000).using(robot);
 * </pre>
 * 
 * We can also specify the time unit:
 * 
 * <pre>
 * JOptionPaneFixture optionPane = JOptionPaneFinder.findOptionPane().withTimeout(10, {@link TimeUnit#SECONDS SECONDS}).using(robot);
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * This example shows how to find a {@code JOptionPane} using a {@link GenericTypeMatcher}:
 * 
 * <pre>
 * GenericTypeMatcher&lt;JOptionPane&gt; matcher = new GenericTypeMatcher&lt;JOptionPane&gt;() {
 *   protected boolean isMatching(JOptionPane optionPane) {
 *     return &quot;A message&quot;.equals(optionPane.getMessage());
 *   }
 * };
 * JOptionPaneFixture optionPane = JOptionPaneFinder.findOptionPane(matcher).using(robot);
 * </pre>
 * 
 * </p>
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class JOptionPaneFinder extends ComponentFinderTemplate<JOptionPane> {
  /**
   * Creates a new {@link JOptionPaneFinder}. This finder looks up a {@code JOptionPane} by type.
   */
  protected JOptionPaneFinder() {
    super(JOptionPane.class);
  }

  /**
   * Creates a new {@link JOptionPaneFinder}.
   * 
   * @param matcher specifies the search criteria to use when looking up a {@code JOptionPane}.
   */
  protected JOptionPaneFinder(@Nonnull GenericTypeMatcher<? extends JOptionPane> matcher) {
    super(matcher);
  }

  /**
   * Creates a new {@link JOptionPaneFinder} capable of looking up a {@code JOptionPane}.
   * 
   * @return the created finder.
   */
  public static @Nonnull JOptionPaneFinder findOptionPane() {
    return new JOptionPaneFinder();
  }

  /**
   * Creates a new {@link JOptionPaneFinder} capable of looking up a {@code JOptionPane} using the given matcher.
   * 
   * @param matcher the given matcher.
   * @return the created finder.
   */
  public static @Nonnull JOptionPaneFinder findOptionPane(@Nonnull GenericTypeMatcher<? extends JOptionPane> matcher) {
    return new JOptionPaneFinder(matcher);
  }

  /**
   * Finds a {@code JOptionPane} by name or type.
   * 
   * @param robot contains the underlying finding to delegate the search to.
   * @return a {@code JOptionPaneFixture} managing the found {@code JOptionPane}.
   * @throws org.assertj.swing.exception.WaitTimedOutError if a {@code JOptionPane} could not be found.
   */
  @Override
  public @Nonnull JOptionPaneFixture using(@Nonnull Robot robot) {
    return new JOptionPaneFixture(robot, findComponentWith(robot));
  }

  /**
   * Sets the timeout for this finder. The window to search should be found within the given time period.
   * 
   * @param timeout the number of milliseconds before stopping the search.
   * @return this finder.
   */
  @Override
  public @Nonnull JOptionPaneFinder withTimeout(@Nonnegative long timeout) {
    super.withTimeout(timeout);
    return this;
  }

  /**
   * Sets the timeout for this finder. The window to search should be found within the given time period.
   * 
   * @param timeout the period of time the search should be performed.
   * @param unit the time unit for {@code timeout}.
   * @return this finder.
   */
  @Override
  public @Nonnull JOptionPaneFinder withTimeout(@Nonnegative long timeout, @Nonnull TimeUnit unit) {
    super.withTimeout(timeout, unit);
    return this;
  }

  /**
   * Casts the given AWT or Swing {@code Component} to {@code JOptionPane}.
   * 
   * @return the given {@code Component}, casted to {@code JFileChooser}.
   */
  @Override
  protected @Nullable JOptionPane cast(@Nullable Component c) {
    return (JOptionPane) c;
  }
}