
# WebviewYoutubeCrash  
Sample app to demonstrate webview crash during embedded youtube video playback
  
#### Crash stack trace:  
>W/System.err: java.lang.NullPointerException: Attempt to invoke virtual method 'int android.graphics.Bitmap.getWidth()' on a null object reference  
W/System.err:     at eq.run(chromium-TrichromeWebViewGoogle6432.aab-stable-451513134:10)  
W/System.err:     at android.os.MessageQueue.nativePollOnce(Native Method)  
W/System.err:     at android.os.MessageQueue.next(MessageQueue.java:335)  
W/System.err:     at android.os.Looper.loop(Looper.java:183)  
W/System.err:     at android.app.ActivityThread.main(ActivityThread.java:7664)  
W/System.err:     at java.lang.reflect.Method.invoke(Native Method)  
W/System.err:     at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:592)  
W/System.err:     at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:947)  
A/chromium: [FATAL:jni_android.cc(306)] Please include Java exception stack in crash report  
A/libc: Fatal signal 5 (SIGTRAP), code -6 (SI_TKILL) in tid 17596 (.webviewyoutube), pid 17596 (.webviewyoutube)

Device details:
> Pixel 5 (this problem is seen in different devices as well)
> 
> Android Version 11
> 
> Android webview version: 92.0.4515.131
