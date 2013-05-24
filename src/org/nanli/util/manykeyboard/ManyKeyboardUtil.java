package org.nanli.util.manykeyboard;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: nanli
 * Date: 5/24/13
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManyKeyboardUtil
{
    public static HashSet getSubtraction(HashSet coll1, HashSet coll2)
    {
        HashSet result = new HashSet(coll1);
        result.removeAll(coll2);
        return result;
    }
}
