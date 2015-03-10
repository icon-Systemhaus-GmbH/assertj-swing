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

import java.awt.Component;
import java.awt.Frame;

import javax.annotation.Nonnull;

import org.assertj.swing.core.Robot;
import org.assertj.swing.driver.ComponentDriver;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link AbstractComponentFixture#AbstractComponentFixture(Class, Robot, Component)}.
 * 
 * @author Alex Ruiz
 */
public class AbstractComponentFixture_constructor_withTargetComponent_Test {
  private Robot robot;
  private Frame frame;

  @Before
  public void setUp() {
    robot = mock(Robot.class);
    frame = mock(Frame.class);
  }

  @Test(expected = NullPointerException.class)
  public void should_Throw_Error_If_SelfType_Is_Null() {
    new ComponentFixture(null, robot, frame);
  }

  @Test(expected = NullPointerException.class)
  public void should_Throw_Error_If_Robot_Is_Null() {
    new ComponentFixture(ComponentFixture.class, null, frame);
  }

  @Test(expected = NullPointerException.class)
  public void should_Throw_Error_If_Tareget_Is_Null() {
    new ComponentFixture(ComponentFixture.class, robot, null);
  }

  @Test
  public void should_Lookup_Component_By_Name_And_Type() {
    ComponentFixture fixture = new ComponentFixture(ComponentFixture.class, robot, frame);
    assertThat(fixture.robot()).isSameAs(robot);
    assertThat(fixture.target()).isSameAs(frame);
  }

  private static class ComponentFixture extends AbstractComponentFixture<ComponentFixture, Component, ComponentDriver> {
    ComponentFixture(@Nonnull Class<ComponentFixture> selfType, @Nonnull Robot robot, @Nonnull Component target) {
      super(selfType, robot, target);
    }

    @Override
    protected @Nonnull ComponentDriver createDriver(@Nonnull Robot robot) {
      return new ComponentDriver(robot);
    }
  }
}
