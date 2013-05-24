package org.nanli.util.manykeyboard;

/**
 * Created with IntelliJ IDEA.
 * User: nanli
 * Date: 5/24/13
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import com.codeminders.hidapi.ClassPathLibraryLoader;
import com.codeminders.hidapi.HIDDevice;
import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDManager;

public class ManyKeyboardManager
{
    private static final int BUFSIZE = 2048;
    private static final int IRSIZE = 16;//size of input report

    private static Vector<HIDDevice> hidDevices = new Vector<HIDDevice>();
    private static Vector<HIDDeviceInfo> hidDeviceInfos = new Vector<HIDDeviceInfo>();

    private static HashMap<HIDDevice,byte[]> deviceBufferHashMap = new HashMap<HIDDevice, byte[]>();
    private static HashMap<HIDDevice,Integer> deviceControlFlagHashMap = new HashMap<HIDDevice, Integer>();  //the control flag
    private static HashMap<HIDDevice,HashSet<Integer>> deviceKeyFlagHashMap = new HashMap<HIDDevice, HashSet<Integer>>();   // the rest key flags

    /**
    * Load javahidlib
    * */
    public static void initializeLibrary()
    {
        ClassPathLibraryLoader.loadNativeHIDLibrary();
    }

    /**
     * Get IO of the keyboard devices connected to the computer
     * */
    public static void getKeyboardDevices()
    {
        String property = System.getProperty("java.library.path");
        System.err.println(property);
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
    public static void closeKeyboardDevices()
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
    public static void openKeyboardDevices()
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

    }


    /**
     * Read the IO input reports from the keyboard devices
     * */
    public static void readKeyboardDevices()
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
                        //int[] inputReport = new int[8];
                        //int[] diffInputReport = new int[8];

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


                        //measure the diff between current flag and last flag
                        int lastFlag = deviceControlFlagHashMap.get(hidDevice);
                        if((currentControl - lastFlag)!=0) // if ==0, it means nothing has changed
                        {
                            System.err.println(currentControl);

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
                                System.err.println(key + "pressed");
                            }
                        }

                        if(removedKeySet.size()!=0)  // key released
                        {
                            for(Integer key : removedKeySet)
                            {
                                System.err.println(key + "released");
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


}
