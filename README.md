# README

> 自定义的密码输入框

### 效果：

![效果1](https://github.com/genius-ye/PasswordView_library/blob/master/device-2016-03-18-121934.png?raw=true)
![效果2](https://github.com/genius-ye/PasswordView_library/blob/master/device-2016-03-18-122010.png?raw=true)

### 部分api：

```java
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
 ```
 
#### 使用：
 
```xml
    <com.genius.passwordview_library.view.Password_EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/view"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true"/>
 ```
