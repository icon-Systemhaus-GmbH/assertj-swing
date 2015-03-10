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
import static org.assertj.swing.test.core.NeverMatchingComponentMatcher.neverMatches;

import javax.annotation.Nonnull;
import javax.swing.JButton;
import javax.swing.JTree;

import org.assertj.swing.exception.ComponentLookupException;
import org.junit.Test;

/**
 * Tests for {@link BasicComponentFinder#find(java.awt.Container, GenericTypeMatcher)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Price
 */
public class BasicComponentFinder_findUsingGenericTypeMatcherInRoot_Test extends BasicComponentFinder_TestCase {
  private MyWindow windowTwo;

  @Test
  public void should_Find_Component() {
    windowTwo = MyWindow.createNew(getClass());
    JButton foundButton = finder.find(window, new GenericTypeMatcher<JButton>(JButton.class) {
      @Override
      protected boolean isMatching(@Nonnull JButton button) {
        return "A Button".equals(button.getText());
      }
    });
    assertThat(foundButton).isSameAs(window.button);
  }

  @Test(expected = ComponentLookupException.class)
  public void should_Throw_Error_If_GenericTypeMatcher_Matches_Wrong_Type() {
    finder.find(window, new GenericTypeMatcher<JTree>(JTree.class) {
      @Override
      protected boolean isMatching(@Nonnull JTree component) {
        return true;
      }
    });
  }

  @Test(expected = ComponentLookupException.class)
  public void should_Throw_Error_If_GenericTypeMatcher_Never_Matches_Component() {
    finder.find(window, neverMatches(JButton.class));
  }

  @Override
  void beforeReleasingScreenLock() {
    if (windowTwo != null) {
      windowTwo.destroy();
    }
  }
}
