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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Test;

/**
 * Tests for {@link WindowVisibilityMonitor#componentShown(java.awt.event.ComponentEvent)}.
 * 
 * @author Alex Ruiz
 */
public class WindowVisibilityMonitor_componentShown_Test extends WindowVisibilityMonitor_TestCase {
  @Test
  public void should_Mark_Window_As_Showing_When_Window_Is_Shown() {
    monitor.componentShown(componentEventWithWindowAsSource());
    verify(windows).markAsShowing(window);
  }

  @Test
  public void should_Not_Mark_Window_As_Showing_If_Component_Shown_Is_Not_Window() {
    monitor.componentShown(componentEventWithTextFieldAsSource());
    verifyZeroInteractions(windows);
  }
}
