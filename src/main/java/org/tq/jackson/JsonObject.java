package org.tq.jackson;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * Created by tongqingqiu on 1/10/14.
 *
 * JsonObject interface, null will not show in the JSON
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public interface JsonObject
        extends Serializable
{

}
