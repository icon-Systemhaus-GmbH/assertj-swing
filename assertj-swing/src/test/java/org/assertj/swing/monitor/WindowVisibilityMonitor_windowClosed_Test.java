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
import static org.assertj.swing.test.core.MethodInvocations.Args.args;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.awt.event.WindowEvent;

import org.junit.Test;

/**
 * Tests for {@link WindowVisibilityMonitor#windowClosed(WindowEvent)}.
 * 
 * @author Alex Ruiz
 */
public class WindowVisibilityMonitor_windowClosed_Test extends WindowVisibilityMonitor_TestCase {
  @Test
  public void should_Remove_Itself_When_Window_Is_Closed() {
    window.startRecording();
    monitor.windowClosed(new WindowEvent(window, 8));
    assertThat(window.requireInvoked("removeWindowListener", args(monitor)));
    assertThat(window.requireInvoked("removeComponentListener", args(monitor)));
    verifyZeroInteractions(windows);
  }
}
