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
package org.assertj.swing.fixture;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static org.assertj.swing.test.ExpectedException.none;

import org.assertj.swing.test.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link ColorFixture#requireNotEqualTo(java.awt.Color)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ColorFixture_requireNotEqualToColor_Test {
  @Rule
  public ExpectedException thrown = none();

  @Test
  public void should_Pass_If_Colors_Are_Not_Equal() {
    ColorFixture fixture = new ColorFixture(BLUE);
    fixture.requireNotEqualTo(RED);
  }

  @Test(expected = AssertionError.class)
  public void should_Fail_If_Colors_Are_Equal() {
    ColorFixture fixture = new ColorFixture(BLUE);
    fixture.requireNotEqualTo(BLUE);
  }

  @Test
  public void should_Fail_Showing_Description_If_Colors_Are_Equal() {
    ColorFixture fixture = new ColorFixture(BLUE, "test");
    thrown.expectAssertionError("test");
    fixture.requireNotEqualTo(BLUE);
  }
}
