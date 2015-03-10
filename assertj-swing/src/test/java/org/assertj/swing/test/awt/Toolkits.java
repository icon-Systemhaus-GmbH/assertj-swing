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
package org.assertj.swing.test.awt;

import static org.mockito.Mockito.mock;

import java.awt.EventQueue;
import java.awt.Toolkit;

/**
 * Implementations of {@code Toolkit} to be used for testing.
 * 
 * @author Alex Ruiz
 */
public final class Toolkits {
  public static Toolkit singletonToolkitMock() {
    return LazyLoadedSingleton.INSTANCE;
  }

  private static class LazyLoadedSingleton {
    static final Toolkit INSTANCE = newToolkitMock();
  }

  public static Toolkit newToolkitMock() {
    return mock(Toolkit.class);
  }

  public static ToolkitStub newToolkitStub() {
    return ToolkitStub.createNew();
  }

  public static ToolkitStub newToolkitStub(EventQueue eventQueue) {
    return ToolkitStub.createNew(eventQueue);
  }

  private Toolkits() {
  }
}
