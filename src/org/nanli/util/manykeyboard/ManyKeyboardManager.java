package org.nanli.util.manykeyboard;

/**  ManyKeyboard - Enabling MultipleKeyboard on a Single PC
 *  ManyKeyboardManager.java
 *
 *  Copyright (c) 2013, Nan Li
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are
 *  met:
 *  * Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *  * Neither the name of Sirikata nor the names of its contributors may
 *    be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.IOException;
import java.util.*;

import com.codeminders.hidapi.ClassPathLibraryLoader;
import com.codeminders.hidapi.HIDDevice;
import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDManager;

public enum ManyKeyboardManager
{
    INSTANCE;

    private static final int BUFSIZE = 2048;

    private static Vector<HIDDevice> hidDevices = new Vector<HIDDevice>();
    private static Vector<HIDDeviceInfo> hidDeviceInfos = new Vector<HIDDeviceInfo>();
    private static HashMap<HIDDevice,Integer> hidDeviceIDHashMap = new HashMap<HIDDevice, Integer>();

    private static HashMap<HIDDevice,byte[]> deviceBufferHashMap = new HashMap<HIDDevice, byte[]>();
    private static HashMap<HIDDevice,Integer> deviceControlFlagHashMap = new HashMap<HIDDevice, Integer>();  //the control flag
    private static HashMap<HIDDevice,HashSet<Integer>> deviceKeyFlagHashMap = new HashMap<HIDDevice, HashSet<Integer>>();   // the rest key flags

    private Collection listeners;

    /**
    * Load javahidlib and create key mappings
    * */
    public void initializeLibrary()
    {
        ClassPathLibraryLoader.loadNativeHIDLibrary();
        ManyKeyEventManager.createMappings();
    }

    /**
     * Get IO of the keyboard devices connected to the computer
     * */
    public void getKeyboardDevices()
    {
        String property = System.getProperty("java.library.path");

        try
        {
            HIDManager manager = HIDManager.getInstance();
            HIDDeviceInfo[] deviceInfos = manager.listDevices();
            for(int i=0;i<deviceInfos.length;i++)
            {
                //usage page =1 (generic desktop device) and usage = 6 (keyboard, and 7 is keypad), this is keyboard
                if(deviceInfos[i].getUsage_page()==1 && deviceInfos[i].getUsage()==6)
                {
                    hidDeviceInfos.add(deviceInfos[i]);
                }
            }
            System.gc();
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     *  Close the IO of the keyboard devices connected to the computer
     * */
    public void closeKeyboardDevices()
    {
        //close devices
        for(HIDDevice hidDevice : hidDevices)
        {
            try
            {
                hidDevice.close();
                HIDManager.getInstance().release();
                System.gc();


            }catch (IOException e)
            {
                System.out.println(e);
            }

        }
    }

    /**
     * Open the IO input from the keyboard devices
     * */
    public void openKeyboardDevices(boolean blocking)
    {
        int id = 0;

        //open devices
        for(HIDDeviceInfo hidDeviceInfo : hidDeviceInfos)
        {
            try
            {
                HIDDevice hidDevice = HIDManager.getInstance().openByPath(hidDeviceInfo.getPath());
                hidDevices.add(hidDevice);

                hidDeviceIDHashMap.put(hidDevice,id);

                if(blocking)
                {
                    hidDevice.enableBlocking();

                }else
                {
                    hidDevice.disableBlocking();
                }


                //this is for reading real time buffer
                deviceBufferHashMap.put(hidDevice,new byte[BUFSIZE]);

                deviceControlFlagHashMap.put(hidDevice,0); //default 0
                HashSet<Integer> flagSet = new HashSet<Integer>();
                flagSet.add(0);
                deviceKeyFlagHashMap.put(hidDevice,flagSet);// default is a set with only 0

                //add one hashmap for each device, keeping track of the pressed keys
                ManyKeyEventManager.createDeviceKeyPressedHashMap(id);

            }catch (IOException e)
            {
                System.out.println(e);
            }

            id++;

        }

    }


    /**
     * Read the IO input reports from the keyboard devices
     * */
    public void readKeyboardDevices()
    {
        while(true)
        {
            for(HIDDevice hidDevice : hidDevices)
            {
                try
                {
                    //the byte array is called input report,which only works when there is an input event;
                    // n is the number of bytes
                    int n = hidDevice.read(deviceBufferHashMap.get(hidDevice));

                    if(n!=0) //sometimes n=0, resulting in the periphiral keyboard always clear the hashset
                    {
                        byte[] buffer = deviceBufferHashMap.get(hidDevice);

                        HashSet<Integer> currentSet = new HashSet<Integer>();
                        int currentControl = 0;

                        if(n==8) //mostly 8
                        {
                            for(int i=0; i<n; i++)
                            {
                                int current = buffer[i];

                                if(current<0)
                                {
                                    current = current + 256;
                                }

                                if(i!=0)
                                {
                                    currentSet.add(current);
                                }else //the control flag
                                {
                                    currentControl = current;
                                }

                            }



                        }else if(n==10) // macbook keyboard 10
                        {
                            for(int i=0; i<n; i++)
                            {
                                if(i!=0 && i!=9)
                                {
                                    int current = buffer[i];

                                    if(current<0)
                                    {
                                        current = current + 256;
                                    }

                                    if(i!=1)
                                    {
                                        currentSet.add(current);
                                    }else  //the control flag
                                    {
                                        currentControl = current;
                                    }
                                }
                            }

                        }else
                        {
                            if(n!=0)
                                System.err.println("other than 8 or 10: " + n);
                        }


                        //if no one listens, then return
                        if (listeners == null)
                            return;

                        //if not return, someone is listening, we process with the following code

                        //measure the diff between current flag and last flag
                        int lastFlag = deviceControlFlagHashMap.get(hidDevice);
                        int diff = currentControl - lastFlag;

                        if(diff>0) // more keys are pressed
                        {
                            //note that 1,2,4,8,16,32,64,128, these digits are 2^n, so we can judge which one is pressed with Binary number
                            int i = 0;
                            char[] digits = Integer.toBinaryString(diff).toCharArray();
                            for(char digit : digits)
                            {
                                if(digit == '1')
                                {
                                    int power = digits.length-1-i;
                                    ManyKeyEvent event = new ManyKeyEvent(this, hidDeviceIDHashMap.get(hidDevice),ManyKeyEvent.KEY_PRESSED,-(int)Math.pow(2,power));
                                    //System.err.println((int)Math.pow(2,power));
                                    notifyListeners(event);
                                }
                                i++;
                            }

                            deviceControlFlagHashMap.put(hidDevice,currentControl);

                        }else if(diff < 0) // some keys are released
                        {
                            int i = 0;
                            char[] digits = Integer.toBinaryString(-diff).toCharArray();
                            for(char digit : digits)
                            {
                                if(digit == '1')
                                {
                                    int power = digits.length-1-i;
                                    ManyKeyEvent event = new ManyKeyEvent(this, hidDeviceIDHashMap.get(hidDevice),ManyKeyEvent.KEY_RELEASED,-(int)Math.pow(2,power));
                                    //System.err.println((int)Math.pow(2,power));
                                    notifyListeners(event);
                                }
                                i++;
                            }

                            deviceControlFlagHashMap.put(hidDevice,currentControl);
                        }


                        //measure the diff between current key flags and last key flags
                        HashSet<Integer> lastSet = deviceKeyFlagHashMap.get(hidDevice);

                        HashSet<Integer> newKeySet = ManyKeyboardUtil.getSubtraction(currentSet,lastSet);
                        HashSet<Integer> removedKeySet = ManyKeyboardUtil.getSubtraction(lastSet,currentSet);

                        if(newKeySet.size()!=0) //new key pressed
                        {
                            for(Integer key : newKeySet)
                            {
                                ManyKeyEvent event = new ManyKeyEvent(this, hidDeviceIDHashMap.get(hidDevice),ManyKeyEvent.KEY_PRESSED,key);
                                notifyListeners(event);
                            }
                        }

                        if(removedKeySet.size()!=0)  // key released
                        {
                            for(Integer key : removedKeySet)
                            {
                                ManyKeyEvent event = new ManyKeyEvent(this, hidDeviceIDHashMap.get(hidDevice),ManyKeyEvent.KEY_RELEASED,key);
                                notifyListeners(event);
                            }
                        }


                        deviceKeyFlagHashMap.put(hidDevice,currentSet);


                    }


                }catch (IOException e)
                {
                    System.out.println(e);
                }
            }
        }

    }

    /**
     * Print IO input reports of the connected keyboards
     * */
    public static void printReports()
    {
        //open devices
        for(HIDDeviceInfo hidDeviceInfo : hidDeviceInfos)
        {
            try
            {
                HIDDevice hidDevice = HIDManager.getInstance().openByPath(hidDeviceInfo.getPath());

                hidDevices.add(hidDevice);
                //hidDevice.enableBlocking();
                hidDevice.disableBlocking();

                //this is for reading real time one
                deviceBufferHashMap.put(hidDevice,new byte[BUFSIZE]);

                HashSet<Integer> flagSet = new HashSet<Integer>();
                flagSet.add(0);
                deviceControlFlagHashMap.put(hidDevice,0); //default 0
                deviceKeyFlagHashMap.put(hidDevice,flagSet);// default is a set with only 0

            }catch (IOException e)
            {
                System.out.println(e);
            }

        }

        //the following code is for outputing each byte array (input report)
        while(true)
        {
            for(HIDDevice hidDevice : hidDevices)
            {
                try
                {
                    int n = hidDevice.read(deviceBufferHashMap.get(hidDevice));

                    for(int i=0; i<n; i++)
                    {
                        int v = deviceBufferHashMap.get(hidDevice)[i];

                        if (v<0) v = v+256;
                           String hs = Integer.toHexString(v);
                        //int hs = v;

                        if (v<16)  //this is just for formating,to make each byte of two digits
                           System.err.print("0");

                        System.err.print(hs + " ");
                    }

                    System.err.println("");


                }catch (IOException e)
                {
                    System.err.println(e);
                }
            }
        }
    }

    public void addManyKeyEventListener(ManyKeyEventListener listener)
    {
        if(listeners == null)
        {
            listeners = new HashSet();
        }

        listeners.add(listener);
    }

    public void removeManyKeyEventListener(ManyKeyEventListener listener)
    {
        if(listeners == null)
        {
            return;
        }

        listeners.remove(listener);
    }

    public void notifyListeners(ManyKeyEvent event)
    {
        Iterator iter = listeners.iterator();
        while(iter.hasNext())
        {
            ManyKeyEventListener listener = (ManyKeyEventListener) iter.next();
            listener.manyKeyEvent(event);

        }
    }

}
