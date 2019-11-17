package inn.startXway.eatit.helper;

import android.content.Context;
import android.content.SharedPreferences;

import inn.startXway.eatit.models.User;


public class SharedPrefManager {
    private static SharedPrefManager myInstance;
    private static Context myContext;
    private static final String SHARED_PREF_VARNAME = "EATIT";
    private static final String KEY_USER_NAME = "keyusernaname";
    private static final String KEY_USER_PHONE = "keyuserphone";
    private static final String IS_INTRO = "isintro";

    private SharedPrefManager(Context context)
    {
        myContext = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context)
    {
        if (myInstance == null)
        {
            myInstance = new SharedPrefManager (context);
        }   return myInstance;

    }

    public boolean setSharedData(String uname,String uphone)
    {
        SharedPreferences sharedPreferences = myContext.getSharedPreferences(SHARED_PREF_VARNAME,Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_NAME,uname);
        editor.putString(KEY_USER_PHONE,uphone);
        editor.apply();
        return true;

    }

    public boolean setAppData(String Icheck)
    {
        SharedPreferences sharedPreferences = myContext.getSharedPreferences(SHARED_PREF_VARNAME,Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IS_INTRO,Icheck);
        editor.apply();
        return true;
    }

    public boolean checkIntro()
    {
        SharedPreferences sharedPreferences = myContext.getSharedPreferences(SHARED_PREF_VARNAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(IS_INTRO,null)!=null)
            return true;
        return false;
    }

    public User getUserdata()
    {
        SharedPreferences sharedPreferences = myContext.getSharedPreferences(SHARED_PREF_VARNAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString(KEY_USER_NAME,null),
        sharedPreferences.getString(KEY_USER_PHONE,null)
        );
    }

    public boolean checkLogin()
    {
        SharedPreferences sharedPreferences = myContext.getSharedPreferences(SHARED_PREF_VARNAME,Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USER_NAME,null)!=null)
            return true;
        return false;
    }

    public boolean userLogout()
    {
        SharedPreferences sharedPreferences = myContext.getSharedPreferences(SHARED_PREF_VARNAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;

    }


}
