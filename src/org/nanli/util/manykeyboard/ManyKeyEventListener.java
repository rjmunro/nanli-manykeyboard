package org.nanli.util.manykeyboard;

import java.util.EventListener;

/**
 * Created with IntelliJ IDEA.
 * User: nanli
 * Date: 5/24/13
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ManyKeyEventListener extends EventListener
{
    public void manyKeyEvent(ManyKeyEvent event);
}
