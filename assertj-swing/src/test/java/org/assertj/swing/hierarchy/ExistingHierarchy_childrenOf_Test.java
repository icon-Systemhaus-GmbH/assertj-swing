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
package org.assertj.swing.hierarchy;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.test.builder.JTextFields.textField;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Component;
import java.util.Collection;

import org.assertj.swing.test.core.EDTSafeTestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link ExistingHierarchy#childrenOf(Component)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ExistingHierarchy_childrenOf_Test extends EDTSafeTestCase {
  private Component c;
  private Collection<Component> children;
  private ChildrenFinder childrenFinder;
  private ExistingHierarchy hierarchy;

  @Before
  public void setUp() {
    c = textField().createNew();
    childrenFinder = mock(ChildrenFinder.class);
    hierarchy = new ExistingHierarchy(new ParentFinder(), childrenFinder);
    children = emptyList();
  }

  @Test
  public void should_Return_Children_Of_Component() {
    when(childrenFinder.childrenOf(c)).thenReturn(children);
    assertThat(hierarchy.childrenOf(c)).isSameAs(children);
  }
}
