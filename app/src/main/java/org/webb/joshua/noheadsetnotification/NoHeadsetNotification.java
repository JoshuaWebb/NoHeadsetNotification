package org.webb.joshua.noheadsetnotification;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;

public class NoHeadsetNotification implements IXposedHookZygoteInit {

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		XposedBridge.log("NoHeadsetNotification loaded");
	}
}
