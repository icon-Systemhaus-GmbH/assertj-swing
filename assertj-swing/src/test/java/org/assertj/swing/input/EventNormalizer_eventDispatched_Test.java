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
package org.assertj.swing.input;

import static org.assertj.swing.test.awt.TestAWTEvents.singletonAWTEventMock;
import static org.assertj.swing.test.awt.Toolkits.newToolkitMock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link EventNormalizer#eventDispatched(AWTEvent)}.
 * 
 * @author Alex Ruiz
 */
public class EventNormalizer_eventDispatched_Test extends EventNormalizer_TestCase {
  private DisposedWindowMonitor disposedWindowMonitor;
  private AWTEventListener delegateEventListener;
  private AWTEvent event;
  private EventNormalizer eventNormalizer;

  @Before
  public void setUp() {
    disposedWindowMonitor = mock(DisposedWindowMonitor.class);
    delegateEventListener = delegateEventListenerMock();
    event = singletonAWTEventMock();
    eventNormalizer = new EventNormalizer(disposedWindowMonitor);
    eventNormalizer.startListening(newToolkitMock(), delegateEventListener, 8);
  }

  @Test
  public void should_Delegate_Event_If_It_Is_Not_A_Duplicate_Dispose() {
    when(disposedWindowMonitor.isDuplicateDispose(event)).thenReturn(false);
    eventNormalizer.eventDispatched(event);
    verify(delegateEventListener).eventDispatched(event);
  }

  @Test
  public void should_Not_Delegate_Event_If_It_Is_A_Duplicate_Dispose() {
    when(disposedWindowMonitor.isDuplicateDispose(event)).thenReturn(true);
    eventNormalizer.eventDispatched(event);
    verifyZeroInteractions(delegateEventListener);
  }
}
