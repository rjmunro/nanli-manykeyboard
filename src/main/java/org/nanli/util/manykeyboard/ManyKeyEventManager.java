package org.nanli.util.manykeyboard;

import java.util.HashMap;
import java.util.HashSet;

/**  ManyKeyboard - Enabling MultipleKeyboard on a Single PC
 *  ManyKeyEventManager.java
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

public class ManyKeyEventManager
{
    public static HashMap<Integer,String> keyMap = new HashMap<Integer, String>();
    public static HashMap<Integer,String> modifiedKeyMap = new HashMap<Integer, String>();

    public static HashMap<Integer,HashSet<Integer>> deviceKeysPressedHashMap = new HashMap<Integer,HashSet<Integer>>();

    public static void createDeviceKeyPressedHashMap(int deviceID)
    {
        deviceKeysPressedHashMap.put(deviceID,new HashSet<Integer>());
    }

    public static String getKeyString(int keyboardID, int keyCode)
    {
        return keyMap.get(keyCode);
        /*HashSet<Integer> simPressedKeys = deviceKeysPressedHashMap.get(keyboardID);
        if(simPressedKeys.size()==1)
        {
            return keyMap.get(keyCode);

        }else if(simPressedKeys.size()==2)
        {
            if(simPressedKeys.contains(ManyKeyEvent.MK_LeftControl) && simPressedKeys.contains(ManyKeyEvent.MK_RightControl))
            {
                return "";
            }
            else if(simPressedKeys.contains(ManyKeyEvent.MK_LeftControl) || simPressedKeys.contains(ManyKeyEvent.MK_RightControl))
            {
                for(int key : simPressedKeys)
                {
                    if(key!=ManyKeyEvent.MK_LeftControl && key!=ManyKeyEvent.MK_RightControl) //a key other than Control
                    {
                        return modifiedKeyMap.get(key);
                    }
                }

            }

        }else //>=3
        {
           return "";
        }

        return ""; */
    }

    public static void createMappings()
    {
        keyMap.put(ManyKeyEvent.MK_A,"a");
        keyMap.put(ManyKeyEvent.MK_B,"b");
        keyMap.put(ManyKeyEvent.MK_C,"c");
        keyMap.put(ManyKeyEvent.MK_D,"d");
        keyMap.put(ManyKeyEvent.MK_E,"e");
        keyMap.put(ManyKeyEvent.MK_F,"f");
        keyMap.put(ManyKeyEvent.MK_G,"g");
        keyMap.put(ManyKeyEvent.MK_H,"h");
        keyMap.put(ManyKeyEvent.MK_I,"i");
        keyMap.put(ManyKeyEvent.MK_J,"j");
        keyMap.put(ManyKeyEvent.MK_K,"k");
        keyMap.put(ManyKeyEvent.MK_L,"l");
        keyMap.put(ManyKeyEvent.MK_M,"m");
        keyMap.put(ManyKeyEvent.MK_N,"n");
        keyMap.put(ManyKeyEvent.MK_O,"o");
        keyMap.put(ManyKeyEvent.MK_P,"p");
        keyMap.put(ManyKeyEvent.MK_Q,"q");
        keyMap.put(ManyKeyEvent.MK_R,"r");
        keyMap.put(ManyKeyEvent.MK_S,"s");
        keyMap.put(ManyKeyEvent.MK_T,"t");
        keyMap.put(ManyKeyEvent.MK_U,"u");
        keyMap.put(ManyKeyEvent.MK_V,"v");
        keyMap.put(ManyKeyEvent.MK_W,"w");
        keyMap.put(ManyKeyEvent.MK_X,"x");
        keyMap.put(ManyKeyEvent.MK_Y,"y");
        keyMap.put(ManyKeyEvent.MK_Z,"z");
        keyMap.put(ManyKeyEvent.MK_1,"1");
        keyMap.put(ManyKeyEvent.MK_2,"2");
        keyMap.put(ManyKeyEvent.MK_3,"3");
        keyMap.put(ManyKeyEvent.MK_4,"4");
        keyMap.put(ManyKeyEvent.MK_5,"5");
        keyMap.put(ManyKeyEvent.MK_6,"6");
        keyMap.put(ManyKeyEvent.MK_7,"7");
        keyMap.put(ManyKeyEvent.MK_8,"8");
        keyMap.put(ManyKeyEvent.MK_9,"9");
        keyMap.put(ManyKeyEvent.MK_0,"0");
        keyMap.put(ManyKeyEvent.MK_Spacebar," ");
        keyMap.put(ManyKeyEvent.MK_Hyphen,"-");
        keyMap.put(ManyKeyEvent.MK_EqualSign,"=");
        keyMap.put(ManyKeyEvent.MK_OpenBracket,"[");
        keyMap.put(ManyKeyEvent.MK_CloseBracket,"]");
        keyMap.put(ManyKeyEvent.MK_Backslash,"\\");
        keyMap.put(ManyKeyEvent.MK_Semicolon,";");
        keyMap.put(ManyKeyEvent.MK_Quote,"\'");
        keyMap.put(ManyKeyEvent.MK_GraveAccentAndTilde,"`");
        keyMap.put(ManyKeyEvent.MK_Comma,",");
        keyMap.put(ManyKeyEvent.MK_Period,".");
        keyMap.put(ManyKeyEvent.MK_Slash,"/");

        keyMap.put(ManyKeyEvent.MKPad_Slash,"/");
        keyMap.put(ManyKeyEvent.MKPad_Asterisk,"*");
        keyMap.put(ManyKeyEvent.MKPad_Hyphen,"-");
        keyMap.put(ManyKeyEvent.MKPad_Plus,"+");

        keyMap.put(ManyKeyEvent.MKPad_1,"1");
        keyMap.put(ManyKeyEvent.MKPad_2,"2");
        keyMap.put(ManyKeyEvent.MKPad_3,"3");
        keyMap.put(ManyKeyEvent.MKPad_4,"4");
        keyMap.put(ManyKeyEvent.MKPad_5,"5");
        keyMap.put(ManyKeyEvent.MKPad_6,"6");
        keyMap.put(ManyKeyEvent.MKPad_7,"7");
        keyMap.put(ManyKeyEvent.MKPad_8,"8");
        keyMap.put(ManyKeyEvent.MKPad_9,"9");
        keyMap.put(ManyKeyEvent.MKPad_0,"0");
        keyMap.put(ManyKeyEvent.MKPad_Period,".");
        keyMap.put(ManyKeyEvent.MKPad_Comma,",");


        keyMap.put(ManyKeyEvent.MK_LeftControl,"L_CONTROL");
        keyMap.put(ManyKeyEvent.MK_LeftShift,"L_SHIFT");
        keyMap.put(ManyKeyEvent.MK_LeftAlt,"L_ALT");
        keyMap.put(ManyKeyEvent.MK_LeftGUI,"L_GUI");
        keyMap.put(ManyKeyEvent.MK_RightControl,"R_CONTROL");
        keyMap.put(ManyKeyEvent.MK_RightShift,"R_SHIFT");
        keyMap.put(ManyKeyEvent.MK_RightAlt,"R_ALT");
        keyMap.put(ManyKeyEvent.MK_RightGUI,"R_GUI");


        modifiedKeyMap.put(ManyKeyEvent.MK_A,"A");
        modifiedKeyMap.put(ManyKeyEvent.MK_B,"B");
        modifiedKeyMap.put(ManyKeyEvent.MK_C,"C");
        modifiedKeyMap.put(ManyKeyEvent.MK_D,"D");
        modifiedKeyMap.put(ManyKeyEvent.MK_E,"E");
        modifiedKeyMap.put(ManyKeyEvent.MK_F,"F");
        modifiedKeyMap.put(ManyKeyEvent.MK_G,"G");
        modifiedKeyMap.put(ManyKeyEvent.MK_H,"H");
        modifiedKeyMap.put(ManyKeyEvent.MK_I,"I");
        modifiedKeyMap.put(ManyKeyEvent.MK_J,"J");
        modifiedKeyMap.put(ManyKeyEvent.MK_K,"K");
        modifiedKeyMap.put(ManyKeyEvent.MK_L,"L");
        modifiedKeyMap.put(ManyKeyEvent.MK_M,"M");
        modifiedKeyMap.put(ManyKeyEvent.MK_N,"N");
        modifiedKeyMap.put(ManyKeyEvent.MK_O,"O");
        modifiedKeyMap.put(ManyKeyEvent.MK_P,"P");
        modifiedKeyMap.put(ManyKeyEvent.MK_Q,"Q");
        modifiedKeyMap.put(ManyKeyEvent.MK_R,"R");
        modifiedKeyMap.put(ManyKeyEvent.MK_S,"S");
        modifiedKeyMap.put(ManyKeyEvent.MK_T,"T");
        modifiedKeyMap.put(ManyKeyEvent.MK_U,"U");
        modifiedKeyMap.put(ManyKeyEvent.MK_V,"V");
        modifiedKeyMap.put(ManyKeyEvent.MK_W,"W");
        modifiedKeyMap.put(ManyKeyEvent.MK_X,"X");
        modifiedKeyMap.put(ManyKeyEvent.MK_Y,"Y");
        modifiedKeyMap.put(ManyKeyEvent.MK_Z,"Z");
        modifiedKeyMap.put(ManyKeyEvent.MK_1,"!");
        modifiedKeyMap.put(ManyKeyEvent.MK_2,"@");
        modifiedKeyMap.put(ManyKeyEvent.MK_3,"#");
        modifiedKeyMap.put(ManyKeyEvent.MK_4,"$");
        modifiedKeyMap.put(ManyKeyEvent.MK_5,"%");
        modifiedKeyMap.put(ManyKeyEvent.MK_6,"^");
        modifiedKeyMap.put(ManyKeyEvent.MK_7,"&");
        modifiedKeyMap.put(ManyKeyEvent.MK_8,"*");
        modifiedKeyMap.put(ManyKeyEvent.MK_9,"(");
        modifiedKeyMap.put(ManyKeyEvent.MK_0,")");
        modifiedKeyMap.put(ManyKeyEvent.MK_Hyphen,"_");
        modifiedKeyMap.put(ManyKeyEvent.MK_EqualSign,"+");
        modifiedKeyMap.put(ManyKeyEvent.MK_OpenBracket,"{");
        modifiedKeyMap.put(ManyKeyEvent.MK_CloseBracket,"}");
        modifiedKeyMap.put(ManyKeyEvent.MK_Backslash,"|");
        modifiedKeyMap.put(ManyKeyEvent.MK_Semicolon,":");
        modifiedKeyMap.put(ManyKeyEvent.MK_Quote,"\"");
        modifiedKeyMap.put(ManyKeyEvent.MK_GraveAccentAndTilde,"~");
        modifiedKeyMap.put(ManyKeyEvent.MK_Comma,"<");
        modifiedKeyMap.put(ManyKeyEvent.MK_Period,">");
        modifiedKeyMap.put(ManyKeyEvent.MK_Slash,"?");

        /*
        modifiedKeyMap.put(ManyKeyEvent.MKPad_Slash,"/");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_Asterisk,"*");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_Hyphen,"-");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_Plus,"+");

        modifiedKeyMap.put(ManyKeyEvent.MKPad_1,"1");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_2,"2");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_3,"3");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_4,"4");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_5,"5");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_6,"6");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_7,"7");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_8,"8");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_9,"9");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_0,"0");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_Period,".");
        modifiedKeyMap.put(ManyKeyEvent.MKPad_Comma,",");  */
    }
}
