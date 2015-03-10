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

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.swing.JTextField;

import org.junit.Test;

/**
 * Tests for {@link BasicComponentFinder#findAll(GenericTypeMatcher)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class BasicComponentFinder_findAllUsingGenericTypeMatcher_Test extends BasicComponentFinder_TestCase {
  @Test
  public void should_Return_All_Components_Matching_GenericTypeMatcher() {
    Collection<JTextField> found = finder.findAll(new GenericTypeMatcher<JTextField>(JTextField.class) {
      @Override
      protected boolean isMatching(@Nonnull JTextField c) {
        return true;
      }
    });
    assertThat(found).containsOnly(window.textField1, window.textField2);
  }
}
