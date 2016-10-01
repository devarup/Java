/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.placement.test;

import com.placement.types.StreamType;
import java.util.Iterator;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 *
 * @author arup
 */
public class Test {

    public static void main(String[] args) {

        StreamType st[] = StreamType.values();

        for (StreamType streamType : st) {
            System.out.println("streamType "+ streamType.toString());

        }
    }
}
