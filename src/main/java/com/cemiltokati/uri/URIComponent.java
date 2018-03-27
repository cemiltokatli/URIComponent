package com.cemiltokati.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Provides methods for encoding or decoding URI components.
 */
public abstract class URIComponent {

    /**
     * Encodes the given component.
     *
     * @param component Component string to be encoded
     * @return the encoded component
     */
    public static String encode(String component){
        try{
            String encodedComponent = URLEncoder.encode(component, "utf-8");
            Map<String, String> nonEncodedChars = Map.of("~", "%7E", "!","%21","(","%28",")","%29","\'","%27");
            for(Map.Entry<String, String> c : nonEncodedChars.entrySet()){
                encodedComponent = encodedComponent.replaceAll(c.getValue(), c.getKey());
            }
            encodedComponent = encodedComponent.replaceAll("\\+","%20");

            return encodedComponent;
        }
        catch(UnsupportedEncodingException e){
            return component;
        }
    }
}
