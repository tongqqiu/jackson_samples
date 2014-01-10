package org.tq.jackson;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tongqingqiu on 1/10/14.
 */
public class JsonMapObject<V extends Serializable>
        extends LinkedHashMap<String, V>
        implements JsonObject, Map<String, V>
{

    // TODO: the example of maps, with the same type of value

}
