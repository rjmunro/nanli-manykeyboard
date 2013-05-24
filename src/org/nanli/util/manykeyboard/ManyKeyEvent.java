package org.nanli.util.manykeyboard;

import java.util.EventObject;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nanli
 * Date: 5/24/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ManyKeyEvent extends EventObject
{
    public static int KEY_PRESSED = "KEY_PRESSED".hashCode();
    public static int KEY_RELEASED = "KEY_RELEASED".hashCode();
    public static int MK_A	= 0x04;	/* a or A */
    public static int MK_B	= 0x05;	/* b or B */
    public static int MK_C	= 0x06;	/* c or C */
    public static int MK_D	= 0x07;	/* d or D */
    public static int MK_E	= 0x08;	/* e or E */
    public static int MK_F	= 0x09;	/* f or F */
    public static int MK_G	= 0x0A;	/* g or G */
    public static int MK_H	= 0x0B;	/* h or H */
    public static int MK_I	= 0x0C;	/* i or I */
    public static int MK_J	= 0x0D;	/* j or J */
    public static int MK_K	= 0x0E;	/* k or K */
    public static int MK_L	= 0x0F;	/* l or L */
    public static int MK_M	= 0x10;	/* m or M */
    public static int MK_N	= 0x11;	/* n or N */
    public static int MK_O	= 0x12;	/* o or O */
    public static int MK_P	= 0x13;	/* p or P */
    public static int MK_Q	= 0x14;	/* q or Q */
    public static int MK_R	= 0x15;	/* r or R */
    public static int MK_S	= 0x16;	/* s or S */
    public static int MK_T	= 0x17;	/* t or T */
    public static int MK_U	= 0x18;	/* u or U */
    public static int MK_V	= 0x19;	/* v or V */
    public static int MK_W	= 0x1A;	/* w or W */
    public static int MK_X	= 0x1B;	/* x or X */
    public static int MK_Y	= 0x1C;	/* y or Y */
    public static int MK_Z	= 0x1D;	/* z or Z */
    public static int MK_1	= 0x1E;	/* 1 or ! */
    public static int MK_2	= 0x1F;	/* 2 or @ */
    public static int MK_3	= 0x20;	/* 3 or # */
    public static int MK_4	= 0x21;	/* 4 or $ */
    public static int MK_5	= 0x22;	/* 5 or % */
    public static int MK_6	= 0x23;	/* 6 or ^ */
    public static int MK_7	= 0x24;	/* 7 or & */
    public static int MK_8	= 0x25;	/* 8 or * */
    public static int MK_9	= 0x26;	/* 9 or ( */
    public static int MK_0	= 0x27;	/* 0 or ) */
    public static int MK_ReturnOrEnter	= 0x28;	/* Return (Enter) */
    public static int MK_Escape	= 0x29;	/* Escape */
    public static int MK_DeleteOrBackspace	= 0x2A;	/* Delete (Backspace) */
    public static int MK_Tab	= 0x2B;	/* Tab */
    public static int MK_Spacebar	= 0x2C;	/* Spacebar */
    public static int MK_Hyphen	= 0x2D;	/* - or _ */
    public static int MK_EqualSign	= 0x2E;	/* = or + */
    public static int MK_OpenBracket	= 0x2F;	/* [ or { */
    public static int MK_CloseBracket	= 0x30;	/* ] or } */
    public static int MK_Backslash	= 0x31;	/* \ or | */
    public static int MK_NonUSPound	= 0x32;	/* Non-US # or _ */
    public static int MK_Semicolon	= 0x33;	/* ; or : */
    public static int MK_Quote	= 0x34;	/* ' or " */
    public static int MK_GraveAccentAndTilde	= 0x35;	/* Grave Accent and Tilde */
    public static int MK_Comma	= 0x36;	/* ; or < */
    public static int MK_Period	= 0x37;	/* . or > */
    public static int MK_Slash	= 0x38;	/* / or ? */
    public static int MK_CapsLock	= 0x39;	/* Caps Lock */
    public static int MK_F1	= 0x3A;	/* F1 */
    public static int MK_F2	= 0x3B;	/* F2 */
    public static int MK_F3	= 0x3C;	/* F3 */
    public static int MK_F4	= 0x3D;	/* F4 */
    public static int MK_F5	= 0x3E;	/* F5 */
    public static int MK_F6	= 0x3F;	/* F6 */
    public static int MK_F7	= 0x40;	/* F7 */
    public static int MK_F8	= 0x41;	/* F8 */
    public static int MK_F9	= 0x42;	/* F9 */
    public static int MK_F10	= 0x43;	/* F10 */
    public static int MK_F11	= 0x44;	/* F11 */
    public static int MK_F12	= 0x45;	/* F12 */
    public static int MK_PrintScreen	= 0x46;	/* Print Screen */
    public static int MK_ScrollLock	= 0x47;	/* Scroll Lock */
    public static int MK_Pause	= 0x48;	/* Pause */
    public static int MK_Insert	= 0x49;	/* Insert */
    public static int MK_Home	= 0x4A;	/* Home */
    public static int MK_PageUp	= 0x4B;	/* Page Up */
    public static int MK_DeleteForward	= 0x4C;	/* Delete Forward */
    public static int MK_End	= 0x4D;	/* End */
    public static int MK_PageDown	= 0x4E;	/* Page Down */
    public static int MK_RightArrow	= 0x4F;	/* Right Arrow */
    public static int MK_LeftArrow	= 0x50;	/* Left Arrow */
    public static int MK_DownArrow	= 0x51;	/* Down Arrow */
    public static int MK_UpArrow	= 0x52;	/* Up Arrow */
    public static int MKPad_NumLock	= 0x53;	/* Keypad NumLock or Clear */
    public static int MKPad_Slash	= 0x54;	/* Keypad / */
    public static int MKPad_Asterisk	= 0x55;	/* Keypad * */
    public static int MKPad_Hyphen	= 0x56;	/* Keypad - */
    public static int MKPad_Plus	= 0x57;	/* Keypad + */
    public static int MKPad_Enter	= 0x58;	/* Keypad Enter */
    public static int MKPad_1	= 0x59;	/* Keypad 1 or End */
    public static int MKPad_2	= 0x5A;	/* Keypad 2 or Down Arrow */
    public static int MKPad_3	= 0x5B;	/* Keypad 3 or Page Down */
    public static int MKPad_4	= 0x5C;	/* Keypad 4 or Left Arrow */
    public static int MKPad_5	= 0x5D;	/* Keypad 5 */
    public static int MKPad_6	= 0x5E;	/* Keypad 6 or Right Arrow */
    public static int MKPad_7	= 0x5F;	/* Keypad 7 or Home */
    public static int MKPad_8	= 0x60;	/* Keypad 8 or Up Arrow */
    public static int MKPad_9	= 0x61;	/* Keypad 9 or Page Up */
    public static int MKPad_0	= 0x62;	/* Keypad 0 or Insert */
    public static int MKPad_Period	= 0x63;	/* Keypad . or Delete */
    public static int MK_NonUSBackslash	= 0x64;	/* Non-US \ or | */
    public static int MK_Application	= 0x65;	/* Application */
    public static int MK_Power	= 0x66;	/* Power */
    public static int MKPad_EqualSign	= 0x67;	/* Keypad = */
    public static int MK_F13	= 0x68;	/* F13 */
    public static int MK_F14	= 0x69;	/* F14 */
    public static int MK_F15	= 0x6A;	/* F15 */
    public static int MK_F16	= 0x6B;	/* F16 */
    public static int MK_F17	= 0x6C;	/* F17 */
    public static int MK_F18	= 0x6D;	/* F18 */
    public static int MK_F19	= 0x6E;	/* F19 */
    public static int MK_F20	= 0x6F;	/* F20 */
    public static int MK_F21	= 0x70;	/* F21 */
    public static int MK_F22	= 0x71;	/* F22 */
    public static int MK_F23	= 0x72;	/* F23 */
    public static int MK_F24	= 0x73;	/* F24 */
    public static int MK_Execute	= 0x74;	/* Execute */
    public static int MK_Help	= 0x75;	/* Help */
    public static int MK_Menu	= 0x76;	/* Menu */
    public static int MK_Select	= 0x77;	/* Select */
    public static int MK_Stop	= 0x78;	/* Stop */
    public static int MK_Again	= 0x79;	/* Again */
    public static int MK_Undo	= 0x7A;	/* Undo */
    public static int MK_Cut	= 0x7B;	/* Cut */
    public static int MK_Copy	= 0x7C;	/* Copy */
    public static int MK_Paste	= 0x7D;	/* Paste */
    public static int MK_Find	= 0x7E;	/* Find */
    public static int MK_Mute	= 0x7F;	/* Mute */
    public static int MK_VolumeUp	= 0x80;	/* Volume Up */
    public static int MK_VolumeDown	= 0x81;	/* Volume Down */
    public static int MK_LockingCapsLock	= 0x82;	/* Locking Caps Lock */
    public static int MK_LockingNumLock	= 0x83;	/* Locking Num Lock */
    public static int MK_LockingScrollLock	= 0x84;	/* Locking Scroll Lock */
    public static int MKPad_Comma	= 0x85;	/* Keypad Comma */
    public static int MKPad_EqualSignAS400	= 0x86;	/* Keypad Equal Sign for AS/400 */
    public static int MK_International1	= 0x87;	/* International1 */
    public static int MK_International2	= 0x88;	/* International2 */
    public static int MK_International3	= 0x89;	/* International3 */
    public static int MK_International4	= 0x8A;	/* International4 */
    public static int MK_International5	= 0x8B;	/* International5 */
    public static int MK_International6	= 0x8C;	/* International6 */
    public static int MK_International7	= 0x8D;	/* International7 */
    public static int MK_International8	= 0x8E;	/* International8 */
    public static int MK_International9	= 0x8F;	/* International9 */
    public static int MK_LANG1	= 0x90;	/* LANG1 */
    public static int MK_LANG2	= 0x91;	/* LANG2 */
    public static int MK_LANG3	= 0x92;	/* LANG3 */
    public static int MK_LANG4	= 0x93;	/* LANG4 */
    public static int MK_LANG5	= 0x94;	/* LANG5 */
    public static int MK_LANG6	= 0x95;	/* LANG6 */
    public static int MK_LANG7	= 0x96;	/* LANG7 */
    public static int MK_LANG8	= 0x97;	/* LANG8 */
    public static int MK_LANG9	= 0x98;	/* LANG9 */
    public static int MK_AlternateErase	= 0x99;	/* AlternateErase */
    public static int MK_SysReqOrAttention	= 0x9A;	/* SysReq/Attention */
    public static int MK_Cancel	= 0x9B;	/* Cancel */
    public static int MK_Clear	= 0x9C;	/* Clear */
    public static int MK_Prior	= 0x9D;	/* Prior */
    public static int MK_Return	= 0x9E;	/* Return */
    public static int MK_Separator	= 0x9F;	/* Separator */
    public static int MK_Out	= 0xA0;	/* Out */
    public static int MK_Oper	= 0xA1;	/* Oper */
    public static int MK_ClearOrAgain	= 0xA2;	/* Clear/Again */
    public static int MK_CrSelOrProps	= 0xA3;	/* CrSel/Props */
    public static int MK_ExSel	= 0xA4;	/* ExSel */

    //Modifier key
    public static int MK_LeftControl	= 1;	/* Left Control */
    public static int MK_LeftShift	= 2;	/* Left Shift */
    public static int MK_LeftAlt	= 4;	/* Left Alt */
    public static int MK_LeftGUI	= 8;	/* Left GUI */
    public static int MK_RightControl	= 16;	/* Right Control */
    public static int MK_RightShift	= 32;	/* Right Shift */
    public static int MK_RightAlt	= 64;	/* Right Alt */
    public static int MK_RightGUI	= 128;	/* Right GUI */

    private int keyCode = -1;
    private int type = -1;
    private boolean isModifier;

    private HashMap<Integer,String> keyMap = new HashMap<Integer, String>();

    private HashMap<Integer,String> modifierMap = new HashMap<Integer, String>();

    private void createMappings()
    {
        keyMap.put(MK_A,"a");
        keyMap.put(MK_B,"b");
        keyMap.put(MK_C,"c");
        keyMap.put(MK_D,"c");
        keyMap.put(MK_E,"e");
        keyMap.put(MK_F,"f");
        keyMap.put(MK_G,"g");
        keyMap.put(MK_H,"h");
        keyMap.put(MK_I,"i");
        keyMap.put(MK_J,"j");
        keyMap.put(MK_K,"k");
        keyMap.put(MK_L,"l");
        keyMap.put(MK_M,"m");
        keyMap.put(MK_N,"n");
        keyMap.put(MK_O,"o");
        keyMap.put(MK_P,"p");
        keyMap.put(MK_Q,"q");
        keyMap.put(MK_R,"r");
        keyMap.put(MK_S,"s");
        keyMap.put(MK_T,"t");
        keyMap.put(MK_U,"u");
        keyMap.put(MK_V,"v");
        keyMap.put(MK_W,"w");
        keyMap.put(MK_X,"x");
        keyMap.put(MK_Y,"y");
        keyMap.put(MK_Z,"z");
        keyMap.put(MK_1,"1");
        keyMap.put(MK_2,"2");
        keyMap.put(MK_3,"3");
        keyMap.put(MK_4,"4");
        keyMap.put(MK_5,"5");
        keyMap.put(MK_6,"6");
        keyMap.put(MK_7,"7");
        keyMap.put(MK_8,"8");
        keyMap.put(MK_9,"9");
        keyMap.put(MK_0,"0");
        keyMap.put(MK_Spacebar," ");
        keyMap.put(MK_Hyphen,"-");
        keyMap.put(MK_EqualSign,"=");
        keyMap.put(MK_OpenBracket,"[");
        keyMap.put(MK_CloseBracket,"]");
        keyMap.put(MK_Backslash,"\\");
        keyMap.put(MK_Semicolon,";");
        keyMap.put(MK_Quote,"\'");
        keyMap.put(MK_GraveAccentAndTilde,"`");
        keyMap.put(MK_Comma,",");
        keyMap.put(MK_Period,".");
        keyMap.put(MK_Slash,"/");

        keyMap.put(MKPad_Slash,"/");
        keyMap.put(MKPad_Asterisk,"*");
        keyMap.put(MKPad_Hyphen,"-");
        keyMap.put(MKPad_Plus,"+");

        keyMap.put(MKPad_1,"1");
        keyMap.put(MKPad_2,"2");
        keyMap.put(MKPad_3,"3");
        keyMap.put(MKPad_4,"4");
        keyMap.put(MKPad_5,"5");
        keyMap.put(MKPad_6,"6");
        keyMap.put(MKPad_7,"7");
        keyMap.put(MKPad_8,"8");
        keyMap.put(MKPad_9,"9");
        keyMap.put(MKPad_0,"0");
        keyMap.put(MKPad_Period,".");
        keyMap.put(MKPad_Comma,",");


        modifierMap.put(MK_LeftControl,"L_CONTROL");	/* Left Control */
        modifierMap.put(MK_LeftShift,"L_SHIFT");	/* Left Shift */
        modifierMap.put(MK_LeftAlt,"L_ALT");	/* Left Alt */
        modifierMap.put(MK_LeftGUI,"L_GUI");	/* Left GUI */
        modifierMap.put(MK_RightControl,"R_CONTROL");	/* Right Control */
        modifierMap.put(MK_RightShift,"R_SHIFT");	/* Right Shift */
        modifierMap.put(MK_RightAlt,"R_ALT");	/* Right Alt */
        modifierMap.put(MK_RightGUI,"R_GUI");	/* Right GUI */

    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException
     *          if source is null.
     */
    public ManyKeyEvent(Object source,int keyboardID, int type, int keyCode, boolean isModifier)
    {
        super(source);
        this.keyCode = keyCode;
        this.type = type;
        this.isModifier = isModifier;
        createMappings();
    }

    public boolean isActionKey()
    {
        if(!isModifier)
        {
           if(!keyMap.containsKey(this.keyCode))
               return true;
           else
               return false;
        }else
        {
            return false;
        }
    }

    public boolean isModifierKey()
    {
        return isModifier;
    }

    public int getKeyCode()
    {
        return keyCode;
    }

    public String getKeystring()
    {
        if(!isModifier)
        return keyMap.get(keyCode);

        if(isModifier)
        {
            return modifierMap.get(keyCode);
        }

        else
            return null;

    }

    public String getKeyType()
    {
        if(type == KEY_PRESSED)
        {return "KEY_PRESSED";}
        else
        {return  "KEY_RELEASED";}
    }
}
