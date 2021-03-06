/*
 * Licensed to OpenCore GmbH & Co. KG under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional information regarding copyright ownership.
 * OpenCore GmbH & Co. KG licenses this file to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.opencore.gdpdu.data;

import java.util.List;

import com.opencore.gdpdu.common.exceptions.ParsingException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GdpduDataParserTest {

  @Test
  void testParsing() throws ParsingException {
    List<TestModel> models = GdpduDataParser.parseTable("src/test/resources/data1/index.xml", "Testdatei Nr. 1", TestModel.class);

    assertNotNull(models);
    assertEquals(2, models.size());

    TestModel testModel = models.get(0);
    assertEquals("foo", testModel.getFoo());
    assertEquals(10, testModel.getBar());
  }

  @Test
  void testParsing2() throws ParsingException {
    List<TestModel2> models = GdpduDataParser.parseTable("src/test/resources/data2/index.xml", "Testdatei Nr. 1", TestModel2.class);

    assertNotNull(models);
    assertEquals(3, models.size());

    TestModel2 testModel = models.get(0);
    assertEquals("A", testModel.getFoo());
    assertEquals("B", testModel.getBar());

    //assertEquals("", models.get(1).getBar());
  }
}
