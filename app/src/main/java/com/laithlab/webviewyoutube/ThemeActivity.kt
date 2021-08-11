package com.laithlab.webviewyoutube

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.ContextWrapperDelegate
import com.jcminarro.philology.Philology
import io.github.inflationx.viewpump.ViewPumpContextWrapper

abstract class ThemeActivity : AppCompatActivity() {

    private var baseContextWrappingDelegate: AppCompatDelegate? = null

    override fun getDelegate() =
        baseContextWrappingDelegate
            ?: ContextWrapperDelegate(super.getDelegate()) { context ->
                ViewPumpContextWrapper.wrap(Philology.wrap(context))
            }
                .apply { baseContextWrappingDelegate = this }

}