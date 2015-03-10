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
package org.assertj.swing.core.matcher;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.swing.test.core.EDTSafeTestCase;
import org.junit.Test;

/**
 * Tests for {@link FrameMatcher#toString()}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class FrameMatcher_toString_Test extends EDTSafeTestCase {
  @Test
  public void should_Implement_ToString() {
    FrameMatcher matcher = FrameMatcher.withName("frame").andTitle("Hello").andShowing();
    assertThat(matcher.toString()).isEqualTo(
        "org.assertj.swing.core.matcher.FrameMatcher[name='frame', title='Hello', requireShowing=true]");
  }
}
