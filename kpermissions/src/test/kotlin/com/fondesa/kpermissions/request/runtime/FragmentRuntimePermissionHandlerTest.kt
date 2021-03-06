/*
 * Copyright (c) 2018 Fondesa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.kpermissions.request.runtime

import android.os.Build
import junit.framework.Assert.assertNull
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.FragmentController
import org.robolectric.annotation.Config

/**
 * Tests for [FragmentRuntimePermissionHandler].
 */
@RunWith(RobolectricTestRunner::class)
@Config(minSdk = Build.VERSION_CODES.M)
class FragmentRuntimePermissionHandlerTest {

    private val fragment: FragmentRuntimePermissionHandler = MockFragment()

    @Test
    fun fragmentCreationSuccessful() {
        // Create the Fragment.
        FragmentController.of(fragment).create()
        // The Fragment must retain the instance.
        assertTrue(fragment.retainInstance)
        // It mustn't have a layout.
        assertNull(fragment.view)
    }

    class MockFragment : FragmentRuntimePermissionHandler() {

        override fun handleRuntimePermissions(permissions: Array<out String>) = Unit
        override fun requestRuntimePermissions(permissions: Array<out String>) = Unit
        override fun managePermissionsResult(permissions: Array<out String>, grantResults: IntArray) = Unit
    }
}