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
package org.assertj.swing.image;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link ScreenshotTaker#saveImage(BufferedImage, String)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class ScreenshotTaker_saveImage_withInvalidInput_Test {
  private static final BufferedImage NO_IMAGE = null;
  private ScreenshotTaker taker;

  @Before
  public void setUp() {
    taker = new ScreenshotTaker();
  }

  @Test(expected = NullPointerException.class)
  public void should_Throw_Error_If_File_Path_Is_Null() {
    taker.saveImage(NO_IMAGE, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_Throw_Error_If_File_Path_Is_Empty_String() {
    taker.saveImage(NO_IMAGE, "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void should_Throw_Error_If_File_Path_Does_Not_End_With_Png() {
    taker.saveImage(NO_IMAGE, "somePathWithoutPng");
  }
}
