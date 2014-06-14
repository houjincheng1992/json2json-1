/**********************************************************************************************************************
 Copyright [2014] [Chunqi SHI (chunqi.shi@hotmail.com)]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 **********************************************************************************************************************/
package org.lappsgrid.json2json.jsonobject;

import java.util.Collection;

/**
 * <p>This define Proxy class of Json object ( e.g. {key_1:value_1, key_2:value_2, ..., key_m:value_m} )
 * and Json Array (e.g. [obj_1, obj_2, ..., obj_n])</p>
 */
public class JsonProxy {

    /**
     *
     */
    public static interface JsonObject {
        /** read string into jsonObject **/
        public JsonObject read(String s);
        /** write jsonObject int string **/
        public String toString();

        /** has / get / put / remove **/
        public boolean has(String key);
        public Object get(String key);
        public JsonObject put(String key, Object val);
        public JsonObject remove(String key);

        /**  length / keys **/
        public int length();
        public Collection<String> keys();

        /** if has original mapping **/
        public Object original();
    }

    public static interface JsonArray {
        /** read string into JsonArray **/
        public JsonArray read(String s);
        /** write JsonArray int string **/
        public String toString();

        /** length / get / add / insert / remove **/
        public int length();
        public Object get(int i);
        public JsonArray add(Object s);
        public JsonArray remove(int i);
        public JsonArray set(int i, Object s);

        /** directly read string array as Json Array object. **/
        public JsonArray convert(String [] arr);
        public JsonArray convert(Collection<String> arr);

        /** if has original mapping **/
        public Object original();
    }

    /** static methods for read / is / convert **/

    public static JsonArray convertArray(String [] arr) {
        return newArray().convert(arr);
    }
    public static JsonArray convertArray(Collection<String> arr) {
        return newArray().convert(arr);
    }

    public static JsonArray readArray(String s) {
        return newArray().read(s);
    }

    public static JsonObject readObject(String s) {
        return newObject().read(s);
    }

    public static boolean isArray (Object obj) {
        if (obj instanceof JsonArray) {
            return true;
        }
        return false;
    }
    public static boolean isObject (Object obj) {
        if (obj instanceof JsonObject) {
            return true;
        }
        return false;
    }

    /** fill in the proxy **/
//
//    public static JsonArray newArray() {
//        // FIXME: exchange proxy
//        return new MinimalJsonProxy.MinimalJsonArray();
//    }
//
//    public static JsonObject newObject() {
//        // FIXME: exchange proxy
//        return new MinimalJsonProxy.MinimalJsonObject();
//    }



    public static JsonArray newArray() {
        // FIXME: exchange proxy
        return new JacksonJsonProxy.JacksonJsonArray();
    }

    public static JsonObject newObject() {
        // FIXME: exchange proxy
        return new JacksonJsonProxy.JacksonJsonObject();
    }
}
