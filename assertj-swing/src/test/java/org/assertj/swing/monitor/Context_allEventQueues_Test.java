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
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.when;

import java.awt.EventQueue;
import java.util.Collection;

import org.junit.Test;

/**
 * Tests for {@link Context#allEventQueues()}.
 * 
 * @author Alex Ruiz
 */
public class Context_allEventQueues_Test extends Context_TestCase {
  @Test
  public void should_Return_All_EventQueues() {
    when(windowEventQueueMapping.eventQueues()).thenReturn(newArrayList(eventQueue));
    when(eventQueueMapping.eventQueues()).thenReturn(newArrayList(eventQueue));
    Collection<EventQueue> allEventQueues = context.allEventQueues();
    assertThat(allEventQueues).containsOnly(eventQueue);
  }
}
