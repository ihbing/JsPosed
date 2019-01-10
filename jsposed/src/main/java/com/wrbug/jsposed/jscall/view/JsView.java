package com.wrbug.jsposed.jscall.view;

import android.view.View;

import com.wrbug.jsposed.JsPosedExecutor;
import com.wrbug.jsposed.NumberUtils;
import com.wrbug.jsposed.jscall.JavaMethod;

import org.mozilla.javascript.Function;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class JsView extends JavaMethod {
    public JsView(JsPosedExecutor jsPosedExecutor, XC_LoadPackage.LoadPackageParam param) {
        super(jsPosedExecutor, param);
    }

    @Override
    public String getName() {
        return "JsView";
    }

    public void setOnclickListener(View view, final Function function) {
        view.setOnClickListener(v -> mJsPosedExecutor.call(function, v));
    }

    public void setOnFocusChangeListener(View view, final Function function) {
        view.setOnFocusChangeListener((v, hasFocus) -> mJsPosedExecutor.call(function, v, hasFocus));
    }

    public void setOnLongClickListener(View view, final Function function) {
        view.setOnLongClickListener(v -> {
            mJsPosedExecutor.call(function, v);
            return false;
        });
    }

    public boolean performLongClick(View view) {
        return view.performLongClick();
    }

    public void setVisibility(View view, Object visibility) {
        view.setVisibility(NumberUtils.toNumber(visibility).intValue());
    }

    public boolean isEnabled(View view) {
        return view.isEnabled();
    }

    public void setEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
    }

    public void setFocusable(View view, boolean focusable) {
        view.setFocusable(focusable);
    }

    public void setPadding(View view, Object left, Object top, Object right, Object bottom) {
        view.setPadding(NumberUtils.toNumber(left).intValue(), NumberUtils.toNumber(top).intValue(), NumberUtils.toNumber(right).intValue(), NumberUtils.toNumber(bottom).intValue());
    }

}