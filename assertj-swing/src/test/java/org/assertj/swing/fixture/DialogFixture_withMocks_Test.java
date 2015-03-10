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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.Dialog;

import org.assertj.swing.core.Robot;
import org.assertj.swing.driver.DialogDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link DialogFixture}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class DialogFixture_withMocks_Test {
  private DialogFixture fixture;

  @Before
  public void setUp() {
    fixture = new DialogFixture(mock(Robot.class), mock(Dialog.class));
    fixture.replaceDriverWith(mock(DialogDriver.class));
  }

  @Test
  public void should_Call_RequireModal_In_Driver_And_Return_Self() {
    assertThat(fixture.requireModal()).isSameAs(fixture);
    verify(fixture.driver()).requireModal(fixture.target());
  }
}