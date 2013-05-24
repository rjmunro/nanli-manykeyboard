package org.nanli.util.manykeyboard;

import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: nanli
 * Date: 5/24/13
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestManyKeyboard implements ManyKeyEventListener
{

    @Override
    public void manyKeyEvent(ManyKeyEvent event)
    {
        if(!event.isActionKey())
        {
            System.err.println(event.getKeystring() + " " +event.getKeyType());
        }
    }

    //testing the main
    public static void main(String[] args) throws IOException, InterruptedException
    {
        TestManyKeyboard testManyKeyboard = new TestManyKeyboard();
        final ManyKeyboardManager keyboardManager = ManyKeyboardManager.INSTANCE;
        keyboardManager.addManyKeyEventListener(testManyKeyboard);

        new Thread()
        {
            public void run()
            {
                keyboardManager.initializeLibrary();
                keyboardManager.getKeyboardDevices();
                keyboardManager.openKeyboardDevices(false);
                keyboardManager.readKeyboardDevices();
                keyboardManager.closeKeyboardDevices();
            }
        }.start();


    }

}
