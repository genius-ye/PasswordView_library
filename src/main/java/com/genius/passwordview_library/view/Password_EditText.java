package com.genius.passwordview_library.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.genius.passwordview_library.R;


/**
 * Created on 2016/3/18.
 * <p/>
 * author : genius-ye
 */
public class Password_EditText extends EditText {

    private static final String TAG = "Clear_EditText";
    /**
     * 右侧的眼睛按钮
     **/
    private Drawable mClearDrawable;
    /**
     * 手指点击的宽度(可修改后改变触摸灵敏度)
     **/
    private int mWidth = 20;
    /**
     * 是否显示密码
     **/
    private boolean isHidden = true;

    /**
     * 右侧的眼睛
     **/
    private Drawable eye;
    private Drawable eye_close;

    public Password_EditText(Context context) {
        super(context);
        init();
    }

    public Password_EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Password_EditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        // 获取EditText的DrawableRight,假如没有设置我们就使用默认的图片,获取图片的顺序是左上右下（0,1,2,3,）
//        mClearDrawable = getCompoundDrawables()[2];
//        Log.d(TAG, "mClearDrawable = " + mClearDrawable);
        if (mClearDrawable == null) {
//            mClearDrawable = getResources().getDrawable(R.mipmap.password_edittext_normal);
//            mClearDrawable = ContextCompat.getDrawable(getContext(), R.mipmap.password_edittext_normal).mutate();
            eye = ContextCompat.getDrawable(getContext(), R.mipmap.password_edittext_normal).mutate();
            eye_close = ContextCompat.getDrawable(getContext(), R.mipmap.password_edittext_press).mutate();
        }
//        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());
        setPasswordIcon(isHidden);
        //设置EditText文本为隐藏的
        if (isHidden)
        {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {
                int x = (int) event.getX();
//                Log.d(TAG, "x = " + x);
//                Log.d(TAG, "getCompoundDrawables()[2].getBounds().width()" + getCompoundDrawables()[2].getBounds().width());
                int distance = getWidth() - getCompoundDrawables()[2].getBounds().width();
//                Log.d(TAG, "distance = " + distance);
                // 减去手指的宽度
                if (x > distance - mWidth) {
                    if (isHidden) {
                        //设置EditText文本为可见的
                        setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        //设置EditText文本为隐藏的
                        setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    isHidden = !isHidden;
                    setPasswordIcon(isHidden);
                    setSelection(getText().toString().length());
                }
            }
        }

        return super.onTouchEvent(event);
    }

    /**
     * 设置眼睛可见或不可见，调用setCompoundDrawablesWithIntrinsicBounds为EditText绘制上去
     *
     * @param isHidden
     */
    protected void setPasswordIcon(boolean isHidden) {
        if (isHidden) {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], eye_close, getCompoundDrawables()[3]);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], eye, getCompoundDrawables()[3]);
        }
        //使用该方法会出现图标无法显示问题，原因还未找到
//        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], mClearDrawable, getCompoundDrawables()[3]);
    }

    public Drawable getEye() {
        return eye;
    }

    /**
     * 右侧的眼睛
     *
     * @param eye
     */
    public void setEye(Drawable eye) {
        this.eye = eye;
    }

    /**
     * 右侧的眼睛
     *
     * @param resourceID
     */
    public void setEye(int resourceID) {
        this.eye = ContextCompat.getDrawable(getContext(), resourceID).mutate();
    }

    public Drawable getEye_close() {
        return eye_close;
    }

    /**
     * 右侧的眼睛(不可见)
     *
     * @param eye_close
     */
    public void setEye_close(Drawable eye_close) {
        this.eye_close = eye_close;
    }

    /**
     * 右侧的眼睛(不可见)
     *
     * @param resourceID
     */
    public void setEye_close(int resourceID) {
        this.eye_close = ContextCompat.getDrawable(getContext(), resourceID).mutate();
    }

    /**
     * 初始化时设置是否显示密码
     *
     * @param isHidden
     */
    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * 手指点击的宽度(可修改后改变触摸灵敏度)
     *
     * @param mWidth
     */
    public void setmWidth(int mWidth) {
        this.mWidth = mWidth;
    }
}
