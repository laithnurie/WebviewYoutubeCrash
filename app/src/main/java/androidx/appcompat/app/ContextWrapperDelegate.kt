package androidx.appcompat.app

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.AttributeSet
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ActionMode
import androidx.appcompat.widget.Toolbar

class ContextWrapperDelegate(
    private val delegate: AppCompatDelegate,
    private val wrapper: (Context) -> Context
) : AppCompatDelegate() {

    override fun getSupportActionBar() = delegate.supportActionBar

    override fun setSupportActionBar(toolbar: Toolbar?) = delegate.setSupportActionBar(toolbar)

    override fun getMenuInflater(): MenuInflater? = delegate.menuInflater

    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.onCreate(savedInstanceState)
        removeActivityDelegate(delegate)
        addActiveDelegate(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) =
        delegate.onPostCreate(savedInstanceState)

    override fun onConfigurationChanged(newConfig: Configuration?) =
        delegate.onConfigurationChanged(newConfig)

    override fun onStart() = delegate.onStart()

    override fun onStop() = delegate.onStop()

    override fun onPostResume() = delegate.onPostResume()

    override fun setTheme(themeResId: Int) = delegate.setTheme(themeResId)

    override fun <T : View?> findViewById(id: Int) = delegate.findViewById<T>(id)

    override fun setContentView(v: View?) = delegate.setContentView(v)

    override fun setContentView(resId: Int) = delegate.setContentView(resId)

    override fun setContentView(v: View?, lp: ViewGroup.LayoutParams?) =
        delegate.setContentView(v, lp)

    override fun addContentView(v: View?, lp: ViewGroup.LayoutParams?) =
        delegate.addContentView(v, lp)

    override fun attachBaseContext2(context: Context) =
        wrapper(delegate.attachBaseContext2(super.attachBaseContext2(context)))

    override fun setTitle(title: CharSequence?) = delegate.setTitle(title)

    override fun invalidateOptionsMenu() = delegate.invalidateOptionsMenu()

    override fun onDestroy() {
        delegate.onDestroy()
        removeActivityDelegate(this)
    }

    override fun getDrawerToggleDelegate() = delegate.drawerToggleDelegate

    override fun requestWindowFeature(featureId: Int) = delegate.requestWindowFeature(featureId)

    override fun hasWindowFeature(featureId: Int) = delegate.hasWindowFeature(featureId)

    override fun startSupportActionMode(callback: ActionMode.Callback) =
        delegate.startSupportActionMode(callback)

    override fun installViewFactory() = delegate.installViewFactory()

    override fun createView(
        parent: View?,
        name: String?,
        context: Context,
        attrs: AttributeSet
    ): View? = delegate.createView(parent, name, context, attrs)

    override fun setHandleNativeActionModesEnabled(enabled: Boolean) {
        delegate.isHandleNativeActionModesEnabled = enabled
    }

    override fun isHandleNativeActionModesEnabled() = delegate.isHandleNativeActionModesEnabled

    override fun onSaveInstanceState(outState: Bundle?) = delegate.onSaveInstanceState(outState)

    override fun applyDayNight() = delegate.applyDayNight()

    override fun setLocalNightMode(mode: Int) {
        delegate.localNightMode = mode
    }

    override fun getLocalNightMode() = delegate.localNightMode
}
