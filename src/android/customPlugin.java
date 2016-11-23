package custom.cordova.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class customPlugin extends CordovaPlugin {

    Context context;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        context = webView.getContext();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) 
		throws JSONException {
        if (action.equals("call")) {
            this.call(args);
            return true;
        }else if (action.equals("sendSMS")) {
            this.sendSMS(args);
            return true;
        }
        return false;
    }

    /**
     * sendSMS
     * @param args
     */
    private void sendSMS(JSONArray args) {

        String phone = null;
        String message = null;
        try {
            phone = args.getJSONObject(0).getString("phone");
            message = args.getJSONObject(0).getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phone));
        intent.putExtra("sms_body", message);
        context.startActivity(intent);
    }

    /**
     * call
     * @param args
     */
    private void call(JSONArray args) {

        String phone = null;
        try {
            phone = args.getJSONObject(0).getString("phone");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + phone));
        context.startActivity(intent);
    }
}
