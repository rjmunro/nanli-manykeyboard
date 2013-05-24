package org.nanli.util.manykeyboard;

import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: nanli
 * Date: 5/24/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestManyKeyboard
{
    //testing the main
    public static void main(String[] args) throws IOException, InterruptedException
    {
        ManyKeyboardManager.initializeLibrary();
        ManyKeyboardManager.getKeyboardDevices();
        ManyKeyboardManager.openKeyboardDevices();
        ManyKeyboardManager.readKeyboardDevices();
        ManyKeyboardManager.closeKeyboardDevices();

    }
}
