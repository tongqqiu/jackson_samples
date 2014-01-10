package org.tq.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tongqingqiu on 1/10/14.
 */
public class JsonExampleTest {



    @Test
    public void testWriteAndRead() throws Exception {
        JsonExample jsonExample = new JsonExample();
        jsonExample.setCached(true);

        jsonExample.put("field1", "String");
        jsonExample.put("field2", 19);
        List<String> listString = new ArrayList();
        listString.add("abc");
        listString.add("xyz");
        Map<String, Object> field3 = new HashMap<String, Object>();
        field3.put("field3", listString);
        jsonExample.putAll(field3);
        jsonExample.put("field4", null);       // null means not exist in the map


        ObjectMapper mapper = new ObjectMapper();
        Writer strWriter = new StringWriter();
        mapper.writerWithDefaultPrettyPrinter().writeValue(strWriter, jsonExample);
        System.out.println(strWriter.toString());

        Reader stringReader = new StringReader(strWriter.toString());

        JsonExample readBack = mapper.readValue(stringReader, JsonExample.class);
        assertThat(readBack.getCached(),is(true));
        assertThat((String)readBack.get("field1"),equalTo("String"));
        assertThat((Integer)readBack.get("field2"),equalTo(19));
        assertThat(((List<String>) readBack.get("field3")).size(), equalTo(2));
        assertFalse(readBack.containsKey("field4"));

        JsonMapObject jsonMapObject = new JsonMapObject();
    }
}
