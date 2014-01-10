package org.tq.jackson;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The Example of maps, with reserved field called _cached, other fields could be any
 * <key,value> pair.
 */
public class JsonExample extends LinkedHashMap<String, Object> implements JsonObject {

    public static final String KEY_CACHE = "_cached";

    @JsonIgnore
    private Boolean cached;


    @Override
    public synchronized Object put(String key, Object value) {
        Object previous = null;
        if (key != null) {
            previous = this.get(key);
            if (key.equals(KEY_CACHE)) {
                Boolean cached = null;
                if ((value != null) && (value instanceof Boolean)) {
                    cached = (Boolean) value;
                }
                this.setCached(cached);
            } else if (value == null) {
                this.remove(key);
            } else {
                super.put(key, value);
            }
        }
        return previous;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> map)
    {
        if (map != null)
        {
            // use the overridden put method on each map entry
            for (java.util.Map.Entry<? extends String, ? extends Object> entry : map.entrySet())
            {
                this.put(entry.getKey(), entry.getValue());
            }
        }
    }


    public void setCached(Boolean cached) {

        this.remove(KEY_CACHE);
        this.cached = cached;
        if (cached != null)
        {
            super.put(KEY_CACHE, cached);
        }
    }

    public Boolean getCached() {
        return cached;
    }
}
