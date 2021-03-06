package android.api.com.appimake.aimjsonmodelnetworking.base.core.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by nattapongr on 5/21/15.
 */
public class AIMWebView extends WebView {
    private ProgressDialog dialogLoading;
    private Context context;


    public AIMWebView(Context context) {
        super(context);
        this.context = context;
    }

    public AIMWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AIMWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AIMWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
    }

    public void loadingDialog(final String msg) {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialogLoading == null) {
                    dialogLoading = new ProgressDialog(context);
                    dialogLoading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialogLoading.setCanceledOnTouchOutside(false);
                    dialogLoading.setIndeterminate(true);
                }
                hideLoadingDialog();
                dialogLoading.setMessage(msg);
                dialogLoading.show();
            }
        });
    }

    public void hideLoadingDialog() {
        ((Activity) this.context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialogLoading != null) {
                    dialogLoading.dismiss();
                }
            }
        });
    }


    @Override
    public void invalidate() {
        super.invalidate();
        if (getContentHeight() > 0) {
            hideLoadingDialog();
        }
    }
}
