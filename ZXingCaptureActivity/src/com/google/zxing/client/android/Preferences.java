package com.google.zxing.client.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
	private static final String KEY_DECODE_1D = "preferences_decode_1D";
	private static final String KEY_DECODE_QR = "preferences_decode_QR";
	private static final String KEY_DECODE_DATA_MATRIX = "preferences_decode_Data_Matrix";
	private static final String KEY_CUSTOM_PRODUCT_SEARCH = "preferences_custom_product_search";

	private static final String KEY_PLAY_BEEP = "preferences_play_beep";
	private static final String KEY_VIBRATE = "preferences_vibrate";
	private static final String KEY_COPY_TO_CLIPBOARD = "preferences_copy_to_clipboard";
	private static final String KEY_FRONT_LIGHT_MODE = "preferences_front_light_mode";
	private static final String KEY_BULK_MODE = "preferences_bulk_mode";
//	private static final String KEY_SUPPLEMENTAL = "preferences_supplemental";
	private static final String KEY_AUTO_FOCUS = "preferences_auto_focus";
	private static final String KEY_INVERT_SCAN = "preferences_invert_scan";  
	private static final String KEY_SEARCH_COUNTRY = "preferences_search_country";

	private static final String KEY_DISABLE_CONTINUOUS_FOCUS = "preferences_disable_continuous_focus";
	//private static final String KEY_DISABLE_EXPOSURE = "preferences_disable_exposure";

//	private static final String KEY_HELP_VERSION_SHOWN = "preferences_help_version_shown";

  public static boolean decode_1d = false;
  public static boolean decode_qr = false;
  public static String custom_product_search = "";
  public static boolean decode_Data_Matrix = false; 

  public static boolean play_beep = true;
  public static boolean vibrate = true;
  public static boolean copy_to_clipboard = true;
  public static String front_light_mode = null;
  public static boolean bulk_mode = false;
  public static boolean auto_focus = true;
  public static boolean invert_scan = false;
  public static String search_country = null;

  public static boolean disable_continuous_focus = false;
  
  public static int google_shopper_icon = android.R.drawable.ic_dialog_alert;
  
  private static boolean _loaded = false;
  
  public static void preload(Context context) {
    if (!_loaded) {
      load(context);
    }
  }
  
  public static void load(Context context) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

    decode_1d = prefs.getBoolean(KEY_DECODE_1D, false);
    decode_qr = prefs.getBoolean(KEY_DECODE_QR, false);
    custom_product_search = prefs.getString(KEY_CUSTOM_PRODUCT_SEARCH, "");
    decode_Data_Matrix = prefs.getBoolean(KEY_DECODE_DATA_MATRIX, false);

    play_beep = prefs.getBoolean(KEY_PLAY_BEEP, true);
    vibrate = prefs.getBoolean(KEY_VIBRATE, true);
    copy_to_clipboard = prefs.getBoolean(KEY_COPY_TO_CLIPBOARD, true);
    front_light_mode = prefs.getString(KEY_FRONT_LIGHT_MODE, "");
    bulk_mode = prefs.getBoolean(KEY_BULK_MODE, false);
    auto_focus = prefs.getBoolean(KEY_AUTO_FOCUS, true);
    invert_scan = prefs.getBoolean(KEY_INVERT_SCAN, false);
    search_country = prefs.getString(KEY_SEARCH_COUNTRY, "");

    disable_continuous_focus = prefs.getBoolean(KEY_DISABLE_CONTINUOUS_FOCUS, false);
    
    _loaded = true;
  }
}
