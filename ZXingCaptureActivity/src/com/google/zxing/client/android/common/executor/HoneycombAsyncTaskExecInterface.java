/*
 * Copyright (C) 2012 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @change
 * 	- Execute task for older versions
 */

package com.google.zxing.client.android.common.executor;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;

/**
 * On Honeycomb and later, {@link AsyncTask} returns to serial execution by default which is undesirable.
 * This calls Honeycomb-only APIs to request parallel execution.
 */
public final class HoneycombAsyncTaskExecInterface implements AsyncTaskExecInterface {

	@Override
	@SuppressLint("NewApi")
	public <T> void execute(AsyncTask<T,?,?> task, T... args) {
		if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB) {
			task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, args);
		}
		else {
			task.execute(args);
		}
	}

}
