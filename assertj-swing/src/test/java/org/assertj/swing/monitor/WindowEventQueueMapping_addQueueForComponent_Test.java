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
package org.assertj.swing.monitor;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Window;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for {@link WindowEventQueueMapping#addQueueFor(java.awt.Component)}.
 * 
 * @author Alex Ruiz
 */
public class WindowEventQueueMapping_addQueueForComponent_Test extends WindowEventQueueMapping_withWindow_TestCase {
  @Test
  public void shouldA_Add_Queue_For_Window() {
    mapping.addQueueFor(window);
    assertThat(queueMap).hasSize(1);
    assertThat(queueMap.keySet()).contains(eventQueue);
    Map<Window, Boolean> windowMapping = queueMap.get(eventQueue);
    assertThat(windowMapping).hasSize(1);
    assertThat(windowMapping.keySet()).contains(window);
  }

  @Test
  public void should_Not_Add_Queue_For_Component_That_Is_Not_Window() {
    ComponentWithCustomEventQueue c = new ComponentWithCustomEventQueue(toolkit);
    mapping.addQueueFor(c);
    assertThat(queueMap).hasSize(1);
    assertThat(queueMap.keySet()).contains(eventQueue);
    Map<Window, Boolean> windowMapping = queueMap.get(eventQueue);
    assertThat(windowMapping).isEmpty();
  }
}
