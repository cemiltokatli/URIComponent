package com.cemiltokatli.uricomponent;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            Map<String, String> nonEncodedChars = Collections.unmodifiableMap(Stream.of(
                    new SimpleEntry<>("~", "%7E"),
                    new SimpleEntry<>("!", "%21"),
                    new SimpleEntry<>("(", "%28"),
                    new SimpleEntry<>(")", "%29"),
                    new SimpleEntry<>("\'", "%27"))
                    .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue)));
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

    /**
     * Decodes the given component.
     *
     * @param component Component string to be decoded
     * @return the decoded component
     */
    public static String decode(String component){
        try{
            String decodedComponent = URLDecoder.decode(component, "utf-8");
            return decodedComponent;
        }
        catch(UnsupportedEncodingException e){
            return component;
        }
    }
}
