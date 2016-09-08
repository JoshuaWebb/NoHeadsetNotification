package org.webb.joshua.noheadsetnotification;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class NoHeadsetNotification implements IXposedHookLoadPackage {

	private final static String targetPackage = "com.android.server.telecom";

	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
		if (!targetPackage.equals(lpparam.packageName))
			return;

		String targetClassName = targetPackage + ".TtyManager";
		Class<?> notifierClass = XposedHelpers.findClass(targetClassName, lpparam.classLoader);
		XposedHelpers.findAndHookMethod(notifierClass, "showHeadSetPlugin",
		  new XC_MethodHook() {
			  @Override
			  protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
				  super.beforeHookedMethod(param);
				  param.setResult(null);
			  }
		  }
		);
	}
}
