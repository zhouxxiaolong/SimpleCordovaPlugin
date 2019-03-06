package com.zxl.simpleplugin;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.zxl.helloplugin.NewActivity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import static android.app.Activity.RESULT_OK;

/**
 * This class echoes a string called from JavaScript.
 */
public class SimplePlugin extends CordovaPlugin {

    private Context mContext;
    private CallbackContext mCallbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        mContext = cordova.getActivity().getApplicationContext();
        mCallbackContext = callbackContext;

        if (action.equals("startNewActivity")) {
            String message = args.getString(0);
            Toast.makeText(mContext, "传入的值为：" + message, Toast.LENGTH_LONG).show();
            this.coolMethod(message, callbackContext);
            Intent intent = new Intent(mContext, NewActivity.class);
            //！！！此处注意一定要用cordova.startActivityForResult！！！
            cordova.startActivityForResult(this, intent, 0);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (resultCode) {
            case RESULT_OK:
                mCallbackContext.success(intent.getStringExtra(NewActivity.EXTRA_STRING));
                break;

            default:
                mCallbackContext.error("返回失败！");
                break;
        }
    }
}
