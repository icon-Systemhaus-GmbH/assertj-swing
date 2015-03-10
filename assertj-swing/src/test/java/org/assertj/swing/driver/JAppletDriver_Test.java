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
package org.assertj.swing.driver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.applet.Applet;
import java.applet.AppletContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

import javax.swing.JApplet;

import org.assertj.swing.core.Robot;
import org.assertj.swing.test.core.EDTSafeTestCase;
import org.junit.Before;
import org.junit.Test;

public class JAppletDriver_Test extends EDTSafeTestCase {
  private JAppletDriver driver;
  private JApplet target;
  private Robot robot;

  @Before
  public void setUp() {
    robot = mock(Robot.class);
    target = mock(JApplet.class);
    driver = new JAppletDriver(robot, target);
  }

  @Test
  public void should_Get_Applet_Context() {
    AppletContext context = mock(AppletContext.class);
    when(target.getAppletContext()).thenReturn(context);
    assertThat(driver.getAppletContext()).isSameAs(context);
  }

  @Test
  public void should_Applet_Resize() {
    driver.appletResize(10, 10);
    verify(target).resize(10, 10);
  }

  @Test
  public void should_Get_Code_Base() throws MalformedURLException {
    URL url = new URL("http://localhost");
    when(target.getCodeBase()).thenReturn(url);
    assertThat(driver.getCodeBase()).isSameAs(url);
  }

  @Test
  public void should_Get_Document_Base() throws MalformedURLException {
    URL url = new URL("http://localhost");
    when(target.getDocumentBase()).thenReturn(url);
    assertThat(driver.getDocumentBase()).isSameAs(url);
  }

  @Test
  public void should_Get_Parameter() {
    String parameter = "parameter";
    String name = "name";
    when(target.getParameter(name)).thenReturn(parameter);
    assertThat(driver.getParameter(name)).isSameAs(parameter);
  }

  @Test
  public void is_active() {
    boolean active = true;
    when(target.isActive()).thenReturn(active);
    assertThat(driver.isActive());
  }

  @Test
  public void should_Get_Applet() {
    AppletContext context = mock(AppletContext.class);
    Applet applet = mock(Applet.class);
    String name = "applet";
    when(target.getAppletContext()).thenReturn(context);
    when(context.getApplet(name)).thenReturn(applet);
    assertThat(driver.getApplet(name)).isSameAs(applet);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void should_Get_Applets() {
    AppletContext context = mock(AppletContext.class);
    Enumeration<Applet> applets = mock(Enumeration.class);
    when(target.getAppletContext()).thenReturn(context);
    when(context.getApplets()).thenReturn(applets);
    assertThat(driver.getApplets()).isSameAs(applets);
  }
}
